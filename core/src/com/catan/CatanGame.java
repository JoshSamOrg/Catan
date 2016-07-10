package com.catan;

import com.badlogic.gdx.Game;

public class CatanGame extends Game {
	
	@Override
	public void create () {
		setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
