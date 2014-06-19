package com.aqua.entities.money;

import com.aqua.gamecomponents.GameView;

public class SilverCoin extends AbsDropItems{

	
	private static final int VALUE = 50;

	public SilverCoin(GameView gameView, int entityId, float x, float y) {
		super(gameView, entityId,x,y,VALUE);
		
	}

	@Override
	protected String createName() {
		return "silvercoin";
	}
	


}
