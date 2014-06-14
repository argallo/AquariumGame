package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AnimateDeadSimpleFish extends AbsFishAnimationBehavior{
	
	Animation left;
	ArrayFlip flipped;
	Animation right;


	public AnimateDeadSimpleFish(int currentDirection) {
		super(currentDirection);
		left = new Animation(0.02f, (Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_dead")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_dead"));
		right = new Animation(0.02f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
	}
	
	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime) {
			if(currentDirection == Direction.RIGHT){
				batch.draw(right.getKeyFrame(stateTime), x, y, width, height);
			}
			else{
				batch.draw(left.getKeyFrame(stateTime), x, y, width, height);
			}		
	}

}
