package com.aqua.entities;

import com.aqua.animations.BaitAnimation;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;

public abstract class Bait extends Entity{

	public Bait(GameView gameView, int entityId, float x, float y) {
		super(gameView, entityId);
		setSize(Gdx.graphics.getWidth()/24, Gdx.graphics.getWidth()/28);
		setPosition(x-getWidth()/2, y-getHeight()/2);
		setAnimationBehavior(new BaitAnimation());
	}
	



}
