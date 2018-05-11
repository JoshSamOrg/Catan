package com.catan;

import com.badlogic.gdx.Game;

//This class is the main game class
public class CatanGame extends Game {
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	
    //Sets the screen to the MainMenuScreen
	public void create () {
		setScreen(new HexGeneratorScreen(this));
	}

	//calls the render method in the Game superclass
	public void render () {
		super.render();
	}
	
	public static int getWidth(){
		return WIDTH;
	}
	
	public static int getHeight(){
		return HEIGHT;
	}
}
