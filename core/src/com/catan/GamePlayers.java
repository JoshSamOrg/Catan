package com.catan;

import java.util.ArrayList;

//This class stores an arraylist of players that are playing the game
public class GamePlayers {
   private static ArrayList<Player> gamePlayers = new ArrayList<Player>();
   
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
}
