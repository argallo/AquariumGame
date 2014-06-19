package com.aqua.entities.money;

import com.aqua.entities.Entity;
import com.aqua.entities.states.State;
import com.badlogic.gdx.Gdx;

public class DropItemClickState extends State {

	private static final float DEFAULTX = Gdx.graphics.getWidth();
	private static final float DEFAULTY = Gdx.graphics.getHeight()-5;
	private static final float SPEED = 1000;
	Entity entity;
	float xDiff, yDiff;
	
	public DropItemClickState(Entity entity) {
		setEntity(entity);
	}
	
	@Override
	protected void setEntity(Entity entity) {
		this.entity = entity;

	}

	@Override
	public void movement(float delta) {
		if(entity.getX()< DEFAULTX){
			xDiff = DEFAULTX-entity.getX();
		}
		if(entity.getY() < DEFAULTY){
			yDiff = DEFAULTY-entity.getY();
		}
		calculateMove(delta);
	}

	private void calculateMove(float delta) {
		if(xDiff/yDiff > 1){
			entity.setX(entity.getX()+((xDiff/yDiff)*SPEED*delta));
			entity.setY(entity.getY()+1*SPEED*delta);
		}
		else if(yDiff/xDiff > 1){
				entity.setY(entity.getY()+((yDiff/xDiff)*SPEED*delta));
				entity.setX(entity.getX()+1*SPEED*delta);
		}
		else{
			entity.setY(entity.getY()+1*SPEED*delta);
			entity.setX(entity.getX()+1*SPEED*delta);
		}
		
	}

}
