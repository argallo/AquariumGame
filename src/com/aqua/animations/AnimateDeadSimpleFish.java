package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AnimateDeadSimpleFish extends AbsFishAnimationBehavior{
	
	
	public AnimateDeadSimpleFish(Entity entity ,int currentDirection) {
		super(entity, currentDirection);
		left = new Animation(0.02f, (Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_dead")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_dead"));
		right = new Animation(0.02f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
	}
	
	
	/**
	 * Override animate so that only floats up without any moving
	 */
	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime) {
			if(currentDirection == Direction.RIGHT){
				batch.draw(right.getKeyFrame(stateTime), x, y, width, height);
			}
			else{
				batch.draw(left.getKeyFrame(stateTime), x, y, width, height);
			}		
	}
	
	/**
	 * no biting
	 */
	@Override
	public boolean isBiting() {
		return false;
	}
	
	/**
	 * no turning
	 */
	@Override
	public boolean isTurning() {
		return false;
	}
	
	/**
	 * cant bite when dead
	 */
	@Override
	public void bite() {
	}
	
	/**
	 * cant turn when dead
	 */
	@Override
	public void turn(int directionHorizontal) {
	}

}
