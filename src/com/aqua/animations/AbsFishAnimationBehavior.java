package com.aqua.animations;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.states.NormalFishState;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class AbsFishAnimationBehavior implements AnimationBehavior{

	Animation left, turnLeft, biteLeft;
	ArrayFlip flipped, turnFlipped, biteFlipped;
	Animation right, turnRight, biteRight;
	int currentDirection;
	Entity entity;
	float loopTime = 0;
	float differenceTime = 0;
	boolean turning = false;
	boolean biting = false;
	
	public AbsFishAnimationBehavior(Entity entity, int currentDirection) {
		this.currentDirection = currentDirection;
		this.entity = entity;
	}
	
	/**
	 * takes in animate parameters and determines whether animation should be biting turning or moving
	 */
	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime) {
		differenceTime = stateTime - differenceTime;
		loopTime+=differenceTime;
		if(biting){
			if(currentDirection == Direction.LEFT){
				batch.draw(biteRight.getKeyFrame(loopTime, false), x, y, width, height);
				if(biteRight.isAnimationFinished(loopTime)){
					entity.setCurrentState(new NormalFishState(entity));
					entity.setAnimationBehavior(new AnimateSimpleFish(entity, currentDirection));
					biting = false;
				}
			}
			else{
				batch.draw(biteLeft.getKeyFrame(loopTime, false), x, y, width, height);
				if(biteLeft.isAnimationFinished(loopTime)){
					entity.setCurrentState(new NormalFishState(entity));
					entity.setAnimationBehavior(new AnimateSimpleFish(entity, currentDirection));
					biting = false;
				}
			}
		}
		else if(turning){
			if(currentDirection == Direction.RIGHT){
				batch.draw(turnRight.getKeyFrame(loopTime, false), x, y, width, height);
				if(turnRight.isAnimationFinished(loopTime)){
					turning = false;
				}
			}
			else{
				batch.draw(turnLeft.getKeyFrame(loopTime, false), x, y, width, height);
				if(turnLeft.isAnimationFinished(loopTime)){
					turning = false;
				}
			}
		}
		else{
			if(currentDirection == Direction.RIGHT){
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
	 * set turning to true
	 * @param directionHorizontal the new direction the animation will be going
	 */
	public void turn(int directionHorizontal) {
		if(!biting){
			turning = true;
			resetLoop();
		}
		currentDirection = directionHorizontal;
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
	 * @return if the entity is in the turning state
	 */
	public boolean isTurning() {
		return turning;
	}
	
	/**
	 * 
	 * @return if the entity is in the biting state
	 */
	public boolean isBiting(){
		return biting;
	}
	
	
	

}
