package ca.bc.southridge.ccc.game2d.entities;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ca.bc.southridge.ccc.game2d.Handler;
import ca.bc.southridge.ccc.game2d.entities.dynamics.Player;
import ca.bc.southridge.ccc.game2d.utils.datastructures.QuadTree;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private List<Entity> entities, rOrder; // TODO: Implement more efficient (hopefully) O(1) entity addition and removal
	private QuadTree colTree;
	
	// Comparator for sorting the entities in the ArrayList by their bottom y coordinates
	private Comparator<Entity> rS = new Comparator<Entity>() {
		@Override
		public int compare(Entity a, Entity b) {
			float c = a.getPosition().getY() + a.getHeight();
			float d = b.getPosition().getY() + b.getHeight();
			if(c < d)
				return -1;
			else if(c > d)
				return 1;
			return 0;
		}
	};
	
	public EntityManager(Handler handler, Player player) {
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		rOrder = new ArrayList<Entity>();
		addEntity(player);
		colTree = handler.getWorld().getColTree();
	}
	
	public void tick() {
		colTree.clear();
		rOrder.clear();
		for(int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			colTree.insert(e.getColBox(0, 0));
			e.tick();
			if(e.getManaged())
				rOrder.add(e);
		}
		// Fixes render order
		rOrder.sort(rS);
	}
	
	public void render(Graphics g) {
		for(Entity e : rOrder) {
			e.render(g);
		}
	}
	
	public void addEntity(Entity e) {
		entities.add(e);
		e.setID(entities.size() - 1);
	}
	
	public void removeEntity(Entity e) {
		if(e.getID() < 0 || e.getID() >= entities.size())
			return;
		
		for(int i = e.getID() + 1; i < entities.size(); i++)
			entities.get(i).setID(entities.get(i).getID() - 1);
		entities.remove(e.getID());
		e.unmanage();
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(List<Entity> entities) {
		this.entities = entities;
	}

}
