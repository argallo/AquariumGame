package com.aqua.entities.states;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class DeadFishState extends AbsFishState{
	
	public static final int SPEED = 150;

	public DeadFishState(Entity entity) {
		super(entity, SPEED);
		entity.setDirectionVerticle(Direction.UP);	
	}


	@Override
	public void movement(float delta) {
		updateY(delta);
		checkRemove();
	}


	/**
	 * checks when the entity has floated above the screen to then be removed.
	 */
	private void checkRemove() {
		if(entity.getY()>entity.getGameView().getHeight()+entity.getHeight()){
			entity.removeThis();
		}
	}


	/**
	 * updates Y direction to float fish off the screen
	 * @param delta update variable
	 */
	@Override
	protected void updateY(float delta) {
			entity.setY(entity.getY()+(delta*SPEED));
			entity.setDirectionVerticle(Direction.UP);
	}
	

}
