package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

public class ValidPositions implements Screen, InputProcessor {
	private SpriteBatch batch;
	private Texture boardStart;
	private CatanGame game;
	private boolean settlement = false; // determines whether a settlement
										// location is a valid placement.
	private static int i = 0;
	private SettlementLocationIndices sli = new SettlementLocationIndices();
	private CatanPieces cp = new CatanPieces(null);
	private static ImageButton buttons1, buttons2, buttons3;
	private static int counter=0; // used to get the index for the
	private static int count=0;
	private int s = -1; // settlementLocations array.
	private int set = 0;
	private int set2 = 0;
	private int set3 = 0;
	private int set4 = 0;
	private int road1 = 0, road2 = 0, road3 = 0, road4 = 0;
	private float a = 0, b = 0;
	private LandValues value;
	private static boolean[][] markedSettlement;
	private static String colors="";
	

	public ValidPositions(CatanGame game) {
		//cp.findPositions();
		value = new LandValues();
		markedSettlement = new boolean[72][6];
		this.game = game;
	}

	@Override
	public void show() {
		for (int i = 0; i < 72; i++) {
			for (int j = 0; j < 6; j++) {
				markedSettlement[i][j] = false;
			}
		}
		Gdx.input.setInputProcessor(this);
		boardStart = new Texture("Scenario5Final.png");
		batch = new SpriteBatch();

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(boardStart, 0, 0, 650, 650);
		batch.end();

	}

	/*
	 * x the x coordinate of the mouse click. y the y coordinate of the mouse
	 * click. Returns the index of the hex found in the land array (in the
	 * LandValues class).
	 */
	public static int findHex(int x, int y) {
		if (CatanPieces.distance(x, y, 140, 413, 0, 0) <= 23.5) {
			i = 0;
		} else if (CatanPieces.distance(x, y, 183, 413, 0, 0) <= 23.5) {
			i = 1;
		} else if (CatanPieces.distance(x, y, 118, 375, 0, 0) <= 23.5) {
			i = 2;
			//(i);
		} else if (CatanPieces.distance(x, y, 161, 375, 0, 0) <= 23.5) {
			i = 3;
			//(i);
		} else if (CatanPieces.distance(x, y, 97, 339, 0, 0) <= 23.5) {
			i = 4;
			//(i);
		} else if (CatanPieces.distance(x, y, 140, 339, 0, 0) <= 23.5) {
			i = 5;
			//(i);
		} else if (CatanPieces.distance(x, y, 76, 301, 0, 0) <= 23.5) {
			i = 6;
			//(i);
		} else if (CatanPieces.distance(x, y, 118, 301, 0, 0) <= 23.5) {
			i = 7;
			//(i);
		} else if (CatanPieces.distance(x, y, 161, 301, 0, 0) <= 23.5) {
			i = 8;
			//(i);
		} else if (CatanPieces.distance(x, y, 97, 266, 0, 0) <= 23.5) {
			i = 9;
			//(i);
		} else if (CatanPieces.distance(x, y, 140, 266, 0, 0) <= 23.5) {
			i = 10;
			//(i);
		} else if (CatanPieces.distance(x, y, 118, 228, 0, 0) <= 23.5) {
			i = 11;
			//(i);
		} else if (CatanPieces.distance(x, y, 161, 228, 0, 0) <= 23.5) {
			i = 12;
			//(i);
		} else if (CatanPieces.distance(x, y, 140, 191, 0, 0) <= 23.5) {
			i = 13;
			//(i);
		} else if (CatanPieces.distance(x, y, 183, 191, 0, 0) <= 23.5) {
			i = 14;
			//(i);
		} else if (CatanPieces.distance(x, y, 225, 413, 0, 0) <= 23.5) {
			i = 15;
			//(i);
		} else if (CatanPieces.distance(x, y, 268, 413, 0, 0) <= 22.5) {
			i = 16;
			//(i);
		} else if (CatanPieces.distance(x, y, 204, 375, 0, 0) <= 22.5) {
			i = 17;
			//(i);
		} else if (CatanPieces.distance(x, y, 247, 375, 0, 0) <= 22.5) {
			i = 18;
			//(i);
		} else if (CatanPieces.distance(x, y, 183, 339, 0, 0) <= 22.5) {
			i = 19;
			//(i);
		} else if (CatanPieces.distance(x, y, 225, 339, 0, 0) <= 22.5) {
			i = 20;
			//(i);
		} else if (CatanPieces.distance(x, y, 204, 301, 0, 0) <= 22.5) {
			i = 21;
			//(i);
		} else if (CatanPieces.distance(x, y, 247, 301, 0, 0) <= 22.5) {
			i = 22;
			//(i);
		} else if (CatanPieces.distance(x, y, 183, 266, 0, 0) <= 22.5) {
			i = 23;
			//(i);
		} else if (CatanPieces.distance(x, y, 225, 266, 0, 0) <= 22.5) {
			i = 24;
			//(i);
		} else if (CatanPieces.distance(x, y, 204, 228, 0, 0) <= 22.5) {
			i = 25;
			//(i);
		} else if (CatanPieces.distance(x, y, 247, 228, 0, 0) <= 22.5) {
			i = 26;
			//(i);
		} else if (CatanPieces.distance(x, y, 225, 191, 0, 0) <= 22.5) {
			i = 27;
			//(i);
		} else if (CatanPieces.distance(x, y, 268, 191, 0, 0) <= 22.5) {
			i = 28;
			//(i);
		} else if (CatanPieces.distance(x, y, 310, 413, 0, 0) <= 22.5) {
			i = 29;
			//(i);
		} else if (CatanPieces.distance(x, y, 353, 413, 0, 0) <= 22.5) {
			i = 30;
			//(i);
		} else if (CatanPieces.distance(x, y, 396, 413, 0, 0) <= 22.5) {
			i = 31;
			//(i);
		} else if (CatanPieces.distance(x, y, 438, 413, 0, 0) <= 22.5) {
			i = 32;
			//(i);
		} else if (CatanPieces.distance(x, y, 480, 413, 0, 0) <= 22.5) {
			i = 33;
			//(i);
		} else if (CatanPieces.distance(x, y, 290, 375, 0, 0) <= 22.5) {
			i = 34;
			//(i);
		} else if (CatanPieces.distance(x, y, 332, 375, 0, 0) <= 22.5) {
			i = 35;
			//(i);
		} else if (CatanPieces.distance(x, y, 375, 375, 0, 0) <= 22.5) {
			i = 36;
			//(i);
		} else if (CatanPieces.distance(x, y, 418, 375, 0, 0) <= 22.5) {
			i = 37;
			//(i);
		} else if (CatanPieces.distance(x, y, 461, 375, 0, 0) <= 22.5) {
			i = 38;
			//(i);
		} else if (CatanPieces.distance(x, y, 503, 375, 0, 0) <= 22.5) {
			i = 39;
			//(i);
		} else if (CatanPieces.distance(x, y, 268, 339, 0, 0) <= 22.5) {
			i = 40;
			//(i);
		} else if (CatanPieces.distance(x, y, 311, 339, 0, 0) <= 22.5) {
			i = 41;
			//(i);
		} else if (CatanPieces.distance(x, y, 353, 339, 0, 0) <= 22.5) {
			i = 42;
			//(i);
		} else if (CatanPieces.distance(x, y, 396, 339, 0, 0) <= 22.5) {
			i = 43;
			//(i);
		} else if (CatanPieces.distance(x, y, 439, 339, 0, 0) <= 22.5) {
			i = 44;
			//(i);
		} else if (CatanPieces.distance(x, y, 482, 339, 0, 0) <= 22.5) {
			i = 45;
			//(i);
		} else if (CatanPieces.distance(x, y, 525, 339, 0, 0) <= 22.5) {
			i = 46;
			//(i);
		} else if (CatanPieces.distance(x, y, 290, 301, 0, 0) <= 22.5) {
			i = 47;
			//(i);
		} else if (CatanPieces.distance(x, y, 332, 301, 0, 0) <= 22.5) {
			i = 48;
			//(i);
		} else if (CatanPieces.distance(x, y, 375, 301, 0, 0) <= 22.5) {
			i = 49;
			//(i);
		} else if (CatanPieces.distance(x, y, 418, 301, 0, 0) <= 22.5) {
			i = 50;
			//(i);
		} else if (CatanPieces.distance(x, y, 461, 301, 0, 0) <= 22.5) {
			i = 51;
			//(i);
		} else if (CatanPieces.distance(x, y, 503, 301, 0, 0) <= 22.5) {
			i = 52;
			//(i);
		} else if (CatanPieces.distance(x, y, 546, 301, 0, 0) <= 22.5) {
			i = 53;
			//(i);
		} else if (CatanPieces.distance(x, y, 268, 266, 0, 0) <= 22.5) {
			i = 54;
			//(i);
		} else if (CatanPieces.distance(x, y, 311, 266, 0, 0) <= 22.5) {
			i = 55;
			//(i);
		} else if (CatanPieces.distance(x, y, 353, 266, 0, 0) <= 22.5) {
			i = 56;
			//(i);
		} else if (CatanPieces.distance(x, y, 396, 266, 0, 0) <= 22.5) {
			i = 57;
			//(i);
		} else if (CatanPieces.distance(x, y, 439, 266, 0, 0) <= 22.5) {
			i = 58;
			//(i);
		} else if (CatanPieces.distance(x, y, 482, 266, 0, 0) <= 22.5) {
			i = 59;
			//(i);
		} else if (CatanPieces.distance(x, y, 525, 266, 0, 0) <= 22.5) {
			i = 60;
			//(i);
		} else if (CatanPieces.distance(x, y, 289, 228, 0, 0) <= 22.5) {
			i = 61;
			//(i);
		} else if (CatanPieces.distance(x, y, 332, 228, 0, 0) <= 22.5) {
			i = 62;
			//(i);
		} else if (CatanPieces.distance(x, y, 375, 228, 0, 0) <= 22.5) {
			i = 63;
			//(i);
		} else if (CatanPieces.distance(x, y, 418, 228, 0, 0) <= 22.5) {
			i = 64;
			//(i);
		} else if (CatanPieces.distance(x, y, 461, 228, 0, 0) <= 22.5) {
			i = 65;
			//(i);
		} else if (CatanPieces.distance(x, y, 504, 228, 0, 0) <= 22.5) {
			i = 66;
			//(i);
		} else if (CatanPieces.distance(x, y, 311, 191, 0, 0) <= 22.5) {
			i = 67;
			//(i);
		} else if (CatanPieces.distance(x, y, 354, 191, 0, 0) <= 22.5) {
			i = 68;
			//(i);
		} else if (CatanPieces.distance(x, y, 397, 191, 0, 0) <= 22.5) {
			i = 69;
			//(i);
		} else if (CatanPieces.distance(x, y, 440, 191, 0, 0) <= 22.5) {
			i = 70;
			//(i);
		} else if (CatanPieces.distance(x, y, 483, 191, 0, 0) <= 22.5) {
			i = 71;
			//(i);
		} else {
			//("not in bounds");
			i = 72;
		}
		return i;
	}

	/*
	 * button the image that is going to be placed on the board. 
	 * text the type of piece being put on the board. 
	 * x the x coordinate (should be a stage coordinate!) of the mouse click 
	 * y the y coordinate (should be a stage coordinate!) of the mouse click 
	 * Returns whether the placed image is in a valid location.
	 */
	public boolean valid(ImageButton button, String text, int x, int y, String color, boolean first) {
		colors = color;
		if (text.equals("Settlement")) {
			boolean main = true;
			cp.findSettlement(x, y);  //finds the nearest settlement from the location you clicked on the board.
			int placement = cp.getSettlementIndexY() / 2;
			Point p = (Point) Board.getPoints().get(placement);
			ArrayList<Point> neighbors = p.getNeighbors();
			ArrayList<Hex> h = p.getHexes();
			boolean land = false;
			for (int i=0; i<h.size(); i++) {
				if (h.get(i).getType()== 'l') {
					land = true;
					break;
				}
			}
			boolean twoAway = true;
			for (int i=0; i<neighbors.size(); i++) {
				if (neighbors.get(i).getType()!=null) {
					twoAway = false;
					break;
				}
			}
			System.out.println("twoAway: " + twoAway);
			/* check this code when people can place normal settlements (not initial ones) */
			if (!first) {
				main = false;
				for (int i=0; i<p.getSegments().size(); i++) {
					Segment s = (Segment) p.getSegments().get(i);
					if (s.getType().equals(color + "Road")) {
						main = true;
						break;
					}
				}
			}
			if (p.getType()==null && land  && twoAway && main) {

				settlement = true;
			} else {
				settlement = false;
			}
		} else if (text.equals("HarborSettlement")) {
			
			boolean main = true;
			cp.findSettlement(x, y);
			if (first) {
			if ((CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 205 && 
				 CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 425)
			 || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 204 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 401)
			 || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 389)
			 || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 364)
	         || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 162 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 351)
	         || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 162 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 327)
		     || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 184 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 315)
		     || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 291)
		     || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 162 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 278)
		     || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 161 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 254)
		     || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 242)
		     || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 184 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 216)
			 || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 205 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 204)
			 || (CatanPieces.getPositions().get(cp.getSettlementIndexX()) == 205 && 
			     CatanPieces.getPositions().get(cp.getSettlementIndexY()) == 180)){
				main = true;
			}
			else {
				main = false;
			}
			}


				int placement = cp.getSettlementIndexY() / 2;
				Point p = (Point) Board.getPoints().get(placement);
				ArrayList<Point> neighbors = p.getNeighbors();
				ArrayList<Hex> h = p.getHexes();
				boolean land = false;
				for (int i=0; i<h.size(); i++) {
					if (h.get(i).getType()== 'l') {
						land = true;
						break;
					}
				}
				boolean twoAway = true;
				for (int i=0; i<neighbors.size(); i++) {
					if (neighbors.get(i).getType()!=null) {
						twoAway = false;
						break;
					}
				}
				System.out.println("two awayH: " + twoAway);
				if (p.getType()==null && land  && twoAway && main) {

					settlement = true;
				} else {
					settlement = false;
				}

		} else if (text.equals("Road")) {
			//("road1");
			cp.findRoad(x, y);
			cp.midpoint(  //calculates the midpoint of the road location.
					CatanPieces.getPositions().get(cp.getFirstX()),
					CatanPieces.getPositions().get(cp.getFirstY()),
					CatanPieces.getPositions().get(cp.getSecondX()),
					CatanPieces.getPositions().get(cp.getSecondY()));

			a = cp.getmpX(); //x coordinate of midpoint.
			b = cp.getmpY(); //y coordinate of midpoint.

			int distance = 0;
			if (cp.getRoadRotation() != 90) {  //if the road rotation isn't 90 degrees.
				distance = CatanPieces
						.distance(
								CatanPieces.getPositions().get(
										cp.getFirstX()),
								CatanPieces.getPositions().get(
										cp.getFirstY()),
								CatanPieces.getPositions().get(
										cp.getSecondX()),
								CatanPieces.getPositions().get(
										cp.getSecondY()), 10, 0);
			} else {
				distance = CatanPieces
						.distance( //sets distance for the bounds of the road.
								CatanPieces.getPositions().get(
										cp.getFirstX()),
								CatanPieces.getPositions().get(
										cp.getFirstY()),
								CatanPieces.getPositions().get(
										cp.getSecondX()),
								CatanPieces.getPositions().get(
										cp.getSecondY()), 0, 0);
			}

			button.setBounds(cp.getmpX() - (button.getWidth() / 2), //sets bounds of the road.
					cp.getmpY() - (button.getHeight() / 2), distance,
					15);
			button.setOrigin(button.getWidth() / 2, button.getHeight() / 2);
			button.setTransform(true);
			button.setRotation(cp.getRoadRotation());
			
			if (cp.getRoadRotation() == 90) {
				button.setScaleY(.5f);
				button.setScaleX(.74f);
				button.setX(button.getX() + .5f);
				button.setY(button.getY() + .5f);
			} else {
				button.setScaleY(.95f);
				button.setScaleX(.95f);
			}
			int placement1 = cp.getFirstY() / 2;
			int placement2 = cp.getSecondY() / 2;
			Point one = (Point) Board.getPoints().get(placement1);
			Point two = (Point) Board.getPoints().get(placement2);
			if ((one.getType()!=null && one.getType().toString().contains(color) && one.getType().toString().contains("Settlement")) 
			 || (two.getType()!=null && two.getType().toString().contains(color) && two.getType().toString().contains("Settlement"))) {
				//("bottom");
				if (cp.getRoadRotation() == 90) {  //if the road is 90 degrees.
					//("in the 90 section1");
					set = findHex((int) (cp.getmpX() - 20),
							(int) (cp.getmpY()));
					set2 = findHex((int) (cp.getmpX() + 20),
							(int) (cp.getmpY()));
					if (value.getLand()[set] == 'l'
							|| value.getLand()[set2] == 'l') { //makes sure at least one of the two hexes the road is on is a land hex.

						settlement = true;
					} else {
						settlement = false;
					}
				} else if (cp.getRoadRotation() == -30
						|| cp.getRoadRotation() == 30) {  //if the road is 30 or -30 degrees.
					//("in the +-30 section1");
					set = findHex((int) cp.getmpX(),
							(int) cp.getmpY() - 15);
					set2 = findHex((int) cp.getmpX(),
							(int) cp.getmpY() + 15);
					if (value.getLand()[set] == 'l'
							|| value.getLand()[set2] == 'l') { //makes sure at least one of the two hexes the road is on is a land hex.
						//("it is true");
						settlement = true;
					} else {
						settlement = false;
					}
				}
			}
			else {
				System.out.println("failure");
				settlement = false;
			}
		} else if (text.equals("ShipSettler")) { //build ship
			cp.findRoad(x, y);
			cp.midpoint(
					CatanPieces.getPositions().get(cp.getFirstX()),
					CatanPieces.getPositions().get(cp.getFirstY()),
					CatanPieces.getPositions().get(cp.getSecondX()),
					CatanPieces.getPositions().get(cp.getSecondY()));
			
			a = cp.getmpX(); //x coordinate of midpoint.
			b = cp.getmpY(); //y coordinate of midpoint
			int placement1 = cp.getFirstY() / 2;
			int placement2 = cp.getSecondY() / 2;
			Point one = (Point) Board.getPoints().get(placement1);
			Point two = (Point) Board.getPoints().get(placement2);
			if ((one.getType()!=null && one.getType().toString().contains(color) && one.getType().toString().contains("Harborsettlement")) 
			 || (two.getType()!=null && two.getType().toString().contains(color) && two.getType().toString().contains("Harborsettlement"))) {
				if (cp.getRoadRotation() == 90) {
					set = findHex((int) a - 20,
							(int) b);
					set2 = findHex((int) (a + 20),
							(int) b);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						settlement = true;
					} else {
						settlement = false;
					}
				} else if (cp.getRoadRotation() == -30
						|| cp.getRoadRotation() == 30) {
					set = findHex((int) a,
							(int) b - 15);
					set2 = findHex((int) a,
							(int) b + 15);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						settlement = true;
					} else {
						settlement = false;
					}
				}
			} else {
				settlement = false;
			}
		}
		else if(text.equals("moveShip")) {
			cp.findRoad(x, y);
			cp.midpoint(
					CatanPieces.getPositions().get(cp.getFirstX()),
					CatanPieces.getPositions().get(cp.getFirstY()),
					CatanPieces.getPositions().get(cp.getSecondX()),
					CatanPieces.getPositions().get(cp.getSecondY()));
			
			a = cp.getmpX(); //x coordinate of midpoint.
			b = cp.getmpY(); //y coordinate of midpoint
			
			counter = SettlementLocationIndices.getRoadLocations(a, b);
			if (SettlementLocationIndices.getRoadShip()[counter] != 1
					&& SettlementLocationIndices.getRoadShip()[counter] != 3) {
				if (cp.getRoadRotation() == 90) {
					set = findHex((int) a - 20,
							(int) b);
					set2 = findHex((int) (a + 20),
							(int) b);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						SettlementLocationIndices.getRoadColors()[counter] = color;
						if (SettlementLocationIndices.getRoadShip()[counter] == 0) {
							SettlementLocationIndices.getRoadShip()[counter] = 2;
						}
						else {
						SettlementLocationIndices.getRoadShip()[counter]++;
						}
						settlement = true;
					} else {
						settlement = false;
					}
				} else if (cp.getRoadRotation() == -30
						|| cp.getRoadRotation() == 30) {
					set = findHex((int) a,
							(int) b - 15);
					set2 = findHex((int) a,
							(int) b + 15);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						SettlementLocationIndices.getRoadColors()[counter] = color;
						if (SettlementLocationIndices.getRoadShip()[counter] == 0) {
							SettlementLocationIndices.getRoadShip()[counter] = 2;
						}
						else {
						SettlementLocationIndices.getRoadShip()[counter]++;
						}
						settlement = true;
					} else {
						settlement = false;
					}
				}
			} else {
				settlement = false;
			}	
		}
		else {
			settlement = false;
		}
		//("can settle? :" + settlement);
		return settlement;

	}
	
	//COMMENT
	public boolean moveShip(TextureAtlas atlas, String text, int x1, int y1, int x2, int y2) {
		Ship ship = new Ship(atlas, text);
		cp.findRoad(x2, y2);
		cp.midpoint(
				CatanPieces.getPositions().get(cp.getFirstX()),
				CatanPieces.getPositions().get(cp.getFirstY()),
				CatanPieces.getPositions().get(cp.getSecondX()),
				CatanPieces.getPositions().get(cp.getSecondY()));
		
		a = cp.getmpX(); //x coordinate of midpoint.
		b = cp.getmpY(); //y coordinate of midpoint
		
		counter = SettlementLocationIndices.getRoadLocations(
				a, b);
		
		if (ship.hasMove() && sli.oneAway(x1, y1, x2, y2)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//COMMENT getSli, getCounter, and getColors
	
	public SettlementLocationIndices getSli() {
		return sli;
	}

	public static int getCounter() {
		return counter;
	}
	public static String getColors() {
		return colors;
	}
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) { 
		//x++;
		//("x coordinate: " + screenX);
		//("y coordinate: " + (Gdx.graphics.getHeight() - 1 - screenY));
		// cp.findRoad(screenX, Gdx.graphics.getHeight() - 1 -
		// screenY);
		// cp.midpoint(
		// cp.getPositions().get(cp.getFirstX()),
		// cp.getPositions().get(cp.getFirstY()),
		// cp.getPositions().get(cp.getSecondX()),
		// cp.getPositions().get(cp.getSecondY()));
		// ("x is: " + cp.getmpX());
		// ("y is: " + cp.getmpY());
		//TextureAtlas atlas = new TextureAtlas("Orange.txt");
		//buttons1 = new ImageButton(new TextureRegionDrawable(
				//atlas.findRegion("orangeHarborSettlement")));
//		buttons2 = new ImageButton(new TextureRegionDrawable(
//				atlas.findRegion("orangeRoad")));
//		buttons3 = new ImageButton(new TextureRegionDrawable(
//				atlas.findRegion("orangeRoad")));
//		if (x == 0) {
			//valid(buttons1, "harborsettlement1", screenX, Gdx.graphics.getHeight() - 1
					//- screenY, "orange");
//		}
//		if (x == 1) {
//			valid(buttons2, "road", screenX,
//					Gdx.graphics.getHeight() - 1 - screenY, "orange");
//		}
//		if (x == 2) {
//			valid(buttons3, "road", screenX, Gdx.graphics.getHeight() - 1
//					- screenY, "orange");
//		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
