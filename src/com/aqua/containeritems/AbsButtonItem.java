package com.aqua.containeritems;

import com.aqua.Assets;
import com.aqua.GameManager;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;

public abstract class AbsButtonItem extends Button implements UiItem{
	
	
	private ButtonStyle buttonStyle;
	protected GameManager gameManager = GameManager.getInstance();
	protected GameView gameView;
	private TextureRegion glass;
	
	public AbsButtonItem() {
		buttonStyle = new ButtonStyle();
		setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getWidth()/18);
		initListener();
		glass = new TextureRegion(Assets.getInstance().get("Container/window.png", Texture.class));
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
	
	//draws glass over UIITEM
	@Override
	public void draw(Batch batch, float parentAlpha) {
		super.draw(batch, parentAlpha);
		batch.draw(glass, getX()+Gdx.graphics.getWidth()/70, getY()-getY()/8, getWidth()-getWidth()/5, getHeight()+Gdx.graphics.getWidth()/90);
	}

	/**
	 * updates the score not working for now
	 * @param amount amount to update score by
	 */
	public void updateScore(int amount){
		GameManager.getInstance().setCurrentScore(amount);
		/*if(amount > 0){
			this.getParent().getParent().addActor(new MoneyTextFloat(amount, true));
		}
		else{
			this.getParent().getParent().addActor(new MoneyTextFloat(amount, false));
		}
		*/
	}
}
