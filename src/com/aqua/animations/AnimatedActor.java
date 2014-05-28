package com.aqua.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class AnimatedActor extends Actor{

	private AnimationBehavior animationBehavior;
	private float stateTime = 0;
	private int direction = 0;
	
	public AnimatedActor() {
		this.animationBehavior = new DefaultAnimationBehavior();
	}
	
	public AnimatedActor(AnimationBehavior animationBehavior) {
		this.animationBehavior = animationBehavior;
	}
	
	public void setAnimationBehavior(AnimationBehavior animationBehavior) {
		this.animationBehavior = animationBehavior;
	}
	
	@Override
	public void act(float delta) {
		stateTime += delta;
		super.act(delta);
		
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		animationBehavior.Animate(batch, getX(), getY(), getWidth(), getHeight(), stateTime, direction);
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
}
