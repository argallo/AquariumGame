package com.aqua.animations;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimateSimpleFish implements AnimationBehavior{
	
	Animation left;
	ArrayFlip flipped;
	Animation right;
	
	public AnimateSimpleFish() {
		left = new Animation(0.03f, (Assets.getInstance().get("PlayerFish/simplefish.atlas", TextureAtlas.class).findRegions("simplefish")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefish.atlas", TextureAtlas.class).findRegions("simplefish"));
		right = new Animation(0.03f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
		
	}

	//animate based on direction
	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime, int direction) {
		if(direction == 3){
			batch.draw(left.getKeyFrame(stateTime), x, y, width, height);
		}
		else{
			batch.draw(right.getKeyFrame(stateTime), x, y, width, height);
		}
		
	}

	
	
	
	

}
