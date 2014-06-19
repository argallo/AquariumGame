package com.aqua.entities.money;

import com.aqua.GameManager;
import com.aqua.animations.AnimateSimpleFish;
import com.aqua.animations.BaitAnimation;
import com.aqua.entities.Entity;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public abstract class AbsDropItems extends Entity{


	private int VALUE;

	public AbsDropItems(GameView gameView, int entityId, float x, float y, int value) {
		super(gameView, entityId);
		this.VALUE = value;
		setSize(Gdx.graphics.getWidth()/14, Gdx.graphics.getWidth()/14);
		setPosition(x-getWidth()/2, y-getHeight()/2);
		setAnimationBehavior(new DropItemAnimation());
		
		addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				setCurrentState(new DropItemClickState((Entity) event.getTarget()));
				GameManager.getInstance().setCurrentScore(GameManager.getInstance().getCurrentScore()+VALUE);
				//removeits();
				cancelParent();
			}
		});
	}

	protected void cancelParent() {
		((ClickListener) gameView.getListeners().get(0)).cancel();	
	}

	protected void removeits() {
		this.removeThis();
		
	}

	@Override
	protected State initState() {
		return new DroppingItemState(this);
	}


}
