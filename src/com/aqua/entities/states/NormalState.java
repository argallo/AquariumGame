package com.aqua.entities.states;

import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class NormalState extends State{

	private static final int UP = 0;
	private static final int DOWN = 1;
	private static final int MIDDLE = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;
	private static final int SPEED = 20;
	private int verticleDirection = 2;
	private int horizontalDirection = 2;
	

	public NormalState(Entity entity) {
		super(entity);
		
	}
	
	//swap entity to constructor
	@Override
	public void movement(float delta) {
		verticleDirection = MathUtils.random(2);
		updateY(delta);
		horizontalDirection = MathUtils.random(2)+2;
		updateX(delta);
		entity.checkWalls();
	}

	private void updateX(float delta) {
		switch(horizontalDirection){
		case LEFT:
			entity.setX(entity.getX()-(delta*SPEED));
			entity.setDirection(LEFT);
			break;
		case RIGHT:
			entity.setX(entity.getX()+(delta*SPEED));
			entity.setDirection(RIGHT);
			break;
		case MIDDLE:
			
			break;
		}
	}

	private void updateY(float delta) {
		switch(verticleDirection){
		case UP:
			entity.setY(entity.getY()+(delta*SPEED));
			break;
		case DOWN:
			entity.setY(entity.getY()-(delta*SPEED));
			break;
		case MIDDLE:
			
			break;
		}
	}
	
	


}
