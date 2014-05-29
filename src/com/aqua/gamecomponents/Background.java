package com.aqua.gamecomponents;

import com.aqua.Assets;
import com.aqua.animations.AnimatedActor;
import com.aqua.animations.BackgroundAnimationBehavior;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor{
	
	private final TextureRegion background; 
	
	public Background() {
		super();
		background = new TextureRegion(Assets.getInstance().get("Background/background.png", Texture.class));
		setPosition(0, 0);
		setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		//setAnimationBehavior(new BackgroundAnimationBehavior());
	}
	
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(background, this.getX(), this.getY(),this.getWidth(), this.getHeight());
		super.draw(batch, parentAlpha);
	}

}
