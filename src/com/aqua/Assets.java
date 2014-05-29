package com.aqua;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader.TextureParameter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Assets extends AssetManager{

	TextureParameter param;
	
	private static final Assets INSTANCE = new Assets();
	
	public static Assets getInstance() {
		
		return INSTANCE;
	
	}
	
	
	public void loadAll(){
		param = new TextureParameter();
		param.minFilter = TextureFilter.Linear;
		param.magFilter = TextureFilter.Linear;
		load("Background/background.png", Texture.class, param);
		load("Container/container.png", Texture.class, param);
		load("UIItems/simplefish_item.png", Texture.class, param);
		load("PlayerFish/simplefish.atlas", TextureAtlas.class);
		finishLoading();
	}

}
