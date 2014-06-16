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
		load("Bait/fishfood_green.png", Texture.class, param);
		load("Bait/fishfood_red.png", Texture.class, param);
		load("Bait/fishfood_blue.png", Texture.class, param);
		load("Bait/fishfood_yellow.png", Texture.class, param);
		load("Money/silver_coin_1.png", Texture.class, param);
		load("Money/gold_coin_1.png", Texture.class, param);
		load("PlayerFish/simplefish.atlas", TextureAtlas.class);
		load("PlayerFish/simplefishflip.atlas", TextureAtlas.class);
		load("PlayerFish/simplefishsick.atlas", TextureAtlas.class);
		load("PlayerFish/simplefishbite.atlas", TextureAtlas.class);
		load("PlayerFish/simplefishsickbite.atlas", TextureAtlas.class);
		load("PlayerFish/simplefishsickflip.atlas", TextureAtlas.class);
		finishLoading();
	}

}
