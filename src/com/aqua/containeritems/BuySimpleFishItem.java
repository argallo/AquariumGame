package com.aqua.containeritems;

import com.aqua.Assets;
import com.aqua.entities.simplefish.SimpleFish;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BuySimpleFishItem extends AbsButtonItem {
	

	private static final int AMOUNT = 100;
	private TextureRegionDrawable regionDrawable;

	public BuySimpleFishItem() {
		regionDrawable = new TextureRegionDrawable(new TextureRegion(Assets.getInstance().get("UIItems/simplefish_item.png", Texture.class)));
		//implement images later
		setButtonStyle(regionDrawable, regionDrawable);	
	}

	/**
	 * unique to this class checks current score and subtracts 100
	 * if sufficient score and adds a new simplefish
	 */
	@Override
	public void execute() {
		if(gameManager.getCurrentScore() >= AMOUNT){
			gameView.addEntity("simple_fish");
			updateScore(-AMOUNT);
		}
	}
	

}
