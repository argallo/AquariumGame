package com.aqua.entities.money;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DiamondAnimation extends DropItemAnimation{

	public DiamondAnimation(AbsDropItems entity) {
		super(entity, new TextureRegion(Assets.getInstance().get("Money/diamond_1.png", Texture.class)));
	}
	
	
}
