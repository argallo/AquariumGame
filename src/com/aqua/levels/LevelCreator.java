package com.aqua.levels;

import com.aqua.gamecomponents.Background;
import com.aqua.gamecomponents.GameView;
import com.aqua.gamecomponents.UiContainer;
import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class LevelCreator {
	
	protected Background background;
	protected UiContainer topInterface;
	protected GameView gameView;

	
	public abstract void createStage(Stage stage);

}
