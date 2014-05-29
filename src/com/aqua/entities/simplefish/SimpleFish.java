package com.aqua.entities.simplefish;

import com.aqua.animations.AnimateSimpleFish;
import com.aqua.entities.PlayerFish;
import com.aqua.entities.states.NormalState;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class SimpleFish extends PlayerFish{

	public SimpleFish(GameView gameView, int entityId) {
		super(gameView, entityId);
		// default size of a simplefish
		setSize(Gdx.graphics.getWidth()/16, Gdx.graphics.getHeight()/12);
		// sets the position to a random place in gameview
		setPosition(MathUtils.random(gameView.getWidth()-this.getWidth()),MathUtils.random(gameView.getHeight()-this.getHeight()));
		//starting animation for simplefish
		setAnimationBehavior(new AnimateSimpleFish());
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
