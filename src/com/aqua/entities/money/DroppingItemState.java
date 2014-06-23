package com.aqua.entities.money;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.states.State;
import com.badlogic.gdx.Gdx;

public class DroppingItemState extends State {
	
	public static final int SPEED = 100;
	public final int GRACEPERIOD = 50;
	
	private int graceCounter = 0;
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
		if(checkRemove()){
			updateY(delta);
		}
	}

	/**
	 * 
	 * @param delta
	 */
	private void updateY(float delta) {
		entity.setY(entity.getY()-(delta*SPEED));
		entity.setDirectionVerticle(Direction.DOWN);
	}
	
	private boolean checkRemove() {
		if((entity.getY()+((AbsDropItems) entity).getOffset())<= 0){
			if(graceCounter > GRACEPERIOD){
				entity.remove();
			}
			graceCounter++;
			entity.setY(0-((AbsDropItems) entity).getOffset());
			return false;
		}
		return true;
	}


}
