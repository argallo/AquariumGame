package com.aqua.entities.money;

import com.aqua.entities.Entity;
import com.aqua.entities.states.State;
import com.aqua.gamecomponents.GameView;

public abstract class AbsDropItems extends Entity{

	public AbsDropItems(GameView gameView, int entityId) {
		super(gameView, entityId);
		
	}

	@Override
	protected State initState() {
		
		return new DroppingItemState(this);
	}


}
