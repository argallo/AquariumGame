package com.aqua.entities;

import com.aqua.GameManager;
import com.aqua.entities.fish.SimpleFish;
import com.aqua.gamecomponents.GameView;

public class EntityFactory {

	GameManager gameManager = GameManager.getInstance();

	public EntityFactory() {
		
	}

	
	public Entity createEntity(String entityName, GameView g){
		if(entityName.equals("simplefish")){
			return new SimpleFish(g, gameManager.newEntityId());
		}
		else {
			return null;
		}
	}
}
