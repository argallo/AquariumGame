package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.states.NormalFishState;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AnimateSickSimpleFish extends AbsFishAnimationBehavior {

	Animation left, turnLeft, biteLeft;
	ArrayFlip flipped, turnFlipped, biteFlipped;
	Animation right, turnRight, biteRight;
	float loopTime = 0;
	float differenceTime = 0;
	boolean turning = false;
	boolean biting = false;

	
	public AnimateSickSimpleFish(Entity entity, int currentDirection) {
		super(entity, currentDirection);
		
		biteRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishsickbite.atlas", TextureAtlas.class).findRegions("simple_fish_sick_bite")));
		biteFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsickbite.atlas", TextureAtlas.class).findRegions("simple_fish_sick_bite"));
		biteLeft = new Animation(0.07f, biteFlipped.getFlipped());
		
		//turning animation
		turnRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishsickflip.atlas", TextureAtlas.class).findRegions("simple_fish_sick_flip")));
		turnFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsickflip.atlas", TextureAtlas.class).findRegions("simple_fish_sick_flip"));
		turnLeft = new Animation(0.07f, turnFlipped.getFlipped());
		
		left = new Animation(0.02f, (Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_sick")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_sick"));
		right = new Animation(0.02f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
		
	}

	//animate based on direction
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

	public void resetLoop(){
		loopTime = 0;
	}


	@Override
	public void turn(int directionHorizontal) {
		if(!biting){
			turning = true;
			resetLoop();
		}
		currentDirection = directionHorizontal;
	}
	
	@Override
	public void bite() {
		biting = true;
		resetLoop();
	}
	
	@Override
	public boolean isTurning() {
		return turning;
	}
	
	@Override
	public boolean isBiting() {
		return biting;
	}
}