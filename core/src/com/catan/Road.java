package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//class that describes a road
public class Road {
  private ImageButton road;
  
  //constructor
  public Road(TextureAtlas atlas, String text){
	  road = new ImageButton(new TextureRegionDrawable(atlas.findRegion(text)));
  }
  
  //returns the image button road
  public ImageButton getRoad(){
	  return road;
  }
}
