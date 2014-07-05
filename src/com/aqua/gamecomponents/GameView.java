package com.aqua.gamecomponents;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.aqua.GameManager;
import com.aqua.entities.Entity;
import com.aqua.entities.EntityFactory;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameView extends Group {

	HashMap<String, List<Entity>> entityList;
	EntityFactory entityFactory;
	List<Entity> foods;

	public GameView() {
		entityFactory = new EntityFactory();
		entityList = new HashMap<String, List<Entity>>();
		setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		setPosition(0, 0);
		this.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// fix subtracting money
				if (GameManager.getInstance().getCurrentScore() > 100)
					addEntity("starterbait", x, y);

			}
		});
	}

	/**
	 * 
	 * @param e
	 *            will add entity to gameview group and entityList using
	 *            EntityFactory at a specific position
	 */
	public void addEntity(String e, float x, float y) {
		Entity entity = entityFactory.createEntity(e, this, x, y);
		if (entityList.get(e) == null) {
			entityList.put(e, new LinkedList<Entity>());
		}
		entityList.get(e).add(entity);
		this.addActor(entity);
	}

	/**
	 * 
	 * @param e
	 *            will add entity to gameview group and entityList using
	 *            EntityFactory
	 */
	public void addEntity(String e) {
		Entity entity = entityFactory.createEntity(e, this);
		if (entityList.get(e) == null) {
			entityList.put(e, new LinkedList<Entity>());
		}
		entityList.get(e).add(entity);
		this.addActor(entity);
	}

	/**
	 * Used to remove all types of entities
	 * 
	 * @param e
	 *            removes entity e from correct group in entityList and from
	 *            gameview group
	 */
	public void removeEntity(Entity e) {
		Iterator<Entity> list = entityList.get(e.getEntityName()).iterator();
		Entity ent;
		while (list.hasNext()) {
			ent = list.next();
			if (ent.getEntityId() == e.getEntityId()) {
				// removes from group
				this.removeActor(ent);
				// remove from entityList
				list.remove();
			}
		}
	}

	/**
	 * 
	 * @param foodName
	 *            Name of the food list to find
	 * @return the list of that food present in the entityList
	 */
	public List<Entity> getFoodList(String foodName) {
		if (entityList.get(foodName) == null) {
			return null;
		}
		return entityList.get(foodName);
	}

	/**
	 * 
	 * @param foodNames
	 *            Takes in a list of food names
	 * @return Iterates through to add all food lists to a single list
	 */
	public List<Entity> getFoodList(List<String> foodNames) {
	
		if (foodNames != null) {
			foods = null;
			foods = new LinkedList<Entity>();
			if(entityList.get(foodNames.get(0)) != null){
				foods.addAll(entityList.get(foodNames.get(0)));
			}
			for (int i = 1; i < foodNames.size(); i++) {
				if(entityList.get(foodNames.get(i)) != null){
					foods.addAll(getFoodList(foodNames.get(i)));
				}
			}
			System.out.println("not null ");
			return foods;
		}
		System.out.println("null ");
		return null;
	}

	/**
	 * 
	 * @param currentEntityName
	 *            original name of entity before swap
	 * @param newEntityName
	 * @param entity
	 */
	public void entitySwap(String currentEntityName, String newEntityName, Entity entity) {
		Iterator<Entity> list = entityList.get(currentEntityName).iterator();
		Entity ent;
		while (list.hasNext()) {
			ent = list.next();
			if (ent.getEntityId() == entity.getEntityId()) {
				list.remove();
				if (entityList.get(newEntityName) == null) {
					entityList.put(newEntityName, new LinkedList<Entity>());
				}
				entityList.get(newEntityName).add(entity);
				break;
			}
		}
	}

}
