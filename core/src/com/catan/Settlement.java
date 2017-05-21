package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
//class that describes a settlement
public class Settlement {
  private ImageButton settlement;
  
  //constructor
  public Settlement(TextureAtlas atlas, String text){
	  settlement = new ImageButton(new TextureRegionDrawable(atlas.findRegion(text)));
  }
  
  //returns the image button settlement
  public ImageButton getSettlement(){
	  return settlement;
  }
}
