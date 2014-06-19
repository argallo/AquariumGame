package com.aqua.entities.money;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.states.State;

public class DroppingItemState extends State {
	
	public static final int SPEED = 100;
	
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
		updateY(delta);
		checkRemove();
	}

	private void updateY(float delta) {
		entity.setY(entity.getY()-(delta*SPEED));
		entity.setDirectionVerticle(Direction.DOWN);
	}
	
	private void checkRemove() {
		if(entity.getY()<= 0){
			entity.removeThis();
		}
	}


}
