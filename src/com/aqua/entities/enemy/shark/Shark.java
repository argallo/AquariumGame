package com.aqua.entities.enemy.shark;

import com.aqua.entities.EnemyEntity;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;

public class Shark extends EnemyEntity{

	public Shark(GameView gameView, int entityId) {
		super(gameView, entityId);
	
		
	}

	@Override
	protected State initState() {
		return new SharkState();
	}

	@Override
	protected String createName() {
		// TODO Auto-generated method stub
		return "shark";
	}
	
	
	
	

}
