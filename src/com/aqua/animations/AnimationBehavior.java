package com.aqua.animations;

import com.badlogic.gdx.graphics.g2d.Batch;

public interface AnimationBehavior {
	
	
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime, int direction);
	

}
