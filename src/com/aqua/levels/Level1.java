package com.aqua.levels;

import java.util.ArrayList;
import java.util.List;

import com.aqua.containeritems.AbsButtonItem;
import com.aqua.containeritems.BuyPurpleFishItem;
import com.aqua.containeritems.BuySimpleFishItem;
import com.aqua.entities.Entity;
import com.aqua.entities.enemy.EnemyCreator;
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
		gameView.addEntity("simple_fish");
		gameView.addEntity("simple_fish");
		gameView.addEntity("purple_fish");
		//create list of items for UI (might grab from gamemanager in later levels if user gets to pick idk yet)
		ArrayList<AbsButtonItem> items = new ArrayList<AbsButtonItem>();
		//added only one item rest will be filled with default
		items.add(new BuySimpleFishItem());
		items.add(new BuyPurpleFishItem());
		//create uiContainer
		topInterface = new UiContainer(items, gameView);
		background = new Background();
		//setup enemyCreator
		List<String> possibleEnemies = new ArrayList<String>();
		EnemyCreator enemyCreator = new EnemyCreator(gameView, possibleEnemies, 1000);
		stage.addActor(background);
		stage.addActor(gameView);
		stage.addActor(topInterface);
		stage.addActor(enemyCreator);
		background.setSize(background.getWidth(), Gdx.graphics.getHeight()-topInterface.getHeight());
		gameView.setSize(gameView.getWidth(), Gdx.graphics.getHeight() - topInterface.getHeight());
		return stage;
	}

}
