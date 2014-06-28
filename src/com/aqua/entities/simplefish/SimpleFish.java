package com.aqua.entities.simplefish;

import java.util.LinkedList;

import com.aqua.Assets;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.entities.PlayerFish;
import com.aqua.entities.states.HungryFishState;
import com.aqua.entities.states.NormalFishState;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;

public class SimpleFish extends PlayerFish{
	
	private static final int DROPRATE = 200;
	private static final int SMALL = 0;
	private static final int LARGE = 1;
	private int fishSize = 0;
	private int grow = 0;
	private int coinDrop = 0;

	public SimpleFish(GameView gameView, int entityId) {
		super(gameView, entityId);
		setFishAtlas(Assets.getInstance().get("PlayerFish/SimpleFish/simplefish.atlas", TextureAtlas.class));
		// default size of a simplefish
		setSize(Gdx.graphics.getWidth()/16, Gdx.graphics.getHeight()/12);
		// sets the position to a random place in gameview
		setPosition(MathUtils.random(gameView.getWidth()-this.getWidth()),MathUtils.random(gameView.getHeight()-this.getHeight()));
		//starting animation for simplefish
		setAnimationBehavior(new AnimateSimpleFish(this, getDirectionHorizontal()));
		setEntityFood("starterbait");
		
	}
	
	@Override
	public void act(float delta) {
		updateCoin();
		super.act(delta);
	}

	private void updateCoin() {
		coinDrop++;
		if(coinDrop > DROPRATE && getCurrentState().getClass().equals(NormalFishState.class)){
			dropCoin();	
			coinDrop = 0;
		}
	}

	private void dropCoin() {
		if(grow == 5){
			fishSize++;
			setSize(getWidth()*1.5f, getHeight()*1.5f);
		}
		grow++;
		switch(fishSize){
		case SMALL:
			this.gameView.addEntity("silvercoin", this.getCenterX(), this.getY());
		break;
		case LARGE:
			this.gameView.addEntity("goldcoin", this.getCenterX(), this.getY());
		break;
		}
		
	}

	@Override
	protected String createName() {
		return "simple_fish";
	}

	@Override
	protected State initState() {
		return new HungryFishState(this);
	}
	
	public void setFishSize(int fishSize) {
		this.fishSize = fishSize;
	}
	
	public int getFishSize() {
		return fishSize;
	}
	
	
}
