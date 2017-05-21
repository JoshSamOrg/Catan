package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//class that describes a ship
public class Ship {
private ImageButton ship;
private int moves;

//constructor
public Ship(TextureAtlas atlas, String text) {
	ship = new ImageButton (new TextureRegionDrawable(atlas.findRegion(text)));
	moves = 4;
}

public void decrement() {
	moves--;
}

public void resetMoves() {
	moves = 4;
}

public boolean hasMove() {
	return moves>0;
}

//returns the image button ship
public ImageButton getShip() {
	return ship;
}
}
