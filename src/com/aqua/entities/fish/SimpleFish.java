package com.aqua.entities.fish;

import com.aqua.entities.PlayerFish;
import com.aqua.entities.states.NormalState;
import com.aqua.gamecomponents.GameView;

public class SimpleFish extends PlayerFish{

	public SimpleFish(GameView gameView, int entityId) {
		super(gameView, entityId);
		setCurrentState(new NormalState());
	}
	

}
