package com.aqua.entities.states;

import com.aqua.Direction;
import com.aqua.animations.AnimateSickSimpleFish;
import com.aqua.animations.AnimateDeadSimpleFish;
import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class HungryState extends State{

	public static final int SPEED = 200;
	private final int randomOdds = 97;
	private int hunger = 0;
	
	public HungryState(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void movement(float delta) {
		if(!entity.getAnimationBehavior().isTransition()){
		updateHunger();
		if(MathUtils.random(100)>randomOdds){
			generateRandomMovement();
		}
		updateY(delta);
		updateX(delta);
		entity.checkHorizontalWalls();
		entity.checkVerticleWalls();
		verticleDirection = entity.getDirectionVerticle();
		horizontalDirection = entity.getDirectionHorizontal();
		}
	}

	private void updateHunger() {
		hunger++;
		if(hunger == 300){
			entity.setAnimationBehavior(new AnimateSickSimpleFish());
		}
		if(hunger == 600){
			entity.setAnimationBehavior(new AnimateDeadSimpleFish());
			entity.setCurrentState(new DeadState(entity));
		}
		
	}

	private void updateX(float delta) {
		switch(horizontalDirection){
		case Direction.LEFT:
			entity.setX(entity.getX()-(delta*SPEED));
			entity.setDirectionHorizontal(Direction.LEFT);
			break;
		case Direction.RIGHT:
			entity.setX(entity.getX()+(delta*SPEED));
			entity.setDirectionHorizontal(Direction.RIGHT);
			break;
		}
	}

	private void updateY(float delta) {
		switch(verticleDirection){
		case Direction.UP:
			entity.setY(entity.getY()+(delta*SPEED));
			entity.setDirectionVerticle(Direction.UP);
			break;
		case Direction.DOWN:
			entity.setY(entity.getY()-(delta*SPEED));
			entity.setDirectionVerticle(Direction.DOWN);
			break;
		case Direction.MIDDLE:
			entity.setDirectionVerticle(Direction.MIDDLE);
			break;
		}
	}
	



}
