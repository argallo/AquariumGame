package com.aqua.animations;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.entities.Entity;
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
	public AnimateSickSimpleFish(Entity entity, int currentDirection) {
		super(entity, currentDirection);
		
		biteRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishsickbite.atlas", TextureAtlas.class).findRegions("simple_fish_sick_bite")));
		biteFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsickbite.atlas", TextureAtlas.class).findRegions("simple_fish_sick_bite"));
		biteLeft = new Animation(0.07f, biteFlipped.getFlipped());
		
		//turning animation
		turnRight = new Animation(0.07f, (Assets.getInstance().get("PlayerFish/simplefishsickflip.atlas", TextureAtlas.class).findRegions("simple_fish_sick_flip")));
		turnFlipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsickflip.atlas", TextureAtlas.class).findRegions("simple_fish_sick_flip"));
		turnLeft = new Animation(0.07f, turnFlipped.getFlipped());
		
		left = new Animation(0.02f, (Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_sick")));
		flipped = new ArrayFlip(Assets.getInstance().get("PlayerFish/simplefishsick.atlas", TextureAtlas.class).findRegions("simple_fish_sick"));
		right = new Animation(0.02f, flipped.getFlipped());
		left.setPlayMode(Animation.LOOP);
		right.setPlayMode(Animation.LOOP);
		
	}
	
}