package com.aqua.entities.states;

import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public abstract class State {
	
	protected Entity entity;
	protected int verticleDirection;
	protected int horizontalDirection;
	
	public State(Entity entity) {
		this.entity = entity;
	}
	
	public abstract void movement(float delta);
	
	public void generateRandomMovement(){
		verticleDirection = MathUtils.random(2);
		horizontalDirection = MathUtils.random(1)+3;
	}
	

}
