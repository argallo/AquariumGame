package com.aqua.entities.money;

import com.aqua.entities.Entity;
import com.aqua.entities.states.State;

public class DroppingItemState extends State {
	
	Entity entity;
	public DroppingItemState(Entity entity) {
		setEntity(entity);
	}
	
	@Override
	protected void setEntity(Entity entity) {
		this.entity = entity;

	}

	@Override
	public void movement(float delta) {
		

	}

}
