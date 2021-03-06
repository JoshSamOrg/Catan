package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.catan.Player.Order;

//This class allows the player to select their starting positions 
//of the game. They are able to put a Harbor Settlement, Settlement, Road, and Ship
//on the board
public class CatanPieces {
	private float mpX = 0;
	private float mpY = 0;
	private int firstX = -1;
	private int firstY = -1;
	private int secondX = -1;
	private int secondY = -1;
	private int roadRotation = 0;
	private int settlementIndexX = 0;
	private int settlementIndexY = 0;
	private int xPos = 0;
	private int yPos = 0;
	private static TextureRegion reg;
	private static ArrayList<Integer> positions = new ArrayList<Integer>(); // adjust
																			// for
																			// the
																			// widget
																			// dimensions

	private static String pieceType = "";
	private static ArrayList<ImageButton> gamePieces = new ArrayList<ImageButton>();
	//private static HexGeneratorScreen HexGeneratorScreen = new HexGeneratorScreen(null);
	private static boolean selectInitialPlacements = false;
	private CatanGame game;

	public CatanPieces(CatanGame game) {
		this.game = game;
	}

	// determines the midpoint of (f,g) and (h,i)
	public void midpoint(int f, int g, int h, int i) {
		mpX = (f + h) / 2f;
		mpY = (g + i) / 2f;
	}

	// determines the distance between (f,g) and (h,i), and sizex and sizey
	// help you adjust to the correct distance between the two points, not based
	// on the lower left corner of an image button
	public static int distance(int f, int g, int h, int i, int sizex, int sizey) {
		if (f - h > 0 && g - i > 0) {
			return (int) Math.sqrt((Math.pow((f - h - sizex), 2))
					+ (Math.pow((g - i - sizey), 2)));
		} else if (f - h > 0 && g - i < 0) {
			return (int) Math.sqrt((Math.pow((f - h - sizex), 2))
					+ (Math.pow((g - i + sizey), 2)));
		} else if (f - h < 0 && g - i > 0) {
			return (int) Math.sqrt((Math.pow((f - h + sizex), 2))
					+ (Math.pow((g - i - sizey), 2)));
		} else {
			return (int) Math.sqrt((Math.pow((f - h + sizex), 2))
					+ (Math.pow((g - i + sizey), 2)));
		}
	}

	// Takes a mousex and mousey, and stores values in the variables firstX,
	// firstY, secondX, and secondY,
	// which are all indices in the positions arraylist. This method will be
	// used in
	// coordination with the midpoint method to determine the position of the
	// road
	public void findRoad(int mousex, int mousey) {
		int smallestDistance = 100;
		int times = 1;
		int stop = -1;
		while (times >= 0) {
			smallestDistance = 100;
			for (int i = 0; i < positions.size() - 1; i += 2) {
				if (i != stop) {
					if (distance(mousex, mousey, positions.get(i),
							positions.get(i + 1), 0, 0) < smallestDistance) {
						smallestDistance = distance(mousex, mousey,
								positions.get(i), positions.get(i + 1), 0, 0);
						if (times == 1) {
							firstX = i;
							firstY = i + 1;
						} else {
							secondX = i;
							secondY = i + 1;
						}
					}
				}
			}
			times--;
			stop = firstX;
		}
		try{
		findRoadRotation(positions.get(firstX), positions.get(firstY),
				positions.get(secondX), positions.get(secondY));
	}
		//if the user clicks in a nonvalid region when placing a road or a ship (settler)
		catch(ArrayIndexOutOfBoundsException e){
			firstX = 28;
			firstY = 29;
			secondX = 30;
			secondY = 31;
			roadRotation = -30;
		}
	}

	// Determines what rotation a road should be in, given the settlement
	// positions adjacent to where the
	// road is being placed
	public void findRoadRotation(int x, int y, int a, int b) {
		if (Math.abs(x - a) < 8) {
			roadRotation = 90;
		} else if ((y > b && x < a) || (b > y && a < x)) {
			roadRotation = -30;
		} else if ((y > b && x > a) || (b > y && a > x)) {
			roadRotation = 30;
		}
	}

	// Given a point x,y determines the closest settlement position to that
	// point, and stores this
	// information into settlementIndexX and settlementIndexY, which are indices
	// into
	// the positions arraylist
	public void findSettlement(int x, int y) {
		int smallestDistance = 100;
		for (int i = 0; i < positions.size() - 1; i += 2) {
			if (distance(x, y, positions.get(i), positions.get(i + 1), 0, 0) < smallestDistance) {
				smallestDistance = distance(x, y, positions.get(i),
						positions.get(i + 1), 0, 0);
				settlementIndexX = i;
				settlementIndexY = i + 1;
			}
		}
	}

	// returns mpX, the x coordinate of the midpoint of two points
	public float getmpX() {
		return mpX;
	}

	// returns mpY, the y coordinate of the midpoint of two points
	public float getmpY() {
		return mpY;
	}

	// returns firstX, the index of the x position of the first settlment
	public int getFirstX() {
		return firstX;
	}

	// returns firstY, the index of the y position of the first settlement
	public int getFirstY() {
		return firstY;
	}

	// returns secondX, the index of the x position of the second settlement
	public int getSecondX() {
		return secondX;
	}

	// returns secondY, the index of the y position of the second settlement
	public int getSecondY() {
		return secondY;
	}

	// returns the positions arraylist
	public static ArrayList<Integer> getPositions() {
		return positions;
	}

	// returns the roadRotation (the rotation of a given road)
	public int getRoadRotation() {
		return roadRotation;
	}

	// returns settlementIndexX, the x index of the x coordinate of a settlement
	public int getSettlementIndexX() {
		return settlementIndexX;
	}

	// returns settlementIndexY, the y index of the y coordinate of a settlement
	public int getSettlementIndexY() {
		return settlementIndexY;
	}

	// returns gamePieces, the arraylist of image buttons that keeps track of
	// what each player places on the board
	public static ArrayList<ImageButton> getGamePieces() {
		return gamePieces;
	}

	// returns reg, a texture region
	public static TextureRegion getTextureRegion() {
		return reg;
	}

	// sets up a new atlas, based on the texture region reg
	public static void setTextureRegion(TextureAtlas atlas) {
		reg = atlas.findRegion(pieceType);
	}

	// returns pieceType, a string that determines the type of piece placed on
	// the board
	public static String getPieceType() {
		return pieceType;
	}

	// sets pieceType equal to the parameter newPieceType
	public static void setPieceType(String newPieceType) {
		pieceType = newPieceType;
	}

	// takes two parameters, the strings piece1 and piece2, and allows the
	// player to select their starting positions
	public void selectPositions(String piece1, String piece2) {
		gamePieces.clear();
		String[] colors = { "red", "blue", "orange", "white" };
		TextureAtlas atlas;
		int order = 0;
		yPos = 140;
		int times = PlayerColorScreen.getNumberOfPlayers();
		xPos = 15;
		while (times > 0) {
			for (int i = 0; i < PlayerColorScreen.getNumberOfPlayers(); i++) {
				if (GamePlayers.getGamePlayers().get(i).getOrder() == Order.values()[order]) {
					if (GamePlayers.getGamePlayers().get(i).getColor().equals("orange")) {
						atlas = new TextureAtlas(Gdx.files.internal("Orange.txt"));
						reg = atlas.findRegion(colors[2] + piece1);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos,yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[2] + "|" + piece1);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
                        
						reg = atlas.findRegion(colors[2] + piece2);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15, yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[2] + "|" + piece2);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
						
						yPos -= 40;
						break;
					} else if (GamePlayers.getGamePlayers().get(i).getColor().equals("red")) {
						atlas = new TextureAtlas(Gdx.files.internal("Red.txt"));
						reg = atlas.findRegion(colors[0] + piece1);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos,yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[0] + "|" + piece1);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));

						reg = atlas.findRegion(colors[0] + piece2);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15, yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[0] + "|" + piece2);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
						
						yPos -= 40;
						break;
					} else if (GamePlayers.getGamePlayers().get(i).getColor().equals("blue")) {
						atlas = new TextureAtlas(Gdx.files.internal("Blue.txt"));
						reg = atlas.findRegion(colors[1] + piece1);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos,yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[1] + "|" + piece1);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));

						reg = atlas.findRegion(colors[1] + piece2);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15, yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[1] + "|" + piece2);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
						
						yPos -= 40;
						break;
					} else if (GamePlayers.getGamePlayers().get(i).getColor().equals("white")) {
						atlas = new TextureAtlas(Gdx.files.internal("white.txt"));
						reg = atlas.findRegion(colors[3] + piece1);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos,yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[3] + "|" + piece1);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));

						reg = atlas.findRegion(colors[3] + piece2);
						gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
						gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15, yPos, 10, 15);
						gamePieces.get(gamePieces.size() - 1).setName(colors[3] + "|" + piece2);
						HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));

						yPos -= 40;
						break;
					}
				}
			}
			times--;
			order++;
		}
		//rearranging the element order of gamePieces to get the listeners correct
		if (piece1.equals("HarborSettlement") && piece2.equals("Settlement")) {
			for (int i = gamePieces.size() - 1; i > -1; i--) {
				if (gamePieces.get(i).getName().substring(gamePieces.get(i).getName().indexOf("|") + 1).equals("Settlement")) {
					ImageButton button = gamePieces.remove(i);
					gamePieces.add(button);
				}
			}
		}
		addGamePiecesListener(0);
	}

	// add a listener to the element located at index i in the gamePieces
	// arraylist
	public static void addGamePiecesListener(int i) {
		gamePieces.get(i).addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				actor.setVisible(false);
				selectInitialPlacements = true;
			}
		});
	}
	
	//determines if the user has clicked on a game piece or not,
	//returning true if they have, and false otherwise
	public static boolean isGamePieceTouched(int x, int y) {
		for (int i=0; i<gamePieces.size(); i++) {
			if((gamePieces.get(i).getWidth()) >= (x - gamePieces.get(i).getX())){
				if((x - gamePieces.get(i).getX())>=0){
					if((gamePieces.get(i).getHeight()) >=
							(y- gamePieces.get(i).getY())){
						if(y- gamePieces.get(i).getY()>=0){
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}

	// called when there are only two players in the game and they need to each
	// place a
	// harbor settlement and a settlement
	public void neutralPlacements() {
		gamePieces.clear();
		TextureAtlas atlas;
		String[] colors = { "red", "blue", "orange", "white" };
		yPos = 140;
		xPos = 15;
		ArrayList<String> pColors = new ArrayList<String>();
		for (int i = 0; i < PlayerColorScreen.getNumberOfPlayers(); i++) {
			pColors.add(GamePlayers.getGamePlayers().get(i).getColor());
		}
		for (int i = 0; i < 4; i++) {
			if (!pColors.contains(colors[i])) {
				if(colors[i].equals("red")){
				atlas = new TextureAtlas(Gdx.files.internal("Red.txt"));
				reg = atlas.findRegion(colors[0] + "HarborSettlement");
				gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
				gamePieces.get(gamePieces.size() - 1).setBounds(xPos, yPos, 10,15);
				gamePieces.get(gamePieces.size() - 1).setName(colors[0] + "|" + "HarborSettlement");
				HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
				
				reg = atlas.findRegion(colors[0] + "Settlement");
				gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
				gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15,yPos, 10, 15);
				gamePieces.get(gamePieces.size() - 1).setName(colors[0] + "|" + "Settlement");
				HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
				yPos -= 40;
			}
				else if(colors[i].equals("blue")){
					atlas = new TextureAtlas(Gdx.files.internal("Blue.txt"));
					reg = atlas.findRegion(colors[1] + "HarborSettlement");
					gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
					gamePieces.get(gamePieces.size() - 1).setBounds(xPos, yPos, 10,15);
					gamePieces.get(gamePieces.size() - 1).setName(colors[1] + "|" + "HarborSettlement");
					HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
					
					reg = atlas.findRegion(colors[1] + "Settlement");
					gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
					gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15,yPos, 10, 15);
					gamePieces.get(gamePieces.size() - 1).setName(colors[1] + "|" + "Settlement");
					HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
					yPos -= 40;
				}
				else if(colors[i].equals("orange")){
					atlas = new TextureAtlas(Gdx.files.internal("Orange.txt"));
					reg = atlas.findRegion(colors[2] + "HarborSettlement");
					gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
					gamePieces.get(gamePieces.size() - 1).setBounds(xPos, yPos, 10,15);
					gamePieces.get(gamePieces.size() - 1).setName(colors[2] + "|" + "HarborSettlement");
					HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
					
					reg = atlas.findRegion(colors[2] + "Settlement");
					gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
					gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15,yPos, 10, 15);
					gamePieces.get(gamePieces.size() - 1).setName(colors[2] + "|" + "Settlement");
					HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
					yPos -= 40;
				}
				else if(colors[i].equals("white")){
					atlas = new TextureAtlas(Gdx.files.internal("White.txt"));
					reg = atlas.findRegion(colors[3] + "HarborSettlement");
					gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
					gamePieces.get(gamePieces.size() - 1).setBounds(xPos, yPos, 10,15);
					gamePieces.get(gamePieces.size() - 1).setName(colors[3] + "|" + "HarborSettlement");
					HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
					
					reg = atlas.findRegion(colors[3] + "Settlement");
					gamePieces.add(new ImageButton(new TextureRegionDrawable(reg)));
					gamePieces.get(gamePieces.size() - 1).setBounds(xPos - 15,yPos, 10, 15);
					gamePieces.get(gamePieces.size() - 1).setName(colors[3] + "|" + "Settlement");
					HexGeneratorScreen.getStage().addActor(gamePieces.get(gamePieces.size() - 1));
					yPos -= 40;
				}
		}
		}
		ImageButton temp = gamePieces.get(1);
		gamePieces.set(1, gamePieces.get(2));
		gamePieces.set(2, temp);
		temp = gamePieces.get(2);
		gamePieces.set(2, gamePieces.get(3));
		gamePieces.set(3, temp);
		addGamePiecesListener(0);
	}
	
	//returns selectInitialPlacements, a boolean that queries when the 
	//user is selecting their placements, true when they are, and false
	//otherwise
	public static boolean getSelectInitialPlacements() {
		return selectInitialPlacements;
	}

	//adds all the hexagon points to the positions arraylist
	//these positions are STAGE coordinates, these need to be 
	//converted to screen coordinates using stage.stageToScreenCoordinates(Vector2) method
	public static void findPositions() {
		if(positions.isEmpty()){
		positions.add(141);// 1
		positions.add(438);
		positions.add(119);// 2
		positions.add(401);
		positions.add(119);// 3
		positions.add(426);
		positions.add(98);// 4
		positions.add(388);
		positions.add(98);// 5
		positions.add(363);
		positions.add(77);// 6
		positions.add(351);
		positions.add(77);// 7
		positions.add(327);
		positions.add(55);// 8
		positions.add(314);
		positions.add(55);// 9
		positions.add(290);
		positions.add(76);// 10
		positions.add(278);
		positions.add(76);// 11
		positions.add(254);
		positions.add(98);// 12
		positions.add(241);
		positions.add(98);// 13
		positions.add(217);
		positions.add(119);// 14
		positions.add(204);
		positions.add(119);// 15
		positions.add(180);
		positions.add(140);// 16
		positions.add(168);
		positions.add(162);// 17
		positions.add(180);
		positions.add(183);// 18
		positions.add(168);
		positions.add(205);// 19
		positions.add(180);
		positions.add(226);// 20
		positions.add(168);
		positions.add(248);// 21
		positions.add(180);
		positions.add(269);// 22
		positions.add(168);
		positions.add(290);// 23
		positions.add(180);
		positions.add(311);// 24
		positions.add(169);
		positions.add(333);// 25
		positions.add(180);
		positions.add(354);// 26
		positions.add(169);
		positions.add(376);// 27
		positions.add(180);
		positions.add(397);// 28
		positions.add(169);
		positions.add(419);// 29
		positions.add(180);
		positions.add(440);// 30
		positions.add(169);
		positions.add(461);// 31
		positions.add(180);
		positions.add(482);// 32
		positions.add(169);
		positions.add(504);// 33
		positions.add(181);
		positions.add(504);// 34
		positions.add(205);
		positions.add(525);// 35
		positions.add(218);
		positions.add(525);// 36
		positions.add(242);
		positions.add(546);// 37
		positions.add(254);
		positions.add(546);// 38
		positions.add(279);
		positions.add(567);// 39
		positions.add(291);
		positions.add(567);// 40
		positions.add(316);
		positions.add(547);// 41
		positions.add(328);
		positions.add(546);// 42
		positions.add(352);
		positions.add(525);// 43
		positions.add(365);
		positions.add(525);// 44
		positions.add(389);
		positions.add(504);// 45
		positions.add(402);
		positions.add(503);// 46
		positions.add(426);
		positions.add(482);// 47
		positions.add(438);
		positions.add(461);// 48
		positions.add(426);
		positions.add(439);// 49
		positions.add(438);
		positions.add(418);// 50
		positions.add(426);
		positions.add(396);// 51
		positions.add(438);
		positions.add(375);// 52
		positions.add(426);
		positions.add(353);// 53
		positions.add(438);
		positions.add(332);// 54
		positions.add(426);
		positions.add(311);// 55
		positions.add(438);
		positions.add(290);// 56
		positions.add(426);
		positions.add(269);// 57
		positions.add(437);
		positions.add(247);// 58
		positions.add(425);
		positions.add(226);// 59
		positions.add(437);
		positions.add(205);// 60
		positions.add(425);
		positions.add(183);// 61
		positions.add(438);
		positions.add(162);// 62
		positions.add(426);
		positions.add(204);// 63
		positions.add(401);
		positions.add(183);// 64
		positions.add(389);
		positions.add(162);// 65
		positions.add(401);
		positions.add(140);// 66
		positions.add(389);
		positions.add(140);// 67
		positions.add(364);
		positions.add(162);// 68
		positions.add(351);
		positions.add(183);// 69
		positions.add(364);
		positions.add(119);// 70
		positions.add(351);
		positions.add(98);// 71
		positions.add(315);
		positions.add(119);// 72
		positions.add(327);
		positions.add(141);// 73
		positions.add(315);
		positions.add(162);// 74
		positions.add(327);
		positions.add(98);// 75
		positions.add(290);
		positions.add(119);// 76
		positions.add(279);
		positions.add(140);// 77
		positions.add(291);
		positions.add(162);// 78
		positions.add(278);
		positions.add(183);// 79
		positions.add(291);
		positions.add(184);// 80
		positions.add(315);
		positions.add(119);// 81
		positions.add(253);
		positions.add(141);// 82
		positions.add(242);
		positions.add(161);// 83
		positions.add(254);
		positions.add(141);// 84
		positions.add(216);
		positions.add(183);// 85
		positions.add(242);
		positions.add(184);// 86
		positions.add(216);
		positions.add(162);// 87
		positions.add(204);
		positions.add(205);// 88
		positions.add(204);
		positions.add(247);// 89
		positions.add(401);
		positions.add(227);// 90
		positions.add(388);
		positions.add(227);// 91
		positions.add(364);
		positions.add(205);// 92
		positions.add(351);
		positions.add(205);// 93
		positions.add(328);
		positions.add(226);// 94
		positions.add(315);
		positions.add(226);// 95
		positions.add(291);
		positions.add(205);// 96
		positions.add(279);
		positions.add(205);// 97
		positions.add(254);
		positions.add(227);// 98
		positions.add(242);
		positions.add(226);// 99
		positions.add(217);
		positions.add(247);// 0
		positions.add(204);
		positions.add(290);// 1
		positions.add(401);
		positions.add(269);// 2
		positions.add(388);
		positions.add(270);// 3
		positions.add(365);
		positions.add(248);// 4
		positions.add(351);
		positions.add(248);// 5
		positions.add(328);
		positions.add(269);// 6
		positions.add(316);
		positions.add(269);// 7
		positions.add(292);
		positions.add(247);// 8
		positions.add(279);
		positions.add(248);// 9
		positions.add(254);
		positions.add(268);// 10
		positions.add(242);
		positions.add(269);// 11
		positions.add(217);
		positions.add(290);// 12
		positions.add(205);
		positions.add(332);// 13
		positions.add(402);
		positions.add(311);// 14
		positions.add(389);
		positions.add(312);// 15
		positions.add(366);
		positions.add(290);// 16
		positions.add(353);
		positions.add(290);// 17
		positions.add(329);
		positions.add(311);// 18
		positions.add(316);
		positions.add(311);// 19
		positions.add(292);
		positions.add(290);// 20
		positions.add(279);
		positions.add(290);// 21
		positions.add(255);
		positions.add(311);// 22
		positions.add(242);
		positions.add(311);// 23
		positions.add(218);
		positions.add(333);// 24
		positions.add(205);
		positions.add(375);// 25
		positions.add(402);
		positions.add(355);// 26
		positions.add(389);
		positions.add(355);// 27
		positions.add(366);
		positions.add(333);// 28
		positions.add(353);
		positions.add(333);// 29
		positions.add(328);
		positions.add(354);// 30
		positions.add(316);
		positions.add(354);// 31
		positions.add(292);
		positions.add(333);// 32
		positions.add(279);
		positions.add(333);// 33
		positions.add(255);
		positions.add(354);// 34
		positions.add(242);
		positions.add(354);// 35
		positions.add(218);
		positions.add(375);// 36
		positions.add(205);
		positions.add(418);// 37
		positions.add(402);
		positions.add(397);// 38
		positions.add(390);
		positions.add(397);// 39
		positions.add(365);
		positions.add(376);// 40
		positions.add(353);
		positions.add(376);// 41
		positions.add(328);
		positions.add(397);// 42
		positions.add(316);
		positions.add(397);// 43
		positions.add(291);
		positions.add(375);// 44
		positions.add(279);
		positions.add(375);// 45
		positions.add(254);
		positions.add(397);// 46
		positions.add(242);
		positions.add(397);// 47
		positions.add(217);
		positions.add(418);// 48
		positions.add(205);
		positions.add(461);// 49
		positions.add(402);
		positions.add(440);// 50
		positions.add(389);
		positions.add(440);// 51
		positions.add(364);
		positions.add(419);// 52
		positions.add(353);
		positions.add(419);// 53
		positions.add(328);
		positions.add(440);// 54
		positions.add(316);
		positions.add(440);// 55
		positions.add(291);
		positions.add(418);// 56
		positions.add(280);
		positions.add(418);// 57
		positions.add(254);
		positions.add(440);// 58
		positions.add(242);
		positions.add(440);// 59
		positions.add(218);
		positions.add(461);// 60
		positions.add(205);
		positions.add(483);// 61
		positions.add(389);
		positions.add(483);// 62
		positions.add(364);
		positions.add(461);// 63
		positions.add(352);
		positions.add(461);// 64
		positions.add(328);
		positions.add(483);// 65
		positions.add(316);
		positions.add(482);// 66
		positions.add(291);
		positions.add(461);// 67
		positions.add(279);
		positions.add(461);// 68
		positions.add(254);
		positions.add(482);// 69
		positions.add(242);
		positions.add(482);// 70
		positions.add(217);
		positions.add(504);// 71
		positions.add(352);
		positions.add(504);// 72
		positions.add(328);
		positions.add(525);// 73
		positions.add(316);
		positions.add(525);// 74
		positions.add(291);
		positions.add(503);// 75
		positions.add(279);
		positions.add(503);// 76
		positions.add(254);
		}
	}
	
	//sets the selectInitialPlacements boolean, which queries when the user is
	//selecting their pieces to place, true when they are selecting,
	//and false otherwise
	public static void setSelectInitialPlacements(boolean set) {
		selectInitialPlacements = set;
	}
}
