package com.catan;

import com.badlogic.gdx.Input.TextInputListener;

public class MyTextInputListener implements TextInputListener {
      private static String currentPlayer = "";
	@Override
	public void input(String text) {
		//TODO
		
	}

	@Override
	public void canceled() {
		// TODO Auto-generated method stub
		
	}

	public void setCurrentPlayer(String player){
		currentPlayer = player;
	}
	
	public String getCurrentPlayer(){
		return currentPlayer;
	}
}
