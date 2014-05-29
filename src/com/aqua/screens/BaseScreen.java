package com.aqua.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public class BaseScreen implements Screen{

	protected Stage activeStage;
	protected Stage transitionStage;
	private SpriteBatch batch;
	
	public BaseScreen(SpriteBatch batch) {
		//this.batch = batch;
		activeStage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), false, batch);
		transitionStage = new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), false , batch);
	}
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//transitionStage.act();
		activeStage.act();
		activeStage.draw();
		//transitionStage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}



}
