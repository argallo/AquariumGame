package com.aqua.entities.states;

import java.util.List;

import com.aqua.Direction;
import com.aqua.animations.AnimateSickSimpleFish;
import com.aqua.animations.AnimateDeadSimpleFish;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class HungryState extends State{

	public static final int SPEED = 150;
	private final int randomOdds = 97;
	private int hunger = 0;
	private List<Entity> foodList;
	private Entity closestFood;
	
	public HungryState(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}

	
	
	//clean up this code and document it maybe try to figure out what can be put into the state abs class such as update x and y.
	
	@Override
	public void movement(float delta) {
		if(!entity.getAnimationBehavior().isTransition()){
			updateHunger();
			if(!checkFood(delta)){
				if(MathUtils.random(100)>randomOdds){
					generateRandomMovement();
				}
				updateY(delta);
				updateX(delta);
			}
		}
		else{
			checkFood(delta);	
		}
	}

	private boolean checkFood(float delta) {
		foodList = entity.getGameView().getFoodList("starterbait");
		if(foodList == null || foodList.isEmpty()){
			return false;
		}
		closestFood = entity.findClosestEntity(foodList);
		if(entity.collidesWith(closestFood)){
			closestFood.removeThis();
			entity.setCurrentState(new NormalState(entity));
			entity.setAnimationBehavior(new AnimateSimpleFish());
		}
		else{
			if(!entity.getAnimationBehavior().isTransition()){
				if(entity.getX() < closestFood.getX()){
					entity.setX(entity.getX()+(delta*SPEED));
					entity.setDirectionHorizontal(Direction.RIGHT);
				}
				else if(entity.getX() > closestFood.getX()){
					entity.setX(entity.getX()-(delta*SPEED));
					entity.setDirectionHorizontal(Direction.LEFT);
				}
			}
			if(entity.getY() < closestFood.getY()-closestFood.getHeight()){
				entity.setY(entity.getY()+(delta*SPEED));
				entity.setDirectionVerticle(Direction.UP);
			}
			else if(entity.getY() > closestFood.getY()){
				entity.setY(entity.getY()-(delta*SPEED));
				entity.setDirectionVerticle(Direction.DOWN);
			}
		}
		return true;
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
		entity.checkHorizontalWalls();
		horizontalDirection = entity.getDirectionHorizontal();
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
		entity.checkVerticleWalls();
		verticleDirection = entity.getDirectionVerticle();
	}
	



}
