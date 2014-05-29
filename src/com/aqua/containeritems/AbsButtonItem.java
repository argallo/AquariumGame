package com.aqua.containeritems;

import com.aqua.GameManager;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public abstract class AbsButtonItem extends Button implements UiItem{
	
	
	private ButtonStyle buttonStyle;
	protected GameManager gameManager = GameManager.getInstance();
	protected GameView gameView;
	
	public AbsButtonItem() {
		buttonStyle = new ButtonStyle();
		setSize(Gdx.graphics.getWidth()/12, Gdx.graphics.getWidth()/14);
		initListener();
	}
	
	/**
	 * adds listener to allow execute method to be called when pressed
	 */
	public void initListener(){
		this.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				execute();
			}
		});
	}
	
	/**
	 * 
	 * @param up image when button is not pressed
	 * @param down image when button is pressed
	 */
	public void setButtonStyle(Drawable up, Drawable down){
		buttonStyle.up = up;
		buttonStyle.down = down;
		super.setStyle(buttonStyle);
	}
	
	/**
	 * 
	 * @param gameView sets the gameview for this item which is done when creating the level
	 */
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}

}
