package com.aqua.entities;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.animations.AbsFishAnimationBehavior;
import com.aqua.animations.AnimationBehavior;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public abstract class PlayerFish extends Entity {

	
	private TextureAtlas fishAtlas;
	
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
	
	public TextureAtlas getFishAtlas() {
		return fishAtlas;
	}
	
	public void setFishAtlas(TextureAtlas fishAtlas) {
		this.fishAtlas = fishAtlas;
	}
	

}
