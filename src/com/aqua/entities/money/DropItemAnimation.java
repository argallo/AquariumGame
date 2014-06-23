package com.aqua.entities.money;

import com.aqua.Assets;
import com.aqua.animations.AnimationBehavior;
import com.aqua.entities.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DropItemAnimation implements AnimationBehavior {
	
	private TextureRegion item;
	private AbsDropItems entity;
	
	public DropItemAnimation(AbsDropItems entity, TextureRegion item) {
		this.entity = entity;
		this.item = item;
	}

	@Override
	public void Animate(Batch batch, float x, float y, float width, float height, float stateTime) {
		batch.draw(item, x+entity.getOffset(), y+entity.getOffset(), width-entity.getOffset()*2, height-entity.getOffset()*2);
	}

}
