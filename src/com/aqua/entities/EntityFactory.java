package com.aqua.entities;

import com.aqua.GameManager;
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
}
