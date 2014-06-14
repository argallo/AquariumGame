package com.aqua.entities;

import com.aqua.Direction;
import com.aqua.animations.AbsFishAnimationBehavior;
import com.aqua.animations.AnimationBehavior;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;

public abstract class PlayerFish extends Entity {

	public PlayerFish(GameView gameView, int entityId) {
		super(gameView, entityId);
		
	}

	@Override
	public AbsFishAnimationBehavior getAnimationBehavior() {
		return (AbsFishAnimationBehavior) super.getAnimationBehavior();
	}
	
	@Override
	public void setDirectionHorizontal(int directionHorizontal) {
		if(getDirectionHorizontal() != directionHorizontal){
			super.setDirectionHorizontal(directionHorizontal);
			turn();
		}
	}
	
	public void turn() {
		getAnimationBehavior().turn(getDirectionHorizontal());
	}
	
	public boolean isTurning() {
		return getAnimationBehavior().isTurning();
	}
	
	public void eat() {
		getAnimationBehavior().bite();
	}
	
	public boolean isEating() {
		return getAnimationBehavior().isBiting();
	}
	
	

}
