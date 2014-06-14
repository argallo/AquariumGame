package com.aqua.entities.states;

import com.aqua.Direction;
import com.aqua.entities.Entity;
import com.badlogic.gdx.math.MathUtils;

public class NormalFishState extends AbsFishState{

	
	public static final int SPEED = 100;
	private final int randomOdds = 97;
	private int hunger = 0;


	public NormalFishState(Entity entity) {
		super(entity, SPEED);
		generateRandomMovement();
	}
	
	//swap entity to constructor
	@Override
	public void movement(float delta) {
		if(!(entity.isTurning() ||entity.isEating())){
			updateHunger();
			if(MathUtils.random(100)>randomOdds){
				generateRandomMovement();
			}
			updateY(delta);
			updateX(delta);
		}
	}

	private void updateHunger() {
		hunger++;
		//might need to delta this
		if(hunger == 800){
			entity.setCurrentState(new HungryFishState(entity));
		}
	}


}
