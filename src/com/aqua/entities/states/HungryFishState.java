package com.aqua.entities.states;

import java.util.List;

import com.aqua.Direction;
import com.aqua.animations.AnimateSickSimpleFish;
import com.aqua.animations.AnimateDeadSimpleFish;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class HungryFishState extends AbsFishState{

	public static final int SPEED = 150;
	private final int randomOdds = 97;
	private int hunger = 0;
	private List<Entity> foodList;
	private Entity closestFood;

	public HungryFishState(Entity entity) {
		super(entity, SPEED);
	}
	//clean up this code and document it maybe try to figure out what can be put into the state abs class such as update x and y.
	@Override
	public void movement(float delta) {
		if(!entity.isTurning()){
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
			entity.eat();
		}
		else{
			if(!entity.isTurning()){
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
			entity.setAnimationBehavior(new AnimateSickSimpleFish(entity, entity.getDirectionHorizontal()));
		}
		if(hunger == 600){
			entity.setAnimationBehavior(new AnimateDeadSimpleFish(entity, entity.getDirectionHorizontal()));
			entity.setCurrentState(new DeadFishState(entity));
		}
	}
}
