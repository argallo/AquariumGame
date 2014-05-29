package com.aqua.containeritems;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class BlankItem extends AbsButtonItem{

	
	public BlankItem() {
		setButtonStyle(new TextureRegionDrawable(new TextureRegion(Assets.getInstance().get("UIItems/simplefish_item.png",Texture.class))), new TextureRegionDrawable(new TextureRegion(Assets.getInstance().get("UIItems/simplefish_item.png",Texture.class))));
	}
	
	@Override
	public void execute() {
		System.out.println("wow");
		
	}

}
