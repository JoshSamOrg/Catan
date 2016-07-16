package com.catan;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class HexGenerator implements Screen, InputProcessor {

	private PlayerOrder orders;
	private LoadingScreen load;
	private ArrayList<TextureRegion> board, board2;
	private TextureRegion wood, ore, sheep, wheat, brick;
	int b, w, s, o, wo = 0;
	private TextureAtlas atlas, atlas2, atlas3;
	private Texture startingBoard;
	private Random rand;
	private SpriteBatch batch;
	private CatanGame game;
	private int set, set2, set3, set4, set5, set6, set7, set8, set9, set10,
			set11, set12, set13, set14, set15, set16, set17, set18, set19, set20, set21, set22, set23, set24, set25, set26, set27, set28, setg = 0;
	private boolean counter = false;
	private boolean bool = true;
	private boolean bool2 = true;
	private boolean bool3 = true;
	private boolean bool4 = true;
	private boolean bool5 = true;
	private boolean bool6 = true;
	private boolean bool7 = true;
	private boolean bool8 = true;
	private boolean bool9 = true;
	private boolean bool10 = true;
	private boolean bool11 = true;
	private boolean bool12 = true;
	private boolean bool13 = true;
	private boolean bool14 = true;
	private boolean find = true;
	private boolean find2 = true;
	private boolean find3 = true;
	private boolean find4 = true;
	private boolean find5 = true;
	private boolean find6 = true;
	private boolean find7 = true;
	private boolean find8 = true;
	private boolean find9 = true;
	private boolean find10 = true;
	private boolean find11 = true;
	private boolean find12 = true;
	private boolean find13 = true;
	private boolean find14 = true;
	private boolean find15 = true;
	private boolean findg = true;
	private Stage stage;
	private BitmapFont font, font2;
	private Skin skin;
	private Pixmap pixmap;
	private TextButton button;

	private int numberWidth = 25;
	private int numberHeight = 25;
	private int imageStartX = 20;
	private int imageY = 10;
	private int h1x = 127;
	private int h1y = 401;
	private int h2x = 170;
	private int h2y = 402;
	private int h3x = 106;
	private int h3y = 365;
	private int h4x = 149;
	private int h4y = 364;
	private int h5x = 85;
	private int h5y = 327;
	private int h6x = 128;
	private int h6y = 327;
	private int h7x = 106;
	private int h7y = 291;
	private int h8x = 149;
	private int h8y = 291;
	private int h9x = 84;
	private int h9y = 254;
	private int h10x = 127;
	private int h10y = 254;
	private int h11x = 106;
	private int h11y = 216;
	private int h12x = 149;
	private int h12y = 216;
	private int h13x = 127;
	private int h13y = 180;
	private int h14x = 171;
	private int h14y = 180;
	private int grassx = 63;
	private int grassy = 289;
	private int[] coords = { h1x, h1y, h2x, h2y, h3x, h3y, h4x, h4y, h5x, h5y,
			h6x, h6y, grassx, grassy, h7x, h7y, h8x, h8y, h9x, h9y, h10x, h10y,
			h11x, h11y, h12x, h12y, h13x, h13y, h14x, h14y };
	private boolean[] openSpots = { true, true, true, true, true, true, true,
			true, true, true, true, true, true, true, true };// size = 15
	private int[] HexLocations = { 15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15,
			15, 15, 15, 15 }; // size = 15
	private ArrayList<TextureRegion> numbers;
	private ArrayList<ImageButton> numberImages;
	private InputMultiplexer multiplexer;
	private TextButton finalizeNumbers;
	private TextField field;
	private TextField field2;

	public HexGenerator(CatanGame game) {
		this.game = game;
	}

	public void show() {
		board2 = new ArrayList<TextureRegion>();
		load = new LoadingScreen(game);

		orders = new PlayerOrder();
		orders.Orders();
		startingBoard = new Texture(Gdx.files.internal("Scenario5Final.png"));
		batch = new SpriteBatch();
		board = new ArrayList<TextureRegion>();
		rand = new Random();
		atlas = new TextureAtlas(Gdx.files.internal("hexesNoBlack2.txt"));
		wood = atlas.findRegion("woodNoBlack2");
		wheat = atlas.findRegion("wheatNoBlack2");
		ore = atlas.findRegion("oreNoBlack2");
		sheep = atlas.findRegion("sheepNoBlack2");
		brick = atlas.findRegion("brickNoBlack2");
		for (int i = 0; i < 3; i++) {
			board.add(sheep);
		}
		for (int i = 0; i < 4; i++) {
			board.add(wood);
		}
		for (int i = 0; i < 2; i++) {
			board.add(wheat);
		}
		for (int i = 0; i < 3; i++) {
			board.add(ore);
		}
		for (int i = 0; i < 2; i++) {
			board.add(brick);
		}

		atlas3 = new TextureAtlas(Gdx.files.internal("mainIslandNumbers.txt"));
		multiplexer = new InputMultiplexer();
		stage = new Stage();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(this);
		Gdx.input.setInputProcessor(multiplexer);
		numbers = new ArrayList<TextureRegion>();
		numberImages = new ArrayList<ImageButton>();
		if(LoadingScreen.getPickNumbers()){
		drawNumbers();
		}
		font = new BitmapFont(Gdx.files.internal("gameFonts.fnt"));
		font2 = new BitmapFont(Gdx.files.internal("gameFonts.fnt"));
		font2.getData().setScale(.7f, .7f);
		skin = new Skin();
		atlas2 = new TextureAtlas(Gdx.files.internal("myTextures.txt"));
		pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("pmap", new Texture(pixmap));
		skin.add("default", font);
		skin.add("default2", font2);
		TextureRegion upr = atlas2.findRegion("t5");
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = new TextureRegionDrawable(upr);
		textButtonStyle.down = skin.newDrawable("pmap", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("pmap", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("pmap", Color.LIGHT_GRAY);
		textButtonStyle.font = font;
		skin.add("tStyle", textButtonStyle);
		button = new TextButton("Player Order", skin, "tStyle");
		button.setBounds(50, 50, 200, 50);
		if(LoadingScreen.getPickNumbers()){
		button.setVisible(false);
		}
		stage.addActor(button);
		button.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				counter = true;

			}
		});

		finalizeNumbers = new TextButton("Finalize Numbers", skin, "tStyle");
		finalizeNumbers.setBounds(350, 55, 260, 50);
		finalizeNumbers.setVisible(false);
		stage.addActor(finalizeNumbers);
		finalizeNumbers.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				actor.setVisible(false);
				button.setVisible(true);
				for (int i = 0; i < numberImages.size(); i++) {
					numberImages.get(i).clearListeners();
				}
			}
		});

		TextFieldStyle tfstyle = new TextFieldStyle();
		tfstyle.font = font2;
		tfstyle.fontColor = Color.WHITE;
		skin.add("tfstyle", tfstyle);
		field = new TextField(
				"Click on a number, then move your mouse to the hexagon you",
				skin, "tfstyle");
		field2 = new TextField(
				"want the number to go inside of and click inside that hexagon",
				skin, "tfstyle");
		field.setBounds(5, 70, 800, 50);
		field2.setBounds(5, 40, 800, 50);
		if(LoadingScreen.getPickNumbers()){
		stage.addActor(field);
		stage.addActor(field2);
		}

		board2.add(atlas3.findRegion("12"));
		board2.add(atlas3.findRegion("green3"));
		board2.add(atlas3.findRegion("green3"));
		board2.add(atlas3.findRegion("green6"));
		board2.add(atlas3.findRegion("green6"));
		board2.add(atlas3.findRegion("orange4"));
		board2.add(atlas3.findRegion("orange4"));
		board2.add(atlas3.findRegion("orange5"));
		board2.add(atlas3.findRegion("orange8"));
		board2.add(atlas3.findRegion("orange8"));
		board2.add(atlas3.findRegion("orange9"));
		board2.add(atlas3.findRegion("orange10"));
		board2.add(atlas3.findRegion("orange10"));
		board2.add(atlas3.findRegion("orange11"));
		board2.add(atlas3.findRegion("orange11"));
	}

	public boolean isMainIslandFull() {
		for (int i = 0; i < openSpots.length; i++) {
			if (openSpots[i]) {
				return false;
			}
		}
		return true;
	}

	private void drawNumbers() {
		numbers.add(atlas3.findRegion("12"));
		numbers.add(atlas3.findRegion("green3"));
		numbers.add(atlas3.findRegion("green3"));
		numbers.add(atlas3.findRegion("green6"));
		numbers.add(atlas3.findRegion("green6"));
		numbers.add(atlas3.findRegion("orange4"));
		numbers.add(atlas3.findRegion("orange4"));
		numbers.add(atlas3.findRegion("orange5"));
		numbers.add(atlas3.findRegion("orange8"));
		numbers.add(atlas3.findRegion("orange8"));
		numbers.add(atlas3.findRegion("orange9"));
		numbers.add(atlas3.findRegion("orange10"));
		numbers.add(atlas3.findRegion("orange10"));
		numbers.add(atlas3.findRegion("orange11"));
		numbers.add(atlas3.findRegion("orange11"));
		for (int i = 0; i < numbers.size(); i++) {
			numberImages.add(new ImageButton(new TextureRegionDrawable(numbers
					.get(i))));
			numberImages.get(i).setBounds(imageStartX, imageY, 25, 25);
			stage.addActor(numberImages.get(i));
			imageStartX += 40;
			numberImages.get(i).addListener(new ChangeListener() {
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					actor.setVisible(false);
					multiplexer.removeProcessor(stage);
				}
			});
		}
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(startingBoard, 0, 0, 650, 650);
		batch.end();
		if (bool) {
			set = rand.nextInt(board.size());
			bool = false;
		}
		batch.begin();
		batch.draw(board.get(set), 119.25f, 389.8f, 42.4f, 47.53f);
		batch.end();
		board.add(board.get(set));
		board.remove(set);
		set = board.size() - 1;

		if (bool2) {
			set2 = rand.nextInt(board.size() - 1);
			bool2 = false;
		}
		batch.begin();
		batch.draw(board.get(set2), 162.7f, 389.8f, 41.7f, 47.5f);
		batch.end();
		board.add(13, board.get(set2));
		board.remove(set2);
		set2 = board.size() - 2;

		if (bool3) {
			set3 = rand.nextInt(board.size() - 2);
			bool3 = false;
		}
		batch.begin();
		batch.draw(board.get(set3), 97.8f, 352.1f, 42f, 47.8f);
		batch.end();
		board.add(12, board.get(set3));
		board.remove(set3);
		set3 = board.size() - 3;

		if (bool4) {
			set4 = rand.nextInt(board.size() - 3);
			bool4 = false;
		}
		batch.begin();
		batch.draw(board.get(set4), 141.1f, 352f, 42f, 47.8f);
		batch.end();
		board.add(11, board.get(set4));
		board.remove(set4);
		set4 = board.size() - 4;

		if (bool5) {
			set5 = rand.nextInt(board.size() - 4);
			bool5 = false;
		}
		batch.begin();
		batch.draw(board.get(set5), 76.9f, 315.3f, 41.6f, 46.7f);
		batch.end();
		board.add(10, board.get(set5));
		board.remove(set5);
		set5 = board.size() - 5;

		if (bool6) {
			set6 = rand.nextInt(board.size() - 5);
			bool6 = false;
		}
		batch.begin();
		batch.draw(board.get(set6), 119.8f, 314.95f, 42f, 47.1f);
		batch.end();
		board.add(9, board.get(set6));
		board.remove(set6);
		set6 = board.size() - 6;

		if (bool7) {
			set7 = rand.nextInt(board.size() - 6);
			bool7 = false;
		}
		batch.begin();
		batch.draw(board.get(set7), 98.35f, 278.9f, 42f, 46f);
		batch.end();
		board.add(8, board.get(set7));
		board.remove(set7);
		set7 = board.size() - 7;

		if (bool8) {
			set8 = rand.nextInt(board.size() - 7);
			bool8 = false;
		}
		batch.begin();
		batch.draw(board.get(set8), 142f, 278.85f, 41.3f, 46.35f);
		batch.end();
		board.add(7, board.get(set8));
		board.remove(set8);
		set8 = board.size() - 8;

		if (bool9) {
			set9 = rand.nextInt(board.size() - 8);
			bool9 = false;
		}
		batch.begin();
		batch.draw(board.get(set9), 76.45f, 241.85f, 41.9f, 46.4f);
		batch.end();
		board.add(6, board.get(set9));
		board.remove(set9);
		set9 = board.size() - 9;

		if (bool10) {
			set10 = rand.nextInt(board.size() - 9);
			bool10 = false;
		}
		batch.begin();
		batch.draw(board.get(set10), 119.9f, 241.8f, 41.5f, 47.1f);
		batch.end();
		board.add(5, board.get(set10));
		board.remove(set10);
		set10 = board.size() - 10;

		if (bool11) {
			set11 = rand.nextInt(board.size() - 10);
			bool11 = false;
		}
		batch.begin();
		batch.draw(board.get(set11), 98.4f, 204.5f, 41.7f, 47.4f);
		batch.end();
		board.add(4, board.get(set11));
		board.remove(set11);
		set11 = board.size() - 11;

		if (bool12) {
			set12 = rand.nextInt(board.size() - 11);
			bool12 = false;
		}
		batch.begin();
		batch.draw(board.get(set12), 141.5f, 204.58f, 41.7f, 47.5f);
		batch.end();
		board.add(3, board.get(set12));
		board.remove(set12);
		set12 = board.size() - 12;

		if (bool13) {
			set13 = rand.nextInt(board.size() - 12);
			bool13 = false;
		}
		batch.begin();
		batch.draw(board.get(set13), 119.3f, 167f, 42.2f, 47.5f);
		batch.end();
		board.add(2, board.get(set13));
		board.remove(set13);
		set13 = board.size() - 13;

		if (bool14) {
			set14 = rand.nextInt(board.size() - 13);
			bool14 = false;
		}
		batch.begin();
		batch.draw(board.get(set14), 162.8f, 167.25f, 41.5f, 47.6f);
		batch.end();
		board.add(1, board.get(set14));
		board.remove(set14);
		set14 = board.size() - 14;

		if (counter) {
			batch.begin();
			button.setVisible(false);
			font2.draw(batch, orders.getCounter().get(0).getName() + " "
					+ "is going first", 5, 160);
			batch.end();
			batch.begin();
			font2.draw(batch, orders.getCounter().get(1).getName() + " "
					+ "is going second", 5, 120);
			batch.end();
			if (orders.getCount() == 3) {
				batch.begin();
				font2.draw(batch, orders.getCounter().get(2).getName() + " "
						+ "is going third", 5, 80);
				batch.end();
			}
			if (orders.getCount() == 4) {
				batch.begin();
				font2.draw(batch, orders.getCounter().get(2).getName() + " "
						+ "is going third", 5, 80);
				font2.draw(batch, orders.getCounter().get(3).getName() + " "
						+ "is going fourth", 5, 40);
				batch.end();
			}
		}
		if (load.getSetter()) {
			if (find) {
				set15 = rand.nextInt(board2.size());
				find = false;
			}
			batch.begin();
			batch.draw(board2.get(set15), h1x, h1y, 25, 25);
			batch.end();
			board2.add(board2.get(set15));
			board2.remove(set15);
			set15 = board2.size() - 1;
			
			if (find2) {
				set16 = rand.nextInt(board2.size()-1);
				find2 = false;
			}
			batch.begin();
			batch.draw(board2.get(set16), h2x, h2y, 25, 25);
			batch.end();
			board2.add(14, board2.get(set16));
			board2.remove(set16);
			set16 = board2.size() - 2;

			if (find3) {
				set17 = rand.nextInt(board2.size() - 2);
				find3 = false;
			}
			batch.begin();
			batch.draw(board2.get(set17), h3x, h3y, 25, 25);
			batch.end();
			board2.add(13, board2.get(set17));
			board2.remove(set17);
			set17 = board2.size() - 3;

			if (find4) {
				set18 = rand.nextInt(board2.size() - 3);
				find4 = false;
			}
			batch.begin();
			batch.draw(board2.get(set18), h4x, h4y, 25, 25);
			batch.end();
			board2.add(12, board2.get(set18));
			board2.remove(set18);
			set18 = board2.size() - 4;

			if (find5) {
				set19 = rand.nextInt(board2.size() - 4);
				find5 = false;
			}
			batch.begin();
			batch.draw(board2.get(set19), h5x, h5y, 25, 25);
			batch.end();
			board2.add(11, board2.get(set19));
			board2.remove(set19);
			set19 = board2.size() - 5;

			if (find6) {
				set20 = rand.nextInt(board2.size() - 5);
				find6 = false;
			}
			batch.begin();
			batch.draw(board2.get(set20), h6x, h6y, 25, 25);
			batch.end();
			board2.add(10, board2.get(set20));
			board2.remove(set20);
			set20 = board2.size() - 6;
			
			if (findg) {
				setg = rand.nextInt(board2.size() - 6);
				findg = false;
			}
			batch.begin();
			batch.draw(board2.get(setg), grassx, grassy, 25, 25);
			batch.end();
			board2.add(9, board2.get(setg));
			board2.remove(setg);
			setg = board2.size() - 7;

			if (find7) {
				set21 = rand.nextInt(board2.size() - 7);
				find7 = false;
			}
			batch.begin();
			batch.draw(board2.get(set21), h7x, h7y, 25, 25);
			batch.end();
			board2.add(8, board2.get(set21));
			board2.remove(set21);
			set21 = board2.size() - 8;

			if (find8) {
				set22 = rand.nextInt(board2.size() - 8);
				find8 = false;
			}
			batch.begin();
			batch.draw(board2.get(set22), h8x, h8y, 25, 25);
			batch.end();
			board2.add(7, board2.get(set22));
			board2.remove(set22);
			set22 = board2.size() - 9;

			if (find9) {
				set23 = rand.nextInt(board2.size() - 9);
				find9 = false;
			}
			batch.begin();
			batch.draw(board2.get(set23), h9x, h9y, 25, 25);
			batch.end();
			board2.add(6, board2.get(set23));
			board2.remove(set23);
			set23 = board2.size() - 10;

			if (find10) {
				set24 = rand.nextInt(board2.size() - 10);
				find10 = false;
			}
			batch.begin();
			batch.draw(board2.get(set24), h10x, h10y, 25, 25);
			batch.end();
			board2.add(5, board2.get(set24));
			board2.remove(set24);
			set24 = board2.size() - 11;

			if (find11) {
				set25 = rand.nextInt(board2.size() - 11);
				find11 = false;
			}
			batch.begin();
			batch.draw(board2.get(set25), h11x, h11y, 25, 25);
			batch.end();
			board2.add(4, board2.get(set25));
			board2.remove(set25);
			set25 = board2.size() - 12;

			if (find12) {
				set26 = rand.nextInt(board2.size() - 12);
				find12 = false;
			}
			batch.begin();
			batch.draw(board2.get(set26), h12x, h12y, 25, 25);
			batch.end();
			board2.add(3, board2.get(set26));
			board2.remove(set26);
			set26 = board2.size() - 13;

			if (find13) {
				set27 = rand.nextInt(board2.size() - 13);
				find13 = false;
			}
			batch.begin();
			batch.draw(board2.get(set27), h13x, h13y, 25, 25);
			batch.end();
			board2.add(2, board2.get(set27));
			board2.remove(set27);
			set27 = board2.size() - 14;

			if (find14) {
				set28 = rand.nextInt(board2.size() - 14);
				find14 = false;
			}
			batch.begin();
			batch.draw(board2.get(set28), h14x, h14y, 25, 25);
			batch.end();
			board2.add(1, board2.get(set28));
			board2.remove(set28);
			set28 = board2.size() - 15;

		}
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}

	public void dispose() {
		batch.dispose();
		startingBoard.dispose();
		atlas.dispose();
		atlas2.dispose();
		stage.dispose();
		font.dispose();
		skin.dispose();
		pixmap.dispose();
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);

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
		if (isMainIslandFull() && !finalizeNumbers.isVisible()) {
			return false;
		}
		outer: for (int i = 0; i < numberImages.size(); i++) {
			if (!numberImages.get(i).isVisible()) {
				for (int j = 0; j < coords.length - 1; j += 2) {
					if (isWithinRange(screenX, Gdx.graphics.getHeight() - 1
							- screenY, coords[j], coords[j + 1])) {
						if (openSpots[j / 2]) {
							HexLocations[j / 2] = i;
							numberImages.get(i).setPosition(coords[j],
									coords[j + 1]);
							numberImages.get(i).setVisible(true);
							openSpots[j / 2] = false;
							multiplexer.addProcessor(stage);
							break outer;
						} else {
							for (int k = 0; k < HexLocations.length; k++) {
								if (HexLocations[k] == i) {
									swap(HexLocations[j / 2], i);
									int temp = HexLocations[k];
									HexLocations[k] = HexLocations[j / 2];
									HexLocations[j / 2] = temp;
									numberImages.get(i).setVisible(true);
									multiplexer.addProcessor(stage);
									break outer;
								}
							}
						}
					}
				}
			}
		}
		if (isMainIslandFull()) {
			finalizeNumbers.setVisible(true);
			field.setVisible(false);
			field2.setVisible(false);
		}
		return false;
	}

	private void swap(int m, int n) {
		float x1 = numberImages.get(m).getX();
		float y1 = numberImages.get(m).getY();
		float x2 = numberImages.get(n).getX();
		float y2 = numberImages.get(n).getY();
		numberImages.get(m).setPosition(x2, y2);
		numberImages.get(n).setPosition(x1, y1);
	}

	private boolean isWithinRange(int screenX, int screenY, int hexX, int hexY) {
		if (((screenX - hexX <= 30 && screenX >= hexX) || (hexX - screenX <= 6 && hexX >= screenX))
				&& ((screenY - hexY <= 30 && screenY >= hexY) || (hexY
						- screenY <= 7 && hexY >= screenY))) {
			return true;
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
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

}
