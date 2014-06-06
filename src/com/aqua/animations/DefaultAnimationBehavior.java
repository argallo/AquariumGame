package com.aqua.animations;

import com.badlogic.gdx.graphics.g2d.Batch;

public class DefaultAnimationBehavior implements AnimationBehavior {

	@Override
	public void Animate(Batch batch, float x, float y, float width,
			float height, float stateTime, int direction) {
		//do nothing default

	}

	@Override
	public boolean isTransition() {
		// TODO Auto-generated method stub
		return false;
	}


}
