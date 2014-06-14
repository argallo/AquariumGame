package com.aqua.animations;

import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class AbsFishAnimationBehavior implements AnimationBehavior{

	int currentDirection;
	public AbsFishAnimationBehavior(int currentDirection) {
		this.currentDirection = currentDirection;
	}
	
	// make non abstract so others can override it 
	public void turn(int directionVerticle) {
	
	}
	
	public void bite(){
		
	}

	public boolean isTurning() {
		return false;
	}
	
	public boolean isBiting(){
		return false;
	}
	
	
	

}
