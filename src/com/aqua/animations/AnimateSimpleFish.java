package com.aqua.animations;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimateSimpleFish implements AnimationBehavior{
	
	//add actual after
	Animation left = new Animation(0.3f, new TextureRegion());
	//new flipedTextureRegion() implement
	Animation right = new Animation(0.3f, new TextureRegion());
	
	
	public AnimateSimpleFish() {
	
	}

	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime, int direction) {
	
		
	}

	
	
	
	

}
