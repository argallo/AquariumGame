package com.aqua.containeritems;

import com.aqua.GameManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Score extends Actor{
	 BitmapFont font;
	 
	 //need to change to create specific font and correct size
	 public Score() {
		 setPosition(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/4, Gdx.graphics.getHeight()/42);
		 font = new BitmapFont();
         font.setColor(1.0f,1.0f,1.0f,1);
	}
	 
	 
	 @Override
	public void draw(Batch batch, float parentAlpha) {
		 font.draw(batch, "Dabloons:" + GameManager.getInstance().getCurrentScore(), getX(), getY());
	}
	 
	 
}
