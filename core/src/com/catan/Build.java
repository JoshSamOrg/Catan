package com.catan;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

//class that builds structures
public class Build {
  private static String color; //the player's color
  private static Player player; //the player
	public static void build(String name, String pieceType, TextureAtlas a){
		color = GamePlayers.getBasedOnName(name).getColor();
		player = GamePlayers.getBasedOnName(name);
			buildStructure(pieceType, a);
	}
	
	//builds any structure within the game
	public static void buildStructure(String type, TextureAtlas atlas){
		if(type.equals("Settlement")){
			player.getSettlements().add(new Settlement(atlas, color + type));
			int size = player.getSettlements().size();
			player.getSettlements().get(size - 1).getSettlement().setBounds(270, 100, 10, 15);
			player.getSettlements().get(size - 1).getSettlement().setName(color + type);
			HexGeneratorScreen.getStage().addActor(player.getSettlements().get(size - 1).getSettlement());
		}
		else if(type.equals("HarborSettlement")){
			player.getHarborSettlements().add(new HarborSettlement(atlas, color + type));
			int size = player.getHarborSettlements().size();
			player.getHarborSettlements().get(size - 1).getHarborSettlement().setBounds(270, 100, 10, 15);
			player.getHarborSettlements().get(size - 1).getHarborSettlement().setName(color + type);
			HexGeneratorScreen.getStage().addActor(player.getHarborSettlements().get(size - 1).getHarborSettlement());
		}
		else if(type.equals("Road")){
			player.getRoads().add(new Road(atlas, color + type));
			int size = player.getRoads().size();
			player.getRoads().get(size - 1).getRoad().setBounds(270, 100, 10, 15);
			player.getRoads().get(size - 1).getRoad().setName(color + type);
			HexGeneratorScreen.getStage().addActor(player.getRoads().get(size - 1).getRoad());
		}
		else if(type.equals("Ship")){
			player.getShips().add(new Ship(atlas, color + type));
			int size = player.getShips().size();
			player.getShips().get(size - 1).getShip().setBounds(270, 100, 10, 15);
			player.getShips().get(size - 1).getShip().setName(color + type);
			HexGeneratorScreen.getStage().addActor(player.getShips().get(size - 1).getShip());
		}
		else if(type.equals("Settler")){
			player.getSettlers().add(new Settler(atlas, color + type));
			int size = player.getSettlers().size();
			player.getSettlers().get(size - 1).getSettler().setBounds(270, 100, 10, 15);
			player.getSettlers().get(size - 1).getSettler().setName(color + type);
			HexGeneratorScreen.getStage().addActor(player.getSettlers().get(size - 1).getSettler());
		}
		else if(type.equals("Crew")){
			player.getCrews().add(new Crew(atlas, color + type));
			int size = player.getCrews().size();
			player.getCrews().get(size - 1).getCrew().setBounds(270, 100, 10, 15);
			player.getCrews().get(size - 1).getCrew().setName(color + type);
			HexGeneratorScreen.getStage().addActor(player.getCrews().get(size - 1).getCrew());
		}
	}
}
