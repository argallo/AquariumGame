package com.aqua.entities.fish;

import com.aqua.entities.PlayerFish;
import com.aqua.entities.states.NormalState;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;

public class SimpleFish extends PlayerFish{

	public SimpleFish(GameView gameView, int entityId) {
		super(gameView, entityId);
	}

	@Override
	protected String createName() {
		return "simplefish";
	}

	@Override
	protected State initState() {
		return new NormalState(this);
	}
	
	

}
