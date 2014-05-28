package com.aqua.gamecomponents;

import com.aqua.animations.AnimatedActor;
import com.aqua.animations.BackgroundAnimationBehavior;
import com.badlogic.gdx.Gdx;

public class Background extends AnimatedActor{
	
	
	public Background() {
		super();
		setPosition(0, 0);
		setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		setAnimationBehavior(new BackgroundAnimationBehavior());
	}

}
