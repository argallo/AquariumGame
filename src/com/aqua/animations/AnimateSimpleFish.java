package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.states.NormalFishState;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimateSimpleFish extends AbsFishAnimationBehavior{
	
	Animation left, turnLeft, biteLeft;
	ArrayFlip flipped, turnFlipped, biteFlipped;
	Animation right, turnRight, biteRight;
	float loopTime = 0;
	float differenceTime = 0;
	boolean turning = false;
	boolean biting = false;
	
	public AnimateSimpleFish(Entity entity, int currentDirection) {
		super(entity, currentDirection);
		//biting animation
		biteRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishbite.atlas", TextureAtlas.class).findRegions("simple_fish_bite")));
		biteFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishbite.atlas", TextureAtlas.class).findRegions("simple_fish_bite"));
		biteLeft = new Animation(0.07f, biteFlipped.getFlipped());
		
		//turning animation
		turnRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishflip.atlas", TextureAtlas.class).findRegions("simple_fish_flip")));
		turnFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishflip.atlas", TextureAtlas.class).findRegions("simple_fish_flip"));
		turnLeft = new Animation(0.07f, turnFlipped.getFlipped());
		
		//moving animation
		left = new Animation(0.03f, (Assets.getInstance().get("PlayerFish/simplefish.atlas", TextureAtlas.class).findRegions("simplefish")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefish.atlas", TextureAtlas.class).findRegions("simplefish"));
		right = new Animation(0.03f, flipped.getFlipped());
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
					biting = false;
					entity.setCurrentState(new NormalFishState(entity));
				}
			}
			else{
				batch.draw(biteLeft.getKeyFrame(loopTime, false), x, y, width, height);
				if(biteLeft.isAnimationFinished(loopTime)){
					entity.setCurrentState(new NormalFishState(entity));
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
