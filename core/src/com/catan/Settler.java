package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//class that describes a settler
public class Settler {
  private ImageButton settler;
  
  //constructor
  public Settler(TextureAtlas atlas, String text){
	  settler = new ImageButton(new TextureRegionDrawable(atlas.findRegion(text)));
  }
  
  //returns the image button settler
  public ImageButton getSettler(){
	  return settler;
  }
}
