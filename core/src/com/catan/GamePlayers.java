package com.catan;

import java.util.ArrayList;

//This class stores an arraylist of players that are playing the game
public class GamePlayers {
   private static ArrayList<Player> gamePlayers = new ArrayList<Player>();
   
   //returns the arraylist of gamePlayers
   public static ArrayList<Player> getGamePlayers(){
	   return gamePlayers;
   }
}
