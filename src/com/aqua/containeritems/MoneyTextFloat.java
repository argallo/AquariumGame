package com.aqua.containeritems;

import com.aqua.GameManager;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MoneyTextFloat extends Actor{
	
	private String text;
	private BitmapFont font ;
	private float distanceMoved = 0;
	
	public MoneyTextFloat(int amount, boolean positive) {
		setPosition(Gdx.graphics.getWidth()-Gdx.graphics.getWidth()/5, Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/8);
		font = new BitmapFont();
		if(positive){
			font.setColor(Color.GREEN);
			text = "+"+amount;
		}
		else{
			font.setColor(Color.RED);
			text = ""+amount;
		}
	}

	
	@Override
	public void act(float delta) {
		distanceMoved++;
		setY(getY()+80*delta);
		font.setColor(font.getColor().r, font.getColor().g, font.getColor().b, font.getColor().a-0.005f);
		if(distanceMoved >= 50){
			this.remove();
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, text, getX(), getY());
	}
	
	
	
}
