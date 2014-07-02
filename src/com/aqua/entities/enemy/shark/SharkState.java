package com.aqua.entities.enemy.shark;

import java.util.List;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.states.NormalFishState;
import com.aqua.entities.states.State;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;

public class SharkState extends State {

	public static final int SPEED = 200;
	private Shark entity;
	private List<Entity> foodList;
	private Entity closestFood;
	
	
	public SharkState(Entity entity) {
		setEntity(entity);
	}
	
	@Override
	protected void setEntity(Entity entity) {
		this.entity = (Shark) entity;

	}

	@Override
	public void movement(float delta) {
		checkFood();
		switch(entity.getDirectionHorizontal()){
		case Direction.LEFT:
			if(entity.getX()+ entity.getWidth() < 0){
				entity.removeThis();
				break;
			}
			entity.setX(entity.getX()-(delta*SPEED));
			break;
		case Direction.RIGHT:
			if(entity.getX() > Gdx.graphics.getWidth()){
				entity.removeThis();
				break;
			}
			entity.setX(entity.getX()+(delta*SPEED));
			break;
		}
	}

	private boolean checkFood() {
		foodList = entity.getGameView().getFoodList(entity.getEntityFoodList());
		if(foodList == null || foodList.isEmpty()){
			return false;
		}
		closestFood = entity.findClosestEntity(foodList);
		if(entity.collidesWith(closestFood)){
			closestFood.removeThis();
			System.out.println(foodList);
			entity.eat();
		}
		return true;
	}

}
