package com.aqua.entities.money;

import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;

public class GoldCoin extends AbsDropItems{
	
	private static final int SIZE = Gdx.graphics.getWidth()/14;
	private static final int VALUE = 100;

	public GoldCoin(GameView gameView, int entityId, float x, float y) {
		super(gameView, entityId, x,y,SIZE, SIZE, (SIZE-Gdx.graphics.getWidth()/20)/2,VALUE);
		setAnimationBehavior(new GoldCoinAnimation(this));
	}

	@Override
	protected String createName() {
		return "goldcoin";
	}

}
