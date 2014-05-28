package com.aqua.gamecomponents;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.aqua.entities.Entity;
import com.badlogic.gdx.scenes.scene2d.Group;

public class GameView extends Group{
	
	HashMap<String, List<Entity>> entityList;
	
	public GameView() {
		
	}
	
	/**
	 * 
	 * @param e will add entity to gameview group and entityList using EntityFactory
	 */
	public void addEntity(String e){
		
	}
	
	/**
	 * Used to remove all types of entities
	 * @param e removes entity e from correct group in entityList and from gameview group
	 */
	public void removeEntity(Entity e){
		Iterator<Entity> list = entityList.get(e.getName()).iterator();
		Entity ent;
		while (list.hasNext()) {
			   ent = list.next();
			   if(ent.getEntityId() == e.getEntityId()){
				   //removes from group
				   this.removeActor(ent);
				   //remove from entityList
				   list.remove();
			   }
			}
	}
	
	/**
	 * 
	 * @param foodName Name of the food list to find
	 * @return the list of that food present in the entityList
	 */
	public List<Entity> getFoodList(String foodName){
		return entityList.get(foodName);
	}
	
	/**
	 * 
	 * @param foodNames Takes in a list of food names
	 * @return Iterates through to add all food lists to a single list
	 */
	public List<Entity> getFoodList(List<String> foodNames){
		if(foodNames != null){
			List<Entity> foods = entityList.get(foodNames.remove(0));
			for(int i = 0; i < foodNames.size(); i++){
				foods.addAll(getFoodList(foodNames.remove(0)));
			}
			return foods;
		}
		return null;
	}
	

}
