package com.aqua.screens;

import com.aqua.GameManager;
import com.aqua.levels.LevelCreator;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends BaseScreen{
	
	private LevelCreator level;

	public GameScreen(SpriteBatch batch) {
		super(batch);
		level = GameManager.getInstance().getCurrentLevel();
		
	}
	
	@Override
	public void render(float delta) {
	
		
	}

	@Override
	public void show() {
		level.createStage(activeStage);
		
	}

}
