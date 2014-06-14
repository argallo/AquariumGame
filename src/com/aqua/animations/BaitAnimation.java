package com.aqua.animations;

import com.aqua.Assets;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class BaitAnimation implements AnimationBehavior {

	private TextureRegion selectedColor;
	private final int rotation;
	
	public BaitAnimation() {
		switch(MathUtils.random(3)){
		case 0:
			selectedColor = new TextureRegion(Assets.getInstance().get("Bait/fishfood_green.png", Texture.class));
			break;
		case 1:
			selectedColor = new TextureRegion(Assets.getInstance().get("Bait/fishfood_red.png", Texture.class));
			break;
		case 2:
			selectedColor = new TextureRegion(Assets.getInstance().get("Bait/fishfood_blue.png", Texture.class));
			break;
		case 3:
			selectedColor = new TextureRegion(Assets.getInstance().get("Bait/fishfood_yellow.png", Texture.class));
			break;
		}
		rotation = MathUtils.random(360);
	}
	
	@Override
	public void Animate(Batch batch, float x, float y, float width,
			float height, float stateTime) {
		//batch.draw(selectedColor, x, y, width, height);
		batch.draw(selectedColor, x, y, width/2, height/2, width, height, 1, 1, rotation);

	}


}
