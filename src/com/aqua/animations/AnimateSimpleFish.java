package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.entities.Entity;
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
	public AnimateSimpleFish(Entity entity, int currentDirection) {
		super(entity, currentDirection);
		//biting animation
		biteRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishbite.atlas", TextureAtlas.class).findRegions("simple_fish_bite")));
		biteFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishbite.atlas", TextureAtlas.class).findRegions("simple_fish_bite"));
		biteLeft = new Animation(0.07f, biteFlipped.getFlipped());
		
		//turning animation
		turnRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishflip.atlas", TextureAtlas.class).findRegions("simple_fish_flip")));
		turnFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishflip.atlas", TextureAtlas.class).findRegions("simple_fish_flip"));
		turnLeft = new Animation(0.07f, turnFlipped.getFlipped());
		
		//moving animation
		left = new Animation(0.03f, (Assets.getInstance().get("PlayerFish/simplefish.atlas", TextureAtlas.class).findRegions("simplefish")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefish.atlas", TextureAtlas.class).findRegions("simplefish"));
		right = new Animation(0.03f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
		
	}
	

}
