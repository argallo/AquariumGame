package com.aqua;

import com.aqua.screens.GameScreen;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MainGame extends Game {

	SpriteBatch batch;
	GameScreen gameScreen;
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		Assets.getInstance().loadAll();
		gameScreen = new GameScreen(batch);
		setScreen(gameScreen);
	}





}