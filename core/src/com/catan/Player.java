package com.catan;

//This class is the player class that holds all the information of a player in the game
public class Player {
  private String name;
  private int victoryPoints;
  private int numberOfRoads;
  private int numberOfSettlements;
  private int numberOfHarborSettlements;
  private int numberOfCrew;
  private int numberOfPirateShip;
  private int numberOfShips;
  private int numberOfSettlers;
  private int numberOfCities;
  private int numberOfCircles;
  private String color;
  
  //Constructor that initializes all of the player's instance variables
  public Player(){
	  name = "";
	  color = "";
	  victoryPoints = 0;
	  numberOfRoads = 15;
	  numberOfSettlements = 5;
	  numberOfHarborSettlements = 4;
	  numberOfCrew = 9;
	  numberOfPirateShip = 1;
	  numberOfShips = 3;
	  numberOfSettlers = 2;
	  numberOfCities = 4;
	  numberOfCircles = 3;
  }
  
  //Constructor with a String parameter that will become the name of the player,
  //and initializes all of the player's instance variables
  public Player(String name){
	  this.name = name;
	  color = "";
	  victoryPoints = 0;
	  numberOfRoads = 15;
	  numberOfSettlements = 5;
	  numberOfHarborSettlements = 4;
	  numberOfCrew = 9;
	  numberOfPirateShip = 1;
	  numberOfShips = 3;
	  numberOfSettlers = 2;
	  numberOfCities = 4;
	  numberOfCircles = 3;
  }
  
  //returns the name of the player
  public String getName(){
	  return name;
  }
  
  //sets the name of the player
  public void setName(String name){
	  this.name = name;
  }
  
  //returns the number of victory points a player has
  public int getVictoryPoints(){
	  return victoryPoints;
  }
  
  //returns the number of roads a player has
  public int getNumberOfRoads(){
	  return numberOfRoads;
  }
  
  //returns the number of settlements a player has
  public int getNumberOfSettlements(){
	  return numberOfSettlements;
  }
  
  //returns the number of harbor settlements a player has
  public int getNumberOfHarborSettlements(){
	  return numberOfHarborSettlements;
  }
  
  //returns the number of crew a player has
  public int getNumberOfCrew(){
	  return numberOfCrew;
  }
  
  //returns the number of pirate ships a player has
  public int getNumberOfPirateShip(){
	  return numberOfPirateShip;
  }
  
  //returns the number of ships a player has
  public int getNumberOfShips(){
	  return numberOfShips;
  }
  
  //returns the number of settlers a player has
  public int getNumberOfSettlers(){
	  return numberOfSettlers;
  }
  
  //returns the number of cities a player has
  public int getNumberOfCities(){
	  return numberOfCities;
  }
  
  //returns the number of circles a player has
  public int getNumberOfCircles(){
	  return numberOfCircles;
  }
  
  //returns the player's color
  public String getColor(){
	  return color;
  }
  
  //sets the player's color
  public void setColor(String color){
	  this.color = color;
  }
}
