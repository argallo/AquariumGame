package com.aqua.animations;

import com.aqua.entities.Entity;
import com.badlogic.gdx.graphics.g2d.Batch;

public abstract class AbsFishAnimationBehavior implements AnimationBehavior{

	int currentDirection;
	Entity entity;
	
	public AbsFishAnimationBehavior(Entity entity, int currentDirection) {
		this.currentDirection = currentDirection;
		this.entity = entity;
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
