package com.aqua.entities.purplefish;

import com.aqua.Assets;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.entities.PlayerFish;
import com.aqua.entities.states.NormalFishState;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;

public class PurpleFish extends PlayerFish{

	private static final int DROPRATE = 500;
	private int diamondDrop = 0;
	
	public PurpleFish(GameView gameView, int entityId) {
		super(gameView, entityId);
		setFishAtlas(Assets.getInstance().get("PlayerFish/PurpleFish/purplefish.atlas", TextureAtlas.class));
		
		setSize(Gdx.graphics.getWidth()/13, Gdx.graphics.getHeight()/10);
		// sets the position to a random place in gameview
		setPosition(MathUtils.random(gameView.getWidth()-this.getWidth()),MathUtils.random(gameView.getHeight()-this.getHeight()));
		//starting animation for simplefish
		setAnimationBehavior(new AnimateSimpleFish(this, getDirectionHorizontal()));
		setEntityFood("starterbait");
	}

	@Override
	protected State initState() {
		return new NormalFishState(this);
	}

	@Override
	protected String createName() {
		// TODO Auto-generated method stub
		return "purple_fish";
	}

}
