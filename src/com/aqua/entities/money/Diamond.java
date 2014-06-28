package com.aqua.entities.money;

import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;

public class Diamond extends AbsDropItems{

	
	private static final int SIZE = Gdx.graphics.getWidth()/14;
	private static final int VALUE = 500;

	public Diamond(GameView gameView, int entityId, float x, float y) {
		super(gameView, entityId, x,y,SIZE, SIZE, (SIZE-Gdx.graphics.getWidth()/25)/2,VALUE);
		setAnimationBehavior(new DiamondAnimation(this));
	}

	@Override
	protected String createName() {
		return "diamond";
	}
	
}
