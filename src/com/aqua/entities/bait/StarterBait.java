package com.aqua.entities.bait;

import com.aqua.entities.Bait;
import com.aqua.entities.states.BaitState;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;

public class StarterBait extends Bait{

	public StarterBait(GameView gameView, int entityId, float x, float y) {
		super(gameView, entityId, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected State initState() {
		
		return new BaitState(this);
	}

	@Override
	protected String createName() {
		// TODO Auto-generated method stub
		return "starterbait";
	}

}
