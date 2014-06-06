package com.aqua.levels;

import java.util.ArrayList;

import com.aqua.containeritems.AbsButtonItem;
import com.aqua.containeritems.BuySimpleFishItem;
import com.aqua.gamecomponents.Background;
import com.aqua.gamecomponents.GameView;
import com.aqua.gamecomponents.UiContainer;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Level1 extends LevelCreator{

	
	public Level1() {
	
	}
	
	@Override
	public Stage createStage(Stage stage) {
		//Initialize gameview
		gameView = new GameView();
		gameView.addEntity("simplefish");
		gameView.addEntity("simplefish");
		gameView.addEntity("simplefish");
		//create list of items for UI (might grab from gamemanager in later levels if user gets to pick idk yet)
		ArrayList<AbsButtonItem> items = new ArrayList<AbsButtonItem>();
		//added only one item rest will be filled with default
		items.add(new BuySimpleFishItem());
		//create uiContainer
		topInterface = new UiContainer(items, gameView);
		background = new Background();
		stage.addActor(background);
		stage.addActor(gameView);
		stage.addActor(topInterface);
		
		background.setSize(background.getWidth(), Gdx.graphics.getHeight()-topInterface.getHeight());
		gameView.setSize(gameView.getWidth(), Gdx.graphics.getHeight() - topInterface.getHeight());
		return stage;
	}

}
