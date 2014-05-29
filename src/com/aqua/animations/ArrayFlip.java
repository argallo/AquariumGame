package com.aqua.animations;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class ArrayFlip {

	Array<? extends TextureRegion> flipped;
	
	public ArrayFlip(Array<? extends TextureRegion> flipped) {
		this.flipped = flipped;
		for(int i = 0; i < flipped.size; i++){
			flipped.get(i).flip(true, false);
		}
	}
	
	public Array<? extends TextureRegion> getFlipped() {
		return flipped;
	}
	
}
