package com.aqua.entities.states;

import com.aqua.entities.Entity;

public interface State {
	
	public void movement(float delta, Entity entity);
	

}
