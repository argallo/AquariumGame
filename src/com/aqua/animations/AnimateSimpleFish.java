package com.aqua.animations;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimateSimpleFish implements AnimationBehavior{
	
	Animation left, turnLeft;
	ArrayFlip flipped, turnFlipped;
	Animation right, turnRight;
	int currentDirection = 0;
	boolean turning = false;
	float loopTime = 0;
	float differenceTime = 0;
	
	
	public AnimateSimpleFish() {
		
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
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime, int direction) {
		differenceTime = stateTime - differenceTime;
		loopTime+=differenceTime;
		if(direction != currentDirection){
			turning = true;
			resetLoop();
		}
		
		
		if(turning){
			if(currentDirection == 4){
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
			if(direction == 3){
				batch.draw(left.getKeyFrame(stateTime), x, y, width, height);
			}
			else{
				batch.draw(right.getKeyFrame(stateTime), x, y, width, height);
			}	
		}
		currentDirection = direction;
		differenceTime = stateTime;
		
	}

	public void resetLoop(){
		loopTime = 0;
	}

	@Override
	public boolean isTransition() {
		return turning;
	}
	
	
	
	

}
