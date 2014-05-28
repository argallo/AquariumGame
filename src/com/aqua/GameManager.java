package com.aqua;

import com.aqua.levels.Level1;
import com.aqua.levels.LevelCreator;

public class GameManager {
	
	private int currentScore = 0;
	
	private static final GameManager INSTANCE = new GameManager();
	
	public static GameManager getInstance() {
		
		return INSTANCE;
	}
	
	public LevelCreator getCurrentLevel(){
		//implement later
		return new Level1();
	}

	public int getCurrentScore() {
		return currentScore;
	}
	

}
