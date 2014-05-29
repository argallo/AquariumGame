package com.aqua.entities.states;

import com.aqua.Direction;
import com.aqua.animations.AnimateSickSimpleFish;
import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class HungryState extends State{

	
	private int verticleDirection = 2;
	private int horizontalDirection = 2;
	private int hunger = 0;
	
	public HungryState(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void movement(float delta) {
		hunger++;
		//might need to delta this
		if(hunger == 500){
			entity.setAnimationBehavior(new AnimateSickSimpleFish());
		}
		if(MathUtils.random(100)>97){
			verticleDirection = MathUtils.random(2);
			horizontalDirection = MathUtils.random(1)+3;
		}
		updateY(delta);
		updateX(delta);
		entity.checkHorizontalWalls();
		entity.checkVerticleWalls();
		verticleDirection = entity.getDirectionVerticle();
		horizontalDirection = entity.getDirectionHorizontal();
	}

	private void updateX(float delta) {
		
		switch(horizontalDirection){
		case Direction.LEFT:
			entity.setX(entity.getX()-(delta*Direction.SPEED*2));
			entity.setDirectionHorizontal(Direction.LEFT);
			break;
		case Direction.RIGHT:
			entity.setX(entity.getX()+(delta*Direction.SPEED*2));
			entity.setDirectionHorizontal(Direction.RIGHT);
			break;
		}
	}

	private void updateY(float delta) {
		switch(verticleDirection){
		case Direction.UP:
			entity.setY(entity.getY()+(delta*Direction.SPEED*2));
			entity.setDirectionVerticle(Direction.UP);
			break;
		case Direction.DOWN:
			entity.setY(entity.getY()-(delta*Direction.SPEED*2));
			entity.setDirectionVerticle(Direction.DOWN);
			break;
		case Direction.MIDDLE:
			entity.setDirectionVerticle(Direction.MIDDLE);
			break;
		}
	}
	



}
