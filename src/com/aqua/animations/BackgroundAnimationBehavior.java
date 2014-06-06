package com.aqua.animations;

import com.badlogic.gdx.graphics.g2d.Batch;

public class BackgroundAnimationBehavior implements AnimationBehavior {

	
	//need texture region to draw background with floating bubbles
	
	@Override
	public void Animate(Batch batch, float x, float y, float width,
			float height, float stateTime, int direction) {
		
	}

	@Override
	public boolean isTransition() {
		return false;
	}



}
