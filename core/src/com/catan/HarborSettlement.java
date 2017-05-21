package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//class that describes a harbor settlement
public class HarborSettlement {
  private ImageButton harborSettlement;
  
  //constructor
  public HarborSettlement(TextureAtlas atlas, String text){
	  harborSettlement = new ImageButton(new TextureRegionDrawable(atlas.findRegion(text)));
  }
  
  //returns the image button harbor settlement
  public ImageButton getHarborSettlement(){
	  return harborSettlement;
  }
}