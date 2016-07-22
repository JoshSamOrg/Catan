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

public class validPositions implements Screen, InputProcessor {
	private SpriteBatch batch;
	private Texture boardStart;
	private CatanGame game;
	private boolean settlement = false; //determines whether a settlement location is a valid placement.
	private static int i = 0;
	private SettlementLocationIndices settle;
	private static int counter; //used to get the index for the settlementLocations array.
	private int set = 0;
	private int set2 = 0;
	private int set3 = 0;
	private int set4 = 0;
	private LandValues value;
	private static boolean[][] markedSettlement;

	public validPositions(CatanGame game) {
		CatanPieces.findPositions();
		value = new LandValues();
		settle = new SettlementLocationIndices();
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
	 * x the x coordinate of the mouse click.
	 * y the y coordinate of the mouse click.
	 * Returns the index of the hex found in the land array (in the LandValues class).
	 */
	public static int findHex(int x, int y) {
		if (CatanPieces.distance(x, y, 140, 413, 0, 0) <= 21.5) {
			i = 0;
		} else if (CatanPieces.distance(x, y, 183, 413, 0, 0) <= 21.5) {
			i = 1;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 118, 375, 0, 0) <= 21.5) {
			i = 2;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 161, 375, 0, 0) <= 21.5) {
			i = 3;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 97, 339, 0, 0) <= 21.5) {
			i = 4;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 140, 339, 0, 0) <= 21.5) {
			i = 5;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 76, 301, 0, 0) <= 21.5) {
			i = 6;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 118, 301, 0, 0) <= 21.5) {
			i = 7;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 161, 301, 0, 0) <= 21.5) {
			i = 8;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 97, 266, 0, 0) <= 21.5) {
			i = 9;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 140, 266, 0, 0) <= 21.5) {
			i = 10;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 118, 228, 0, 0) <= 21.5) {
			i = 11;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 161, 228, 0, 0) <= 21.5) {
			i = 12;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 140, 191, 0, 0) <= 21.5) {
			i = 13;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 183, 191, 0, 0) <= 21.5) {
			i = 14;
			System.out.println(i);
		} else if (CatanPieces.distance(x, y, 225, 413, 0, 0) <= 22.5) {
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
	public boolean valid(ImageButton button, String text, int x, int y) {
		if (text.equals("settlement")) {
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
			counter = SettlementLocationIndices.getHexLocations(
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexX()),
					CatanPieces.getPositions().get(
							CatanPieces.getSettlementIndexY()));
			if ((value.getLand()[set] == 'l' || (value.getLand()[set2] == 'l')
					|| (value.getLand()[set3] == 'l') || value.getLand()[set4] == 'l')
					&& (SettlementLocationIndices.getSettlementLocations()[counter] == false) && 
					(SettlementLocationIndices.twoAway(CatanPieces.getPositions().get(CatanPieces.getSettlementIndexX()), 
							CatanPieces.getPositions().get(CatanPieces.getSettlementIndexY())))) {
				SettlementLocationIndices.getSettlementLocations()[counter] = true;

				settlement = true;
			} else {
				settlement = false;
			}
		}
		System.out.println("inside:" + settlement);
		return settlement;

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
		System.out.println(screenX);
		System.out.println(Gdx.graphics.getHeight() - 1 - screenY);
		TextureAtlas atlas = new TextureAtlas("Orange.txt");
		ImageButton buttons = new ImageButton(new TextureRegionDrawable(
				atlas.findRegion("orangeSettlement")));
		valid(buttons, "settlement", screenX, Gdx.graphics.getHeight() - 1
				- screenY);
		// TODO Auto-generated method stub
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
