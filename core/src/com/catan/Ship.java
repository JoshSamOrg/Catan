package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Ship {
private ImageButton ship;
private int moves;

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
public ImageButton getShip() {
	return ship;
}
}
