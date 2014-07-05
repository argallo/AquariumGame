package com.aqua.entities.enemy.shark;

import com.aqua.Assets;
import com.aqua.Direction;
import com.aqua.Region;
import com.aqua.animations.AbsFishAnimationBehavior;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.entities.EnemyEntity;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;

public class Shark extends EnemyEntity{
	
	
	private Region collisionRegion;
	
	//FIGURE OUT WHY IT WONT DELETE THE PURPLE FISH
	

	public Shark(GameView gameView, int entityId) {
		super(gameView, entityId);
		setDirectionHorizontal(MathUtils.random(1)+3);
		// default size of a simplefish
		setSize(Gdx.graphics.getWidth()/3, Gdx.graphics.getHeight()/3);
		// sets the position to a random place in gameview
		if(getDirectionHorizontal() == Direction.LEFT){
			setPosition(Gdx.graphics.getWidth()+this.getWidth()+Gdx.graphics.getWidth()/30,MathUtils.random(gameView.getHeight()-this.getHeight()));
			collisionRegion = new Region(0,0, getWidth()/3, getHeight());
		}
		else{
			setPosition(-this.getWidth()-Gdx.graphics.getWidth()/30,MathUtils.random(gameView.getHeight()-this.getHeight()));
			collisionRegion = new Region(getWidth()-getWidth()/3,0, getWidth()/3, getHeight());
		}
		//starting animation for simplefish
		setAnimationBehavior(new AnimateShark(this, getDirectionHorizontal()));
		setEntityFood("purple_fish");
		setEntityFood("simple_fish");
		//setEntityFood("starterbait");
		
	}

	@Override
	protected State initState() {
		return new SharkState(this);
	}

	@Override
	protected String createName() {
		return "shark";
	}

	public void eat() {
		((AnimateShark) getAnimationBehavior()).bite();
	}
	
	public Region getCollisionRegion() {
		return collisionRegion;
	}
	
	

}
