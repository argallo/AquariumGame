package com.aqua.entities.enemy;

import java.util.List;

import com.aqua.entities.Entity;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * 
 * @author Gallo
 * Made this extends Actor so I can add it
 * to stage for the act method.
 * Keeps stuff clean.
 */

public class EnemyCreator extends Actor{
	
	private int enemyRate;
	private GameView gameView;
	//might change to list of strings
	private List<Entity> possibleEnemies;
	private int counter = 0;
	
	public EnemyCreator(GameView gameView, List<Entity> possibleEnemies, int enemyRate) {
		this.gameView = gameView;
		this.possibleEnemies = possibleEnemies;
		this.enemyRate = enemyRate;
	}
	
	
	@Override
	public void act(float delta) {
		counter++;
		if(counter > enemyRate){
			counter = 0;
			createEnemy();
		}
	}


	private void createEnemy() {
		
		
	}
	

}
