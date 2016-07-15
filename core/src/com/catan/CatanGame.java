package com.catan;

import com.badlogic.gdx.Game;

//This class is the main game class
public class CatanGame extends Game {
	
    //Sets the screen to the MainMenuScreen
	public void create () {
		setScreen(new HexGenerator(this));
	}

	//calls the render method in the Game superclass
	public void render () {
		super.render();
	}
}
