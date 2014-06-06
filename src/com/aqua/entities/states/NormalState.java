package com.aqua.entities.states;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class NormalState extends State{

	
	public static final int SPEED = 100;
	private final int randomOdds = 97;
	private int hunger = 0;


	public NormalState(Entity entity) {
		super(entity);
		generateRandomMovement();
		
	}
	
	//swap entity to constructor
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
		//might need to delta this
		if(hunger == 800){
			entity.setCurrentState(new HungryState(entity));
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
