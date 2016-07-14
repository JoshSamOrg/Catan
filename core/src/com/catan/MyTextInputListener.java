package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;

//This class handles user input, and the pop up dialog boxes
public class MyTextInputListener implements TextInputListener {
      private static String currentPlayer = "";
      private static ArrayList<String> validColors = new ArrayList<String>(); //Keeps track of all the valid colors, and
                                                                              //what colors have been used already 
      private static boolean drawNames = false; //A boolean that toggles when to draw the names selected onto the screen
      
	@Override
	//This method is called when the user presses enter on the dialog boxes
	//Sets up the players' names and allows the players to select a color they want to play with
	public void input(String text) {
		if(PlayerScreen.getSelectName()){
			if(GamePlayers.getGamePlayers().size() == 4){
				Gdx.input.getTextInput(this, "Reached Maximum number of players", "", "exit this window and press Continue");
				return;
			}
			if(GamePlayers.getBasedOnName(text) == null){
			PlayerScreen.setIncrease(true);
			GamePlayers.getGamePlayers().add(new Player(text));
			drawNames = true;
			if(GamePlayers.getGamePlayers().size() >=2){
				PlayerScreen.getContinueButton().setVisible(true);
			}
			}
			else{
				Gdx.input.getTextInput(this, "Name already taken", "", "Pick a different name");
				return;
			}
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
		shouldBeVisible();
	}

	private void shouldBeVisible() {
		for(int i = 0; i<GamePlayers.getGamePlayers().size(); i++){
			if(GamePlayers.getGamePlayers().get(i).getColor().equals("")){
				return;
			}
		}
		PlayerColorScreen.getConfigureBoard().setVisible(true);
		
	}

	@Override
	//This method is called when the user presses cancel or exits the dialog with the red X
	//Handles the case where a player has not selected a valid color and attempts to exit the dialog box and
	//Ensures that each player has selected a valid color to play with
	public void canceled() {
		for(int i = 0; i<PlayerColorScreen.getCheckBoxes().size(); i++){
			if(PlayerColorScreen.getCheckBoxes().get(i).isChecked()){
				if(GamePlayers.getBasedOnName(PlayerColorScreen.getCheckBoxes().get(i).getName()).getColor().equals("")){
					Gdx.input.getTextInput(this, "Please choose a color", "", "");
				}
			}
		}
	}

	//Sets the currentPlayer String
	public static void setCurrentPlayer(String player){
		currentPlayer = player;
	}
	
	//returns the currentPlayer String
	public static String getCurrentPlayer(){
		return currentPlayer;
	}
	
	//Returns the drawNames boolean
	public static boolean getDrawNames(){
		return drawNames;
	}
	
	public static ArrayList<String> getValidColors(){
		return validColors;
	}
}
