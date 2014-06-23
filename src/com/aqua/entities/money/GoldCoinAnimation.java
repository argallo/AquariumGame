package com.aqua.entities.money;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GoldCoinAnimation extends DropItemAnimation{

	public GoldCoinAnimation(AbsDropItems entity) {
		super(entity, new TextureRegion(Assets.getInstance().get("Money/gold_coin_1.png", Texture.class)));
		
	}
	
	

}
