package com.aqua.entities.enemy.shark;

import com.aqua.entities.Entity;
import com.aqua.entities.states.State;

public class SharkState extends State {

	public static final int SPEED = 100;
	private Shark entity;
	
	
	public SharkState(Entity entity) {
		setEntity(entity);
	}
	
	@Override
	protected void setEntity(Entity entity) {
		this.entity = (Shark) entity;

	}

	@Override
	public void movement(float delta) {
		

	}

}
