package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//class that describes a crew
public class Crew {
private ImageButton crew;

//constructor
public Crew(TextureAtlas atlas, String text){
	  crew = new ImageButton(new TextureRegionDrawable(atlas.findRegion(text)));
}

public Crew(ImageButton button){
	crew = button;
}

//returns the image button crew
public ImageButton getCrew(){
	  return crew;
}
}
