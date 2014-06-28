package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.PlayerFish;
import com.aqua.entities.states.NormalFishState;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimateSimpleFish extends AbsFishAnimationBehavior{
	
	/**
	 * 
	 * @param entity entity attached to this animation instance
	 * @param currentDirection current direction of the entity and animation
	 */
	private TextureAtlas fishAtlas;
	
	public AnimateSimpleFish(Entity entity, int currentDirection) {
		super(entity, currentDirection);	

		fishAtlas = ((PlayerFish) entity).getFishAtlas();
		
		//biting animation
		biteRight = new Animation(0.07f, fishAtlas.findRegions(entity.getName()+"_bite"));
		biteFlipped = new ArrayFlip(fishAtlas.findRegions(entity.getName()+"_bite"));
		biteLeft = new Animation(0.07f, biteFlipped.getFlipped());
		
		//turning animation
		turnRight = new Animation(0.07f,fishAtlas.findRegions(entity.getName()+"_flip"));
		turnFlipped = new ArrayFlip(fishAtlas.findRegions(entity.getName()+"_flip"));
		turnLeft = new Animation(0.07f, turnFlipped.getFlipped());
		
		//moving animation
		left = new Animation(0.03f, fishAtlas.findRegions(entity.getName()));
		flipped = new ArrayFlip(fishAtlas.findRegions(entity.getName()));
		right = new Animation(0.03f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
		
	}
	

}
