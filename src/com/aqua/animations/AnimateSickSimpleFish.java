package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.aqua.entities.PlayerFish;
import com.aqua.entities.states.NormalFishState;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AnimateSickSimpleFish extends AbsFishAnimationBehavior {

	/**
	 * 
	 * @param entity entity attached to this animation instance
	 * @param currentDirection current direction of the entity and animation
	 */
	TextureAtlas fishSickAtlas; 
	
	public AnimateSickSimpleFish(Entity entity, int currentDirection) {
		super(entity, currentDirection);
		fishSickAtlas = ((PlayerFish) entity).getFishAtlas();

		biteRight = new Animation(0.07f, fishSickAtlas.findRegions(entity.getEntityName()+"_sick_bite"));
		biteFlipped = new ArrayFlip(fishSickAtlas.findRegions(entity.getEntityName()+"_sick_bite"));
		biteLeft = new Animation(0.07f, biteFlipped.getFlipped());
		
		//turning animation
		turnRight = new Animation(0.07f, fishSickAtlas.findRegions(entity.getEntityName()+"_sick_flip"));
		turnFlipped = new ArrayFlip(fishSickAtlas.findRegions(entity.getEntityName()+"_sick_flip"));
		turnLeft = new Animation(0.07f, turnFlipped.getFlipped());
		
		left = new Animation(0.02f, fishSickAtlas.findRegions(entity.getEntityName()+"_sick"));
		flipped = new ArrayFlip(fishSickAtlas.findRegions(entity.getEntityName()+"_sick"));
		right = new Animation(0.02f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
		
	}
	
}