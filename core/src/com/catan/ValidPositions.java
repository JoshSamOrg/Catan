package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class ValidPositions implements Screen, InputProcessor {
	private SpriteBatch batch;
	private Texture boardStart;
	private CatanGame game;
	private boolean settlement = false; // determines whether a settlement
										// location is a valid placement.
	private static int i = 0;
	private static ImageButton buttons1, buttons2, buttons3;
	private static int counter; // used to get the index for the
	private int x = -1; // settlementLocations array.
	private int set = 0;
	private int set2 = 0;
	private int set3 = 0;
	private int set4 = 0;
	private int mid = 0;
	private int road1 = 0, road2 = 0, road3 = 0, road4 = 0;
	private float a = 0, b = 0;
	private LandValues value;
	private static boolean[][] markedSettlement;

	public ValidPositions(CatanGame game) {
		//CatanPieces.findPositions();
		SettlementLocationIndices set = new SettlementLocationIndices();
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
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 118, 375, 0, 0) <= 23.5) {
			i = 2;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 161, 375, 0, 0) <= 23.5) {
			i = 3;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 97, 339, 0, 0) <= 23.5) {
			i = 4;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 140, 339, 0, 0) <= 23.5) {
			i = 5;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 76, 301, 0, 0) <= 23.5) {
			i = 6;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 118, 301, 0, 0) <= 23.5) {
			i = 7;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 161, 301, 0, 0) <= 23.5) {
			i = 8;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 97, 266, 0, 0) <= 23.5) {
			i = 9;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 140, 266, 0, 0) <= 23.5) {
			i = 10;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 118, 228, 0, 0) <= 23.5) {
			i = 11;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 161, 228, 0, 0) <= 23.5) {
			i = 12;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 140, 191, 0, 0) <= 23.5) {
			i = 13;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 183, 191, 0, 0) <= 23.5) {
			i = 14;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 225, 413, 0, 0) <= 23.5) {
			i = 15;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 268, 413, 0, 0) <= 22.5) {
			i = 16;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 204, 375, 0, 0) <= 22.5) {
			i = 17;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 247, 375, 0, 0) <= 22.5) {
			i = 18;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 183, 339, 0, 0) <= 22.5) {
			i = 19;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 225, 339, 0, 0) <= 22.5) {
			i = 20;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 204, 301, 0, 0) <= 22.5) {
			i = 21;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 247, 301, 0, 0) <= 22.5) {
			i = 22;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 183, 266, 0, 0) <= 22.5) {
			i = 23;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 225, 266, 0, 0) <= 22.5) {
			i = 24;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 204, 228, 0, 0) <= 22.5) {
			i = 25;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 247, 228, 0, 0) <= 22.5) {
			i = 26;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 225, 191, 0, 0) <= 22.5) {
			i = 27;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 268, 191, 0, 0) <= 22.5) {
			i = 28;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 310, 413, 0, 0) <= 22.5) {
			i = 29;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 353, 413, 0, 0) <= 22.5) {
			i = 30;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 396, 413, 0, 0) <= 22.5) {
			i = 31;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 438, 413, 0, 0) <= 22.5) {
			i = 32;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 480, 413, 0, 0) <= 22.5) {
			i = 33;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 290, 375, 0, 0) <= 22.5) {
			i = 34;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 332, 375, 0, 0) <= 22.5) {
			i = 35;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 375, 375, 0, 0) <= 22.5) {
			i = 36;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 418, 375, 0, 0) <= 22.5) {
			i = 37;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 461, 375, 0, 0) <= 22.5) {
			i = 38;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 503, 375, 0, 0) <= 22.5) {
			i = 39;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 268, 339, 0, 0) <= 22.5) {
			i = 40;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 311, 339, 0, 0) <= 22.5) {
			i = 41;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 353, 339, 0, 0) <= 22.5) {
			i = 42;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 396, 339, 0, 0) <= 22.5) {
			i = 43;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 439, 339, 0, 0) <= 22.5) {
			i = 44;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 482, 339, 0, 0) <= 22.5) {
			i = 45;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 525, 339, 0, 0) <= 22.5) {
			i = 46;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 290, 301, 0, 0) <= 22.5) {
			i = 47;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 332, 301, 0, 0) <= 22.5) {
			i = 48;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 375, 301, 0, 0) <= 22.5) {
			i = 49;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 418, 301, 0, 0) <= 22.5) {
			i = 50;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 461, 301, 0, 0) <= 22.5) {
			i = 51;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 503, 301, 0, 0) <= 22.5) {
			i = 52;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 546, 301, 0, 0) <= 22.5) {
			i = 53;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 268, 266, 0, 0) <= 22.5) {
			i = 54;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 311, 266, 0, 0) <= 22.5) {
			i = 55;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 353, 266, 0, 0) <= 22.5) {
			i = 56;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 396, 266, 0, 0) <= 22.5) {
			i = 57;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 439, 266, 0, 0) <= 22.5) {
			i = 58;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 482, 266, 0, 0) <= 22.5) {
			i = 59;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 525, 266, 0, 0) <= 22.5) {
			i = 60;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 289, 228, 0, 0) <= 22.5) {
			i = 61;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 332, 228, 0, 0) <= 22.5) {
			i = 62;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 375, 228, 0, 0) <= 22.5) {
			i = 63;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 418, 228, 0, 0) <= 22.5) {
			i = 64;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 461, 228, 0, 0) <= 22.5) {
			i = 65;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 504, 228, 0, 0) <= 22.5) {
			i = 66;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 311, 191, 0, 0) <= 22.5) {
			i = 67;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 354, 191, 0, 0) <= 22.5) {
			i = 68;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 397, 191, 0, 0) <= 22.5) {
			i = 69;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 440, 191, 0, 0) <= 22.5) {
			i = 70;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 483, 191, 0, 0) <= 22.5) {
			i = 71;
			System.out.println(i);
		} else {
			System.out.println("not in bounds");
			i = 72;
		}
		return i;
	}

	/*
	 * button the image that is going to be placed on the board. 
	 * text the type of piece being put on the board. 
	 * x the x coordinate of the mouse click 
	 * y the y coordinate of the mouse click 
	 * Returns whether the placed image is in a valid location.
	 */
	public boolean valid(ImageButton button, String text, int x, int y, String color) {
		if (text.equals("settlement")) {
			System.out.println("settlement");
			CatanPieces.findSettlement(x, y);  //finds the nearest settlement from the location you clicked on the board.
			set = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()) - 20,
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			set2 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()) + 20,
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			set3 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()) - 20);
			set4 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()) + 20);
			counter = SettlementLocationIndices.getSettlementLocation(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			if ((value.getLand()[set] == 'l' || (value.getLand()[set2] == 'l') //makes sure all three sides of the placement are land hexes
					|| (value.getLand()[set3] == 'l') || value.getLand()[set4] == 'l')
					&& (value.getLand()[set] != 'u'
							&& value.getLand()[set2] != 'u'
							&& value.getLand()[set3] != 'u' && value.getLand()[set4] != 'u')
					&& (SettlementLocationIndices.getSettlementLocations()[counter] == false && SettlementLocationIndices
					// makes sure the placement is not already occupied by another piece.																			
							.getHarborSettlementLocations()[counter] == false)
					&& (SettlementLocationIndices.twoAway( //makes sure placement follows the two-away rule of the game.
							CatanPieces.getPositions().get(
									CatanPieces.getSettlementIndexX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSettlementIndexY())))) {
				SettlementLocationIndices.getSettlementLocations()[counter] = true; //sets the value of the settlement location to occupied (true).
				SettlementLocationIndices.getSettlementColors()[counter] = color;

				settlement = true;
			} else {
				settlement = false;
			}
		} else if (text.equals("harbor settlement")) {
			System.out.println("harbor settlement");
			CatanPieces.findSettlement(x, y);
			set = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()) - 20,
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			set2 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()) + 20,
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			set3 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()) - 20);
			set4 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()) + 20);
			counter = SettlementLocationIndices.getSettlementLocation(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			if (value.getLand()[set] == value.getLand()[set2]
					&& value.getLand()[set2] == value.getLand()[set3]
					&& value.getLand()[set3] == value.getLand()[set4]) {
				settlement = false;
			} else if ((value.getLand()[set] == 'l'
					|| (value.getLand()[set2] == 'l')
					|| (value.getLand()[set3] == 'l') || value.getLand()[set4] == 'l'
					&& (value.getLand()[set] != 'u'
							&& value.getLand()[set2] != 'u'
							&& value.getLand()[set3] != 'u' && value.getLand()[set4] != 'u'))
					&& (SettlementLocationIndices
							.getHarborSettlementLocations()[counter] == false
							&& SettlementLocationIndices
									.getSettlementLocations()[counter] == true && color
								.equals(SettlementLocationIndices
										.getSettlementColors()[counter]))
					&& (SettlementLocationIndices.twoAway(
							CatanPieces.getPositions().get(
									CatanPieces.getSettlementIndexX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSettlementIndexY())))) {
				SettlementLocationIndices.getHarborSettlementLocations()[counter] = true;
				SettlementLocationIndices.getSettlementColors()[counter] = color;

				settlement = true;
			} else {
				settlement = false;
			}
		} else if (text.equals("harborsettlement1")) {
			System.out.println("harborsettlement1");
			CatanPieces.findSettlement(x, y);
			if ((CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 205 && 
				 CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 425)
			 || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 204 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 401)
			 || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 389)
			 || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 364)
	         || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 162 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 351)
	         || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 162 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 327)
		     || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 184 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 315)
		     || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 291)
		     || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 162 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 278)
		     || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 161 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 254)
		     || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 183 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 242)
		     || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 184 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 216)
			 || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 205 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 204)
			 || (CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()) == 205 && 
			     CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY()) == 180)){

			set = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()) - 20,
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			set2 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()) + 20,
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			set3 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()) - 20);
			set4 = findHex(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()) + 20);
			counter = SettlementLocationIndices.getSettlementLocation(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			System.out.println("Counter is: " + counter);
			if (value.getLand()[set] == value.getLand()[set2]
					&& value.getLand()[set2] == value.getLand()[set3]
					&& value.getLand()[set3] == value.getLand()[set4]) {
				settlement = false;
			} else if ((value.getLand()[set] == 'l'
					|| (value.getLand()[set2] == 'l')
					|| (value.getLand()[set3] == 'l') || value.getLand()[set4] == 'l'
					&& (value.getLand()[set] != 'u'
							&& value.getLand()[set2] != 'u'
							&& value.getLand()[set3] != 'u' && value.getLand()[set4] != 'u'))
					&& (SettlementLocationIndices.getHarborSettlementLocations()[counter] == false && SettlementLocationIndices
							.getSettlementLocations()[counter] == false)
					&& (SettlementLocationIndices.twoAway(
							CatanPieces.getPositions().get(
									CatanPieces.getSettlementIndexX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSettlementIndexY())))) {
				SettlementLocationIndices.getHarborSettlementLocations()[counter] = true;
				SettlementLocationIndices.getSettlementColors()[counter] = color;
				settlement = true;
			}
			else {
				settlement = false;
			}
			} else {
				settlement = false;
			}
		} else if (text.equals("road1")) {
			System.out.println("road1");
			CatanPieces.findRoad(x, y);
			CatanPieces.midpoint(  //calculates the midpoint of the road location.
					CatanPieces.getPositions().get(CatanPieces.getFirstX()),
					CatanPieces.getPositions().get(CatanPieces.getFirstY()),
					CatanPieces.getPositions().get(CatanPieces.getSecondX()),
					CatanPieces.getPositions().get(CatanPieces.getSecondY()));

			a = CatanPieces.getmpX(); //x coordinate of midpoint.
			b = CatanPieces.getmpY(); //y coordinate of midpoint.

			int distance = 0;
			if (CatanPieces.getRoadRotation() != 90) {  //if the road rotation isn't 90 degrees.
				distance = CatanPieces //sets distance for the bounds of the road.
						.distance(
								CatanPieces.getPositions().get(
										CatanPieces.getFirstX()),
								CatanPieces.getPositions().get(
										CatanPieces.getFirstY()),
								CatanPieces.getPositions().get(
										CatanPieces.getSecondX()),
								CatanPieces.getPositions().get(
										CatanPieces.getSecondY()), 10, 0);
			} else {
				distance = CatanPieces
						.distance( //sets distance for the bounds of the road.
								CatanPieces.getPositions().get(
										CatanPieces.getFirstX()),
								CatanPieces.getPositions().get(
										CatanPieces.getFirstY()),
								CatanPieces.getPositions().get(
										CatanPieces.getSecondX()),
								CatanPieces.getPositions().get(
										CatanPieces.getSecondY()), 0, 0);
			}

			button.setBounds(CatanPieces.getmpX() - (button.getWidth() / 2), //sets bounds of the road.
					CatanPieces.getmpY() - (button.getHeight() / 2), distance,
					15);
			button.setOrigin(button.getWidth() / 2, button.getHeight() / 2);
			button.setTransform(true);
			button.setRotation(CatanPieces.getRoadRotation());
			
			mid = SettlementLocationIndices.getRoadLocations(  //location of the road.
					a, b);
			if (CatanPieces.getRoadRotation() == 90) {
				button.setScaleY(.5f);
				button.setScaleX(.74f);
				button.setX(button.getX() + .5f);
				button.setY(button.getY() + .5f);
			} else {
				button.setScaleY(.95f);
				button.setScaleX(.95f);
			}

			set3 = SettlementLocationIndices.getSettlementLocation(CatanPieces //first possible settlement on the road.
					.getPositions().get(CatanPieces.getFirstX()), CatanPieces
					.getPositions().get(CatanPieces.getFirstY()));
			set4 = SettlementLocationIndices.getSettlementLocation(CatanPieces //second possible settlement on the road.
					.getPositions().get(CatanPieces.getSecondX()), CatanPieces
					.getPositions().get(CatanPieces.getSecondY()));
			if ((SettlementLocationIndices.getSettlementLocations()[set3]  //makes sure a similar-colored settlement is at the end of a road.
					|| SettlementLocationIndices.getSettlementLocations()[set4])
					&& (color.equals(SettlementLocationIndices
							.getSettlementColors()[set3]) || (color
							.equals(SettlementLocationIndices
									.getSettlementColors()[set4])))
					&& (SettlementLocationIndices.getRoadShip()[mid] == 0)) {
				System.out.println("bottom");
				if (CatanPieces.getRoadRotation() == 90) {  //if the road is 90 degrees.
					//System.out.println("in the 90 section1");
					set = findHex((int) (CatanPieces.getmpX() - 20),
							(int) (CatanPieces.getmpY()));
					set2 = findHex((int) (CatanPieces.getmpX() + 20),
							(int) (CatanPieces.getmpY()));
					if (value.getLand()[set] == 'l'
							|| value.getLand()[set2] == 'l') { //makes sure at least one of the two hexes the road is on is a land hex.
						SettlementLocationIndices.getRoadColors()[mid] = color;
						SettlementLocationIndices.getRoadShip()[mid] = 1;

						settlement = true;
					} else {
						settlement = false;
					}
				} else if (CatanPieces.getRoadRotation() == -30
						|| CatanPieces.getRoadRotation() == 30) {  //if the road is 30 or -30 degrees.
					//System.out.println("in the +-30 section1");
					set = findHex((int) CatanPieces.getmpX(),
							(int) CatanPieces.getmpY() - 15);
					set2 = findHex((int) CatanPieces.getmpX(),
							(int) CatanPieces.getmpY() + 15);
					if (value.getLand()[set] == 'l'
							|| value.getLand()[set2] == 'l') { //makes sure at least one of the two hexes the road is on is a land hex.
						System.out.println("it is true");
						SettlementLocationIndices.getRoadColors()[mid] = color;
						SettlementLocationIndices.getRoadShip()[mid] = 1;
						settlement = true;
					} else {
						settlement = false;
					}
				}
			} else if (SettlementLocationIndices.getSettlementLocations()[set3] == false //if there is not a settlement on the end of the road.
					&& SettlementLocationIndices.getHarborSettlementLocations()[set3] == false
					&& SettlementLocationIndices.getSettlementLocations()[set4] == false
					&& SettlementLocationIndices.getHarborSettlementLocations()[set4] == false) {
				//System.out.println("not a settlement road");
				if (CatanPieces.getRoadRotation() == 90) { //if road rotation is 90 degrees.
					//System.out.println("1");
					CatanPieces.findRoad((int) a - 10,
							(int) b + 17);
					CatanPieces.midpoint( //finds midpoint of road.
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road1 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a + 10, (int) b + 17); //finds nearest road location
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road2 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a + 10, (int) b - 17); //finds nearest road location
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road3 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a - 10, (int) b - 17); //finds nearest road location
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road4 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					if ((SettlementLocationIndices.getRoadShip()[road1] == 1 && color //makes sure road and settlement are same color.
							.equals(SettlementLocationIndices.getRoadColors()[road1]))
							|| (SettlementLocationIndices.getRoadShip()[road2] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road2]))
							|| (SettlementLocationIndices.getRoadShip()[road3] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road3]))
							|| (SettlementLocationIndices.getRoadShip()[road4] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road4]))) {
						set = findHex((int) a - 20,
								(int) b);
						set2 = findHex((int) a + 20,
								(int) b);
						if (value.getLand()[set] == 'l'
								|| value.getLand()[set2] == 'l') {
							SettlementLocationIndices.getRoadColors()[mid] = color;
							SettlementLocationIndices.getRoadShip()[mid] = 1;
							settlement = true;
						} else {
							settlement = false;
						}
					} else {
						settlement = false;
					}
				} else if (CatanPieces.getRoadRotation() == -30) {
					//System.out.println("2");
					CatanPieces.findRoad((int) a - 10,
							(int) b + 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road1 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a + 10,
							(int) + 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road2 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a + 10, (int) b - 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road3 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a - 10, (int) b - 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road4 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					if ((SettlementLocationIndices.getRoadShip()[road1] == 1 && color
							.equals(SettlementLocationIndices.getRoadColors()[road1]))
							|| (SettlementLocationIndices.getRoadShip()[road2] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road2]))
							|| (SettlementLocationIndices.getRoadShip()[road3] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road3]))
							|| (SettlementLocationIndices.getRoadShip()[road4] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road4]))) {
						set = findHex((int) a,
								(int) b + 15);
						set2 = findHex((int) (CatanPieces.getmpX()),
								(int) (CatanPieces.getmpY() - 15));
						if (value.getLand()[set] == 'l'
								|| value.getLand()[set2] == 'l') {
							SettlementLocationIndices.getRoadColors()[mid] = color;
							SettlementLocationIndices.getRoadShip()[mid] = 1;
							settlement = true;
						} else {
							settlement = false;
						}
					} else {
						settlement = false;
					}
				} else if (CatanPieces.getRoadRotation() == 30) {
					//System.out.println("3");
					CatanPieces.findRoad((int) a - 10,
							(int) b + 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road1 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a + 10,
							(int) b + 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road2 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a + 10, (int) b - 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road3 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					CatanPieces.findRoad((int) a - 10, (int) b - 17);
					CatanPieces.midpoint(
							CatanPieces.getPositions().get(
									CatanPieces.getFirstX()),
							CatanPieces.getPositions().get(
									CatanPieces.getFirstY()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondX()),
							CatanPieces.getPositions().get(
									CatanPieces.getSecondY()));
					road4 = SettlementLocationIndices.getRoadLocations(
							CatanPieces.getmpX(), CatanPieces.getmpY());
					if ((SettlementLocationIndices.getRoadShip()[road1] == 1 && color
							.equals(SettlementLocationIndices.getRoadColors()[road1]))
							|| (SettlementLocationIndices.getRoadShip()[road2] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road2]))
							|| (SettlementLocationIndices.getRoadShip()[road3] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road3]))
							|| (SettlementLocationIndices.getRoadShip()[road4] == 1 && color
									.equals(SettlementLocationIndices
											.getRoadColors()[road4]))) {
						set = findHex((int) a,
								(int) b + 15);
						set2 = findHex((int) a,
								(int) b - 15);
						if (value.getLand()[set] == 'l'
								|| value.getLand()[set2] == 'l') {
							SettlementLocationIndices.getRoadColors()[mid] = color;
							SettlementLocationIndices.getRoadShip()[mid] = 1;
							settlement = true;
						} else {
							settlement = false;
						}
					} else {
						settlement = false;
					}
				}
			} else {
				settlement = false;
			}
		} else if (text.equals("shipsettler")) { //build ship
			CatanPieces.findRoad(x, y);
			CatanPieces.midpoint(
					CatanPieces.getPositions().get(CatanPieces.getFirstX()),
					CatanPieces.getPositions().get(CatanPieces.getFirstY()),
					CatanPieces.getPositions().get(CatanPieces.getSecondX()),
					CatanPieces.getPositions().get(CatanPieces.getSecondY()));
			
			a = CatanPieces.getmpX(); //x coordinate of midpoint.
			b = CatanPieces.getmpY(); //y coordinate of midpoint
			
			mid = SettlementLocationIndices.getRoadLocations(
					a, b);
			set3 = SettlementLocationIndices.getSettlementLocation(CatanPieces
					.getPositions().get(CatanPieces.getFirstX()), CatanPieces
					.getPositions().get(CatanPieces.getFirstY()));
			set4 = SettlementLocationIndices.getSettlementLocation(CatanPieces
					.getPositions().get(CatanPieces.getSecondX()), CatanPieces
					.getPositions().get(CatanPieces.getSecondY()));
			if (SettlementLocationIndices.getRoadShip()[mid] != 1
					&& SettlementLocationIndices.getRoadShip()[mid] != 3
					&& ((SettlementLocationIndices
							.getHarborSettlementLocations()[set3]) || (SettlementLocationIndices
							.getHarborSettlementLocations()[set4]))
					&& (color.equals(SettlementLocationIndices
							.getSettlementColors()[set3]) || color
							.equals(SettlementLocationIndices
									.getSettlementColors()[set4]))) {
				if (CatanPieces.getRoadRotation() == 90) {
					set = findHex((int) a - 20,
							(int) b);
					set2 = findHex((int) (a + 20),
							(int) b);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						SettlementLocationIndices.getRoadColors()[mid] = color;
						if (SettlementLocationIndices.getRoadShip()[mid] == 0) {
							SettlementLocationIndices.getRoadShip()[mid] = 2;	
						}
						else {
						SettlementLocationIndices.getRoadShip()[mid]++;
						}
						settlement = true;
					} else {
						settlement = false;
					}
				} else if (CatanPieces.getRoadRotation() == -30
						|| CatanPieces.getRoadRotation() == 30) {
					set = findHex((int) a,
							(int) b - 15);
					set2 = findHex((int) a,
							(int) b + 15);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						SettlementLocationIndices.getRoadColors()[mid] = color;
						if (SettlementLocationIndices.getRoadShip()[mid] == 0) {
							SettlementLocationIndices.getRoadShip()[mid] = 2;
						}
						else {
						SettlementLocationIndices.getRoadShip()[mid]++;
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
		else if(text.equals("moveShip")) {
			CatanPieces.findRoad(x, y);
			CatanPieces.midpoint(
					CatanPieces.getPositions().get(CatanPieces.getFirstX()),
					CatanPieces.getPositions().get(CatanPieces.getFirstY()),
					CatanPieces.getPositions().get(CatanPieces.getSecondX()),
					CatanPieces.getPositions().get(CatanPieces.getSecondY()));
			
			a = CatanPieces.getmpX(); //x coordinate of midpoint.
			b = CatanPieces.getmpY(); //y coordinate of midpoint
			
			mid = SettlementLocationIndices.getRoadLocations(a, b);
			if (SettlementLocationIndices.getRoadShip()[mid] != 1
					&& SettlementLocationIndices.getRoadShip()[mid] != 3) {
				if (CatanPieces.getRoadRotation() == 90) {
					set = findHex((int) a - 20,
							(int) b);
					set2 = findHex((int) (a + 20),
							(int) b);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						SettlementLocationIndices.getRoadColors()[mid] = color;
						if (SettlementLocationIndices.getRoadShip()[mid] == 0) {
							SettlementLocationIndices.getRoadShip()[mid] = 2;
						}
						else {
						SettlementLocationIndices.getRoadShip()[mid]++;
						}
						settlement = true;
					} else {
						settlement = false;
					}
				} else if (CatanPieces.getRoadRotation() == -30
						|| CatanPieces.getRoadRotation() == 30) {
					set = findHex((int) a,
							(int) b - 15);
					set2 = findHex((int) a,
							(int) b + 15);
					if (value.getLand()[set] == 's'
							|| value.getLand()[set2] == 's') {
						SettlementLocationIndices.getRoadColors()[mid] = color;
						if (SettlementLocationIndices.getRoadShip()[mid] == 0) {
							SettlementLocationIndices.getRoadShip()[mid] = 2;
						}
						else {
						SettlementLocationIndices.getRoadShip()[mid]++;
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
		System.out.println("can settle? :" + settlement);
		return settlement;

	}
	
	public boolean moveShip(TextureAtlas atlas, String text, int x, int y) {
		Ship ship = new Ship(atlas, text);
		
		if (ship.hasMove()) {
			return true;
		}
		else {
			return false;
		}
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
		x++;
		System.out.println("x coordinate: " + screenX);
		System.out.println("y coordinate: " + (Gdx.graphics.getHeight() - 1 - screenY));
		// CatanPieces.findRoad(screenX, Gdx.graphics.getHeight() - 1 -
		// screenY);
		// CatanPieces.midpoint(
		// CatanPieces.getPositions().get(CatanPieces.getFirstX()),
		// CatanPieces.getPositions().get(CatanPieces.getFirstY()),
		// CatanPieces.getPositions().get(CatanPieces.getSecondX()),
		// CatanPieces.getPositions().get(CatanPieces.getSecondY()));
		// System.out.println("x is: " + CatanPieces.getmpX());
		// System.out.println("y is: " + CatanPieces.getmpY());
		TextureAtlas atlas = new TextureAtlas("Orange.txt");
		buttons1 = new ImageButton(new TextureRegionDrawable(
				atlas.findRegion("orangeHarborSettlement")));
//		buttons2 = new ImageButton(new TextureRegionDrawable(
//				atlas.findRegion("orangeRoad")));
//		buttons3 = new ImageButton(new TextureRegionDrawable(
//				atlas.findRegion("orangeRoad")));
//		if (x == 0) {
			valid(buttons1, "harborsettlement1", screenX, Gdx.graphics.getHeight() - 1
					- screenY, "orange");
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
