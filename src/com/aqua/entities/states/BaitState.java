package com.aqua.entities.states;

import com.aqua.Direction;
import com.aqua.entities.Entity;

public class BaitState extends State {
	
	public static final int SPEED = 80;
	Entity entity;

	public BaitState(Entity entity) {
		super();
		this.entity = entity;
	}

	@Override
	public void movement(float delta) {
		updateY(delta);
		checkRemove();
	}

	private void checkRemove() {
		if(entity.getY()<= 0){
			entity.removeThis();
		}
	}

	private void updateY(float delta) {
		entity.setY(entity.getY()-(delta*SPEED));
		entity.setDirectionVerticle(Direction.DOWN);
	}

	@Override
	public void setEntity(Entity entity) {
		// TODO Auto-generated method stub
		
	}



}
