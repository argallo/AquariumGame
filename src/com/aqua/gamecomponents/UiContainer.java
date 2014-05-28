package com.aqua.gamecomponents;

import java.util.ArrayList;

import com.aqua.containeritems.AbsButtonItem;
import com.aqua.containeritems.BlankItem;
import com.badlogic.gdx.scenes.scene2d.Group;

public class UiContainer extends Group{
	
	private static final int MAX_SLOTS = 8;
	ArrayList<AbsButtonItem> uiItems= new ArrayList<AbsButtonItem>();
	private GameView gameView;
	
	public UiContainer(ArrayList<AbsButtonItem> newItems, GameView gameView) {
		this.gameView = gameView;
		int givenSlots = newItems.size();
		if(givenSlots >= MAX_SLOTS){
			//could potentially lose extra ones added
			for(int x = 0; x < MAX_SLOTS; x++){
				uiItems.add(newItems.remove(x));
			}
			newItems.clear();
		}
		else if (givenSlots < MAX_SLOTS){
			for(int x = 0; x < givenSlots; x++){
				uiItems.add(newItems.remove(x));
			}
			for(int x = givenSlots; x < MAX_SLOTS; x++){
				uiItems.add(new BlankItem());
			}
		}
		for(int i = 0; i < uiItems.size(); i++){
			uiItems.get(i).setGameView(gameView);
			this.addActor(uiItems.get(i));
		}
	}
	

}
