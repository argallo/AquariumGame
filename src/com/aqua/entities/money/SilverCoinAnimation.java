package com.aqua.entities.money;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SilverCoinAnimation extends DropItemAnimation{

	public SilverCoinAnimation(AbsDropItems entity) {
		super(entity, new TextureRegion(Assets.getInstance().get("Money/silver_coin_1.png", Texture.class)));
	}

}
