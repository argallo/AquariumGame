package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AnimateSickSimpleFish extends AbsFishAnimationBehavior {

	Animation left;
	ArrayFlip flipped;
	Animation right;
	//change to sick images or dont create this just add a boolean on interface 
	public AnimateSickSimpleFish(int currentDirection) {
		super(currentDirection);
		left = new Animation(0.02f, (Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_sick")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_sick"));
		right = new Animation(0.02f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
		
	}

	//animate based on direction
	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime) {
		if(currentDirection == Direction.LEFT){
			batch.draw(left.getKeyFrame(stateTime), x, y, width, height);
		}
		else{
			batch.draw(right.getKeyFrame(stateTime), x, y, width, height);
		}
		
	}

	//will add in later
	@Override
	public void turn(int hdirection) {
		//if(currentDirection != hdirection){
		//	turning = true;
		//	resetLoop();
		//}
		//if(bite){
		//	biting = true;
		//	resetLoop();
		//}
		currentDirection = hdirection;
	}
	
	@Override
	public void bite() {
		//biting = true;
		//resetLoop();
	}
	
	//eventually will be turning animation
	@Override
	public boolean isTurning() {
		return super.isTurning();
	}
	
	

}
