package com.aqua.entities;

import com.aqua.GameManager;
import com.aqua.entities.bait.StarterBait;
import com.aqua.entities.money.SilverCoin;
import com.aqua.entities.simplefish.SimpleFish;
import com.aqua.gamecomponents.GameView;

/**
 * 
 * @author Gallo
 *
 */
public class EntityFactory {
	
	GameManager gameManager = GameManager.getInstance();
	
	public EntityFactory() {
		
	}

	/**
	 * 
	 * @param entityName name to take into factory which determines which entity is created
	 * @param g the gameview that will be used in each entity
	 * @return a new entity with a unique id 
	 */
	public Entity createEntity(String entityName, GameView g){
		if(entityName.equals("simplefish")){
			return new SimpleFish(g, gameManager.newEntityId());
		}
		else {
			return null;
		}
	}
/**
 * 
 * @param entityName name to take into factory which determines which entity is created
 * @param g the gameview that will be used in each entity
 * @param x x position for entity to be created at
 * @param y y positon for entity to be created at 
 * @return a new entity with a unique id at a specific location
 */
	public Entity createEntity(String entityName, GameView g, float x, float y) {
		if(entityName.equals("starterbait")){
			return new StarterBait(g, gameManager.newEntityId(), x, y);
		}
		else if(entityName.equals("silvercoin")){
			return new SilverCoin(g, gameManager.newEntityId(), x, y);
		}
		else{
			return null;
		}
	}
}
