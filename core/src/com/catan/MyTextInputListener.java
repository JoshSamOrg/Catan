package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;

public class MyTextInputListener implements TextInputListener {
      private static String currentPlayer = "";
      private static ArrayList<String> validColors = new ArrayList<String>();
      private static boolean drawNames = false;
      
	@Override
	public void input(String text) {
		if(PlayerScreen.getSelectName()){
			PlayerScreen.setIncrease(true);
			GamePlayers.getGamePlayers().add(new Player(text));
			drawNames = true;
		}
		else{
		for(int i = 0; i<PlayerColorScreen.getCheckBoxes().size(); i++){
			if(PlayerColorScreen.getCheckBoxes().get(i).getName().equals(currentPlayer)){
				if(!validColors.contains(text.toLowerCase())){
				if(text.equals("blue") || text.equals("Blue")){
					validColors.add(text.toLowerCase());
				    PlayerColorScreen.getCheckBoxes().get(i).setStyle(PlayerColorScreen.getBlue());
				    PlayerColorScreen.getCheckBoxes().get(i).clearListeners(); //clear the listener from this actor
				    GamePlayers.getBasedOnName(currentPlayer).setColor(text.toLowerCase()); //set the game players color
				}
				else if(text.equals("red") || text.equals("Red")){
					validColors.add(text.toLowerCase());
					PlayerColorScreen.getCheckBoxes().get(i).setStyle(PlayerColorScreen.getRed());
					PlayerColorScreen.getCheckBoxes().get(i).clearListeners(); //clear the listener from this actor
					GamePlayers.getBasedOnName(currentPlayer).setColor(text.toLowerCase()); //set the game players color
				}
				else if(text.equals("orange") || text.equals("Orange")){
					validColors.add(text.toLowerCase());
					PlayerColorScreen.getCheckBoxes().get(i).setStyle(PlayerColorScreen.getOrange());
					PlayerColorScreen.getCheckBoxes().get(i).clearListeners(); //clear the listener from this actor
					GamePlayers.getBasedOnName(currentPlayer).setColor(text.toLowerCase()); //set the game players color
				}
				else if(text.equals("white") || text.equals("White")){
					validColors.add(text.toLowerCase());
					PlayerColorScreen.getCheckBoxes().get(i).setStyle(PlayerColorScreen.getWhite());
					PlayerColorScreen.getCheckBoxes().get(i).clearListeners(); //clear the listener from this actor
					GamePlayers.getBasedOnName(currentPlayer).setColor(text.toLowerCase()); //set the game players color
				}
				else{
					Gdx.input.getTextInput(this, "Colors are red, orange, blue, or white", "", "Choose a valid color");
				}
				}
				else{
					Gdx.input.getTextInput(this, "Color is taken", "", "Choose a different color");
				}
			}
		}
		}
		
	}

	@Override
	public void canceled() {
		for(int i = 0; i<PlayerColorScreen.getCheckBoxes().size(); i++){
			if(PlayerColorScreen.getCheckBoxes().get(i).isChecked()){
				if(GamePlayers.getBasedOnName(PlayerColorScreen.getCheckBoxes().get(i).getName()).getColor().equals("")){
					Gdx.input.getTextInput(this, "Please choose a color", "", "");
				}
			}
		}
	}

	public static void setCurrentPlayer(String player){
		currentPlayer = player;
	}
	
	public static String getCurrentPlayer(){
		return currentPlayer;
	}
	
	public static boolean getDrawNames(){
		return drawNames;
	}
}
