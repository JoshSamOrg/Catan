package com.catan;

import java.util.ArrayList;

import com.catan.Player.Order;

//This class stores an arraylist of players that are playing the game
public class GamePlayers {
   private static ArrayList<Player> gamePlayers = new ArrayList<Player>();
   private static int updatePlayer = 0;
   private static String currentPlayer = "";
   
   //returns the arraylist of gamePlayers
   public static ArrayList<Player> getGamePlayers(){
	   return gamePlayers;
   }
   //returns the player object with the name specified as the parameter, and null if none of the
   //players have that name
   public static Player getBasedOnName(String name){
	   for(int i = 0; i<gamePlayers.size(); i++){
		   if(gamePlayers.get(i).getName().equals(name)){
			   return gamePlayers.get(i);
		   }
	   }
	   return null;
   }
   
   public static Player getBasedOnColor(String color){
	   for(int i = 0; i<gamePlayers.size(); i++){
		   if(gamePlayers.get(i).getColor().equals(color)){
			   return gamePlayers.get(i);
		   }
	   }
	   return null;
   }
   
   //sets gamePlayers equal to the newPlayers parameter
   public static void setGamePlayers(ArrayList<Player> newPlayers){
	   gamePlayers = newPlayers;
   }
   
   //updates the current player (who's turn it is)
public static void updateCurrentPlayer() {
	Order current = Player.Order.values()[updatePlayer];
	for(int i = 0; i<GamePlayers.getGamePlayers().size(); i++){
		if(GamePlayers.getGamePlayers().get(i).getOrder() == current){
			updatePlayer = (updatePlayer + 1) % GamePlayers.getGamePlayers().size();
			currentPlayer = GamePlayers.getGamePlayers().get(i).getName();
		}
	}
}

//returns the current player's name (who's turn it is)
public static String getCurrentPlayer(){
	return currentPlayer;
}
}
