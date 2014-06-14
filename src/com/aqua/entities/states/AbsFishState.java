package com.aqua.entities.states;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.PlayerFish;

public abstract class AbsFishState extends State{
	
	protected PlayerFish entity;
	protected int speed;
	
	public AbsFishState(Entity entity, int speed) {
		setEntity(entity);
		this.speed = speed;
	}

	@Override
	protected void setEntity(Entity entity) {
		this.entity = (PlayerFish) entity;
	}
	
	protected void updateX(float delta) {
		switch(horizontalDirection){
		case Direction.LEFT:
			entity.setX(entity.getX()-(delta*speed));
			entity.setDirectionHorizontal(Direction.LEFT);
			break;
		case Direction.RIGHT:
			entity.setX(entity.getX()+(delta*speed));
			entity.setDirectionHorizontal(Direction.RIGHT);
			break;
		}
		entity.checkHorizontalWalls();
		horizontalDirection = entity.getDirectionHorizontal();
	}
	
	protected void updateY(float delta) {
		switch(verticleDirection){
		case Direction.UP:
			entity.setY(entity.getY()+(delta*speed));
			entity.setDirectionVerticle(Direction.UP);
			break;
		case Direction.DOWN:
			entity.setY(entity.getY()-(delta*speed));
			entity.setDirectionVerticle(Direction.DOWN);
			break;
		case Direction.MIDDLE:
			entity.setDirectionVerticle(Direction.MIDDLE);
			break;
		}
		entity.checkVerticleWalls();
		verticleDirection = entity.getDirectionVerticle();
	}

}
