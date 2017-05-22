package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//class that describes a ship
public class Ship implements Occupancy {
private ImageButton ship;
private int moves;
private int space;

//constructor
public Ship(TextureAtlas atlas, String text) {
	ship = new ImageButton (new TextureRegionDrawable(atlas.findRegion(text)));
	moves = 4;
	space = 2;
}

public Ship(ImageButton button){
	ship = button;
	moves = 4;
	space = 2;
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

@Override
//decreases the space of the structure (harbor settlement or ship)
public void decreaseSpace(String piece) {
	space = (piece.equals("Crew") || piece.equals("Spice")) ? space-1 : space - 2;
}

@Override
//true when the structure has space for a crew
public boolean hasSpaceForCrew() {
	return space >= 1;
}

@Override
//true when the structure has space for a settler
public boolean hasSpaceForSettler() {
	return space == 2;
}

@Override
//true when the structure has space for a spice
public boolean hasSpaceForSpice() {
	return space >= 1;
}

@Override
//true when the structure has space for a fish
public boolean hasSpaceForFish() {
	return space == 2;
}
}
