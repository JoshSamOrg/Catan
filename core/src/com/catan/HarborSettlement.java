package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//class that describes a harbor settlement
public class HarborSettlement implements Occupancy {
  private ImageButton harborSettlement;
  private int space;
  //constructor
  public HarborSettlement(TextureAtlas atlas, String text){
	  harborSettlement = new ImageButton(new TextureRegionDrawable(atlas.findRegion(text)));
	  space = 2;
  }
  
  public HarborSettlement(ImageButton button){
		harborSettlement = button;
		space = 2;
	}
  
  //returns the image button harbor settlement
  public ImageButton getHarborSettlement(){
	  return harborSettlement;
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