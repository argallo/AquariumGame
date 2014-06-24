package com.aqua.entities.money;

import com.aqua.entities.Entity;
import com.aqua.entities.states.State;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class DropItemClickState extends State {

	private static final float DEFAULTX = Gdx.graphics.getWidth() - Gdx.graphics.getWidth()/4+Gdx.graphics.getWidth()/80;
	private static final float DEFAULTY = Gdx.graphics.getHeight() - Gdx.graphics.getHeight()/12;
	private static final float SPEED = 1.3f;
	Entity entity;
	float length;
	Vector2 vec;
	
	public DropItemClickState(Entity entity) {
		setEntity(entity);
		vec = new Vector2();
	}

	@Override
	protected void setEntity(Entity entity) {
		this.entity = entity;
		
	}

	@Override
	public void movement(float delta) {
		vec.set(DEFAULTX - entity.getCenterX(), DEFAULTY - entity.getCenterY());
		length = vec.len();
		vec.nor();
		((AbsDropItems) entity).setOffset(((AbsDropItems) entity).getOffset()+0.2f);
		entity.setX(entity.getX()+vec.x*(SPEED+(length*delta*5)));
		entity.setY(entity.getY()+vec.y*(SPEED+(length*delta*5)));
		checkRemove();
	}

	private void checkRemove() {
		if(length < 1){
			entity.remove();
		}
		
	}

}
