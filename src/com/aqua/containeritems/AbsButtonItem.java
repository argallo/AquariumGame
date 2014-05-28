package com.aqua.containeritems;

import com.aqua.GameManager;
import com.aqua.gamecomponents.GameView;
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
		this.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				execute();
				super.clicked(event, x, y);
			}
		});
	}
	
	public abstract void execute();
	
	public void setButtonStyle(Drawable up, Drawable down){
		buttonStyle.up = up;
		buttonStyle.down = down;
		super.setStyle(buttonStyle);
	}
	
	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}

}
