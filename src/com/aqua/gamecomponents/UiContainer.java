package com.aqua.gamecomponents;

import java.util.ArrayList;

import com.aqua.Assets;
import com.aqua.containeritems.AbsButtonItem;
import com.aqua.containeritems.BlankItem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class UiContainer extends Group{
	
	private static final int MAX_SLOTS = 6;
	ArrayList<AbsButtonItem> uiItems= new ArrayList<AbsButtonItem>();
	private GameView gameView;
	private final TextureRegion background; 
	/**
	 * 
	 * @param newItems list of items to create for UI
	 * @param gameView current gameview 
	 */
	public UiContainer(ArrayList<AbsButtonItem> newItems, GameView gameView) {
		this.gameView = gameView;
		//set the size and position of the UIContainer
		setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/6);
		setPosition(0, Gdx.graphics.getHeight()-getHeight());
		//REPLACE WITH ACTUAL BACKGROUND!
		background = new TextureRegion(Assets.getInstance().get("Container/container.png", Texture.class));
		//init all items and add to group
		initItems(newItems);
	}
	
	/**
	 * initializes the array of UI items to the correct size of 8 slots by either adding default items
	 * or not adding end items. (will throw error later but shouldn't be an issue)
	 * @param newItems list of items to create for UI
	 */
	private void initItems(ArrayList<AbsButtonItem> newItems){
		int givenSlots = newItems.size();
		
		if(givenSlots >= MAX_SLOTS){
			//could potentially lose extra ones added
			for(int x = 0; x < MAX_SLOTS; x++){
				uiItems.add(newItems.remove(x));
			}
			newItems.clear();
		}
		else if (givenSlots < MAX_SLOTS){
			for(int x = 0; x < givenSlots; x++){
				uiItems.add(newItems.remove(x));
			}
			for(int x = givenSlots; x < MAX_SLOTS; x++){
				uiItems.add(new BlankItem());
			}
		}
		for(int i = 0; i < uiItems.size(); i++){
			uiItems.get(i).setGameView(gameView);
			uiItems.get(i).setPosition(i*(Gdx.graphics.getWidth()/MAX_SLOTS)+Gdx.graphics.getWidth()/30, this.getHeight()/4);
			this.addActor(uiItems.get(i));
		}
	}
	
	/**
	 * override draw to add a background to group actor might need to change xy all that will see
	 */
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(background, this.getX(), this.getY(),this.getWidth(), this.getHeight());
		super.draw(batch, parentAlpha);
	}
	
	


}
