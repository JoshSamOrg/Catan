package com.catan;

import java.util.ArrayList;

//This class is the player class that holds all the information of a player in the game
public class Player {
	
	//An enumeration that represents 
	//the order that the player places their pieces in the game
	enum Order{
		FIRST, SECOND, THIRD, FOURTH
	}
	
  private Order order;
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
  private ArrayList<Ship> ships;
  private ArrayList<Settlement> settlements;
  private ArrayList<Road> roads;
  private ArrayList<HarborSettlement> harborSettlements;
  private ArrayList<Settler> settlers;
  private ArrayList<Crew> crews;
  private int wood;
  private int wheat;
  private int sheep;
  private int ore;
  private int brick;
  private int gold;
  
  //Constructor that initializes all of the player's instance variables
  public Player(){
	  order = null;
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
	  ships = new ArrayList<Ship>();
	  settlements = new ArrayList<Settlement>();
	  roads = new ArrayList<Road>();
	  harborSettlements = new ArrayList<HarborSettlement>();
	  settlers = new ArrayList<Settler>();
	  crews = new ArrayList<Crew>();
	  wood=0;
	  wheat =0;
	  sheep=0;
	  ore=0;
	  brick=0;
	  gold = 0;
  }
  
  //Constructor with a String parameter that will become the name of the player,
  //and initializes all of the player's instance variables
  public Player(String name){
	  this.name = name;
	  order = null;
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
	  ships = new ArrayList<Ship>();
	  settlements = new ArrayList<Settlement>();
	  roads = new ArrayList<Road>();
	  harborSettlements = new ArrayList<HarborSettlement>();
	  settlers = new ArrayList<Settler>();
	  crews = new ArrayList<Crew>();
	  wood=0;
	  wheat =0;
	  sheep=0;
	  ore=0;
	  brick=0;
	  gold = 0;
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
  
  //returns the order of the player
  public Order getOrder(){
	  return order;
  }
  
  //sets the order of the player
  public void setOrder(Order newOrd){
	  order = newOrd;
  }
  
  //returns the player's wood
  public int getWood(){
	  return wood;
  }
  
  //returns the player's wheat 
  public int getWheat(){
	  return wheat;
  }
  
  //returns the player's ore
  public int getOre(){
	  return ore;
  }
  
  //returns the player's brick
  public int getBrick(){
	  return brick;
  }
  
  //returns the player's sheep
  public int getSheep(){
	  return sheep;
  }
  
  //returns the player's gold
  public int getGold(){
	  return gold;
  }
  
  //returns the player's ships
  public ArrayList<Ship> getShips(){
	  return ships;
  }
  
  //returns the player's settlements
  public ArrayList<Settlement> getSettlements(){
	  return settlements;
  }
  
  //returns the player's roads
  public ArrayList<Road> getRoads(){
	  return roads;
  }
  
  //returns the player's harbor settlements
  public ArrayList<HarborSettlement> getHarborSettlements(){
	  return harborSettlements;
  }
  
  //returns the player's settlers
  public ArrayList<Settler> getSettlers(){
	  return settlers;
  }
  
  //returns the player's crews
  public ArrayList<Crew> getCrews(){
	  return crews;
  }
}
