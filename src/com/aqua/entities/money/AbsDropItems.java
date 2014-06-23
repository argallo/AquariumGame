package com.aqua.entities.money;

import com.aqua.GameManager;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.animations.BaitAnimation;
import com.aqua.entities.Entity;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class AbsDropItems extends Entity{


	private int VALUE;
	private float offset;
	
	public AbsDropItems(GameView gameView, int entityId, float x, float y, float width, float height, float offset, int value) {
		super(gameView, entityId);
		this.VALUE = value;
		setSize(width, height);
		this.offset = offset;
		setPosition(x-getWidth()/2, y-getHeight()/2);
		addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				setCurrentState(new DropItemClickState((Entity) event.getTarget()));
				GameManager.getInstance().setCurrentScore(GameManager.getInstance().getCurrentScore()+VALUE);
				cancelParent();
			}
		});
	}

	/**
	 * cancels the parent listener so that bait is not dropped. 
	 * Also swaps parents to keep items above the game
	 */
	protected void cancelParent() {
		((ClickListener) gameView.getListeners().get(0)).cancel();	
		gameView.removeActor(this);
		gameView.getParent().addActor(this);
	}

	@Override
	protected State initState() {
		return new DroppingItemState(this);
	}

	public float getOffset() {
		return offset;
	}
	
	public void setOffset(float offset) {
		this.offset = offset;
	}

}
