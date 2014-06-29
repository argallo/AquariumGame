package com.aqua.entities.enemy;

import com.aqua.Assets;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Alert extends Actor {
	
	
	private int counter = 0;
	TextureRegion redOverlay, alertText;
	private float alpha = 1f;
	private Color color;
	private int flashes = 0;
	
	public Alert() {
		redOverlay = new TextureRegion(Assets.getInstance().get("Alert/red_overlay.png", Texture.class));
		alertText = new TextureRegion(Assets.getInstance().get("Alert/alertbox_text.png", Texture.class));
	}
	
	@Override
	public void act(float delta) {
		System.out.println(counter);
		counter++;
		if(counter > 50){
			if(flashes == 1){
				alpha-=0.02f;
			}
			else{
				alpha-=0.01f;
			}
		}
		if(counter > 100){
			alpha = 1f;
			counter = 0;
			flashes++;
		}
		if(flashes == 2){
			this.remove();
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		color = batch.getColor();
		batch.setColor(batch.getColor().r, batch.getColor().g, batch.getColor().b, alpha);
		batch.draw(redOverlay,0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.draw(alertText,Gdx.graphics.getWidth()/6,Gdx.graphics.getHeight()/2, Gdx.graphics.getWidth()*2/3, Gdx.graphics.getHeight()/8);
		batch.setColor(color);
	}
	
	

}
