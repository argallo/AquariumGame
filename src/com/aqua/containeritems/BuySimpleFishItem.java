package com.aqua.containeritems;

import com.aqua.entities.fish.SimpleFish;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BuySimpleFishItem extends AbsButtonItem {
	

	private static final int AMOUNT = 100;

	public BuySimpleFishItem() {
		//implement images later
		setButtonStyle(new TextureRegionDrawable(), new TextureRegionDrawable());
	}

	@Override
	public void execute() {
		if(gameManager.getCurrentScore() >= AMOUNT){
			gameView.addEntity("simplefish");
		}
	}
	

}
