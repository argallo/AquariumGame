package com.aqua.entities.money;

import com.aqua.Assets;
import com.aqua.animations.AnimationBehavior;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DropItemAnimation implements AnimationBehavior {
	
	private TextureRegion silverCoin;
	
	public DropItemAnimation() {
		silverCoin = new TextureRegion(Assets.getInstance().get("Money/silver_coin_1.png", Texture.class));
	}

	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime) {
		batch.draw(silverCoin, x, y, Gdx.graphics.getWidth()/20, Gdx.graphics.getWidth()/20);
	}

}
