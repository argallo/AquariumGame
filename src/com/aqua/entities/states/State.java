package com.aqua.entities.states;

import com.aqua.entities.Entity;

public abstract class State {
	
	protected Entity entity;
	
	public State(Entity entity) {
		this.entity = entity;
	}
	
	public abstract void movement(float delta);
	

}
