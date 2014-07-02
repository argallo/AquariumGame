package com.aqua.entities.enemy.shark;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.animations.AnimationBehavior;
import com.aqua.animations.ArrayFlip;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AnimateShark implements AnimationBehavior {
	
	private int horizontalDirection;
	private Shark shark;
	private TextureAtlas sharkAtlas = Assets.getInstance().get("Enemy/Shark/shark.atlas", TextureAtlas.class);
	private Animation biteRight, biteLeft, left, right;
	private ArrayFlip flipped, biteFlipped;
	private boolean biting = false;
	private float loopTime = 0;
	private float differenceTime = 0;
	
	public AnimateShark(Shark shark, int horizontalDirection) {
		this.horizontalDirection = horizontalDirection;
		this.shark = shark;
		//biting animation
		biteRight = new Animation(0.07f, sharkAtlas.findRegions(shark.getName()+"_bite"));
		biteFlipped = new ArrayFlip(sharkAtlas.findRegions(shark.getName()+"_bite"));
		biteLeft = new Animation(0.07f, biteFlipped.getFlipped());
		
		//moving animation
		left = new Animation(0.09f, sharkAtlas.findRegions(shark.getName()));
	    flipped = new ArrayFlip(sharkAtlas.findRegions(shark.getName()));
		right = new Animation(0.09f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
	
	}

	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime) {
		differenceTime = stateTime - differenceTime;
		loopTime+=differenceTime;
		if(biting){
			if(horizontalDirection == Direction.LEFT){
				batch.draw(biteRight.getKeyFrame(loopTime, false), x, y, width, height);
				if(biteRight.isAnimationFinished(loopTime)){
					biting = false;
				}
			}
			else{
				batch.draw(biteLeft.getKeyFrame(loopTime, false), x, y, width, height);
				if(biteLeft.isAnimationFinished(loopTime)){
					biting = false;
				}
			}
		}
		else{
			if(horizontalDirection == Direction.RIGHT){
				batch.draw(right.getKeyFrame(stateTime), x, y, width, height);
			}
			else{
				batch.draw(left.getKeyFrame(stateTime), x, y, width, height);
			}	
		}
		differenceTime = stateTime;

	}
	
	
	
	/**
	 * resets the loop for turning and biting keyframes
	 */
	public void resetLoop(){
		loopTime = 0;
	}
	
	/**
	 * starts biting animation
	 */
	public void bite(){
		biting = true;
		resetLoop();
	}
	
	/**
	 * 
	 * @return if the entity is in the biting state
	 */
	public boolean isBiting(){
		return biting;
	}

}
