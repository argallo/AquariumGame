package com.aqua.containeritems;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BuyPurpleFishItem extends AbsButtonItem{

	
	private static final int AMOUNT = 1000;
	private TextureRegionDrawable regionDrawable;

	public BuyPurpleFishItem() {
		regionDrawable = new TextureRegionDrawable(new TextureRegion(Assets.getInstance().get("UIItems/purplefish_item.png", Texture.class)));
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
			gameView.addEntity("purple_fish");
			updateScore(-AMOUNT);
		}
	}
	
	
	
}
