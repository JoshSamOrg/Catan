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
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//The main game screen class
public class HexGeneratorScreen implements Screen, InputProcessor {

	private CatanPieces cp = new CatanPieces(null);
	private int test = 0;
	private TextButton finalizePosition;
	private static String piece1 = "HarborSettlement";
	private static String piece2 = "Settlement";
	private static int iCopy = 0;
	private static PlayerOrder orders;
	private LoadingScreen load;
	private ArrayList<Image> board, board2;
	private TextureRegion wood, ore, sheep, wheat, brick;
	int b, w, s, o, wo = 0;
	private TextureAtlas atlas, atlas2, atlas3;
	private Texture startingBoard;
	private Random rand;
	private SpriteBatch batch;
	private CatanGame game;
	private int set;
	private boolean counter = false;
	private static Stage stage;
	private BitmapFont font, font2;
	private Skin skin;
	private Pixmap pixmap;
	private TextButton playerOrder;
	private ValidPositions vp = new ValidPositions(null);
	private boolean start = false;
	private int j=0;
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
	private static ArrayList<TextureRegion> numbers;
	private static ArrayList<ImageButton> numberImages;
	private static ArrayList<ImageButton> orange;
	private static ArrayList<ImageButton> white;
	private static ArrayList<ImageButton> blue;
	private static ArrayList<ImageButton> red;
	private static InputMultiplexer multiplexer;
	private static TextButton finalizeNumbers;
	private static TextField field;
	private static TextField field2;

	//Constructor, allows switching screens
	public HexGeneratorScreen(CatanGame game) {
		this.game = game;
	}
	
	//gets the orange arraylist of image buttons
	public ArrayList<ImageButton> getOrange() {
		return orange;
	}
	
	//gets the white arraylist of image buttons
	public ArrayList<ImageButton> getWhite() {
		return white;
	}
	
	//gets the blue arraylist of image buttons
	public ArrayList<ImageButton> getBlue() {
		return blue;
	}
	
	//gets the red arraylist of image buttons
	public ArrayList<ImageButton> getRed() {
		return red;
	}
	
	//sets up all the actors on the stage, and processes all input events
	public void show() {
		CatanPieces.findPositions();
		orange=new ArrayList<ImageButton>();
		white=new ArrayList<ImageButton>();
		blue=new ArrayList<ImageButton>();
		red=new ArrayList<ImageButton>();

		board2 = new ArrayList<Image>();
		load = new LoadingScreen(game);

		orders = new PlayerOrder();
		orders.Orders();
		startingBoard = new Texture(Gdx.files.internal("Scenario5Final.png"));
		batch = new SpriteBatch();
		board = new ArrayList<Image>();
		rand = new Random();
		atlas = new TextureAtlas(Gdx.files.internal("hexesNoBlack2.txt"));
		wood = atlas.findRegion("woodNoBlack2");
		wheat = atlas.findRegion("wheatNoBlack2");
		ore = atlas.findRegion("oreNoBlack2");
		sheep = atlas.findRegion("sheepNoBlack2");
		brick = atlas.findRegion("brickNoBlack2");
		
		for (int i = 0; i < 3; i++) {
			board.add(new Image(sheep));
		}
		for (int i = 0; i < 4; i++) {
			board.add(new Image(wood));
		}
		for (int i = 0; i < 2; i++) {
			board.add(new Image(wheat));
		}
		for (int i = 0; i < 3; i++) {
			board.add(new Image(ore));
		}
		for (int i = 0; i < 2; i++) {
			board.add(new Image(brick));
		}

		atlas3 = new TextureAtlas(Gdx.files.internal("mainIslandNumbers2.txt"));
		multiplexer = new InputMultiplexer();
		stage = new Stage();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(this);
		Gdx.input.setInputProcessor(multiplexer);
		numbers = new ArrayList<TextureRegion>();
		numberImages = new ArrayList<ImageButton>();
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
		playerOrder = new TextButton("Player Order", skin, "tStyle");
		playerOrder.setBounds(50, 50, 200, 50);
		if(LoadingScreen.getPickNumbers()){
		playerOrder.setVisible(false);
		}
		stage.addActor(playerOrder);
		playerOrder.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				counter = true;
				cp.selectPositions(piece1, piece2);
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
				playerOrder.setVisible(true);
				for (int i = 0; i < numberImages.size(); i++) {
					numberImages.get(i).clearListeners();
				}
			}
		});

		TextFieldStyle tfstyle = new TextFieldStyle();
		tfstyle.font = font2;
		tfstyle.fontColor = Color.WHITE;
		skin.add("tfstyle", tfstyle);
		field = new TextField("Click on a number, then move your mouse to the hexagon you",skin, "tfstyle");
		field2 = new TextField("want the number to go inside of and click inside that hexagon",skin, "tfstyle");
		field.setBounds(5, 70, 800, 50);
		field2.setBounds(5, 40, 800, 50);
		if(LoadingScreen.getPickNumbers()){
		stage.addActor(field);
		stage.addActor(field2);
		}

		board2.add(new Image(atlas3.findRegion("3")));
		board2.add(new Image(atlas3.findRegion("4")));
		board2.add(new Image(atlas3.findRegion("5")));
		board2.add(new Image(atlas3.findRegion("5")));
		board2.add(new Image(atlas3.findRegion("8")));
		board2.add(new Image(atlas3.findRegion("9")));
		board2.add(new Image(atlas3.findRegion("10")));
		board2.add(new Image(atlas3.findRegion("11")));
		board2.add(new Image(atlas3.findRegion("12")));
		board2.add(new Image(atlas3.findRegion("3 - Copy")));
		board2.add(new Image(atlas3.findRegion("4 - Copy")));
		board2.add(new Image(atlas3.findRegion("6 - Copy")));
		board2.add(new Image(atlas3.findRegion("8 - Copy")));
		board2.add(new Image(atlas3.findRegion("10 - Copy")));
		board2.add(new Image(atlas3.findRegion("11 - Copy")));
		
		configureHexes();
		//allows you to pick numbers
		if(LoadingScreen.getPickNumbers()){
			drawNumbers();
		}
		else{
		configureNumbers();
	   }
	}
	
	// Randomly places the hexes on the starting board.
	public void configureHexes(){
		float[][] hexes = {{119.25f, 389.8f, 42.4f, 47.53f},
				{162.7f, 389.8f, 41.7f, 47.5f},
				{97.8f, 352.1f, 42f, 47.8f},
				{141.1f, 352f, 42f, 47.8f},
				{76.9f, 315.3f, 41.6f, 46.7f},
				{119.8f, 314.95f, 42f, 47.1f},
				{98.35f, 278.9f, 42f, 46f},
				{142f, 278.85f, 41.3f, 46.35f},
				{76.45f, 241.85f, 41.9f, 46.4f},
				{119.9f, 241.8f, 41.5f, 47.1f},
				{98.4f, 204.5f, 41.7f, 47.4f},
				{141.5f, 204.58f, 41.7f, 47.5f},
				{119.3f, 167f, 42.2f, 47.5f},
				{162.8f, 167.25f, 41.5f, 47.6f}};
	    int size = board.size();
		for (int i=0; i<14; i++) {
			set = rand.nextInt(size);
			board.get(set).setBounds(hexes[i][0], hexes[i][1], hexes[i][2], hexes[i][3]);
			stage.addActor(board.get(set));
			Image img = board.remove(set);
			board.add(img);
			size--;
		}
	}
	// Randomly places the numbers on the starting board.
	public void configureNumbers(){
		float[][] numbers = {{h1x, h1y, 25, 25},
				{h2x, h2y, 25, 25},
				{h3x, h3y, 25, 25},
				{h4x, h4y, 25, 25},
				{h5x, h5y, 25, 25},
				{h6x, h6y, 25, 25},
				{h7x, h7y, 25, 25},
				{h8x, h8y, 25, 25},
				{h9x, h9y, 25, 25},
				{h10x, h10y, 25, 25},
				{h11x, h11y, 25, 25},
				{h12x, h12y, 25, 25},
				{h13x, h13y, 25, 25},
				{h14x, h14y, 25, 25},
				{grassx, grassy, 25, 25}};
		
		if (load.getSetter()) {
	    	int size = board2.size();
			for (int i=0; i<15; i++) {
				set = rand.nextInt(size);
				board2.get(set).setBounds(numbers[i][0], numbers[i][1], numbers[i][2], numbers[i][3]);
				stage.addActor(board2.get(set));
				Image img = board2.remove(set);
				board2.add(img);
				size--;
			}
		}
		}

	//determines if the main island is full of numbers, returning true if it is, and false otherwise
	public boolean isMainIslandFull() {
		for (int i = 0; i < openSpots.length; i++) {
			if (openSpots[i]) {
				return false;
			}
		}
		return true;
	}

	//draws the numbers on the bottom of the screen
	private void drawNumbers() {
		numbers.add(atlas3.findRegion("3"));
		numbers.add(atlas3.findRegion("4"));
		numbers.add(atlas3.findRegion("5"));
		numbers.add(atlas3.findRegion("5"));
		numbers.add(atlas3.findRegion("8"));
		numbers.add(atlas3.findRegion("9"));
		numbers.add(atlas3.findRegion("10"));
		numbers.add(atlas3.findRegion("11"));
		numbers.add(atlas3.findRegion("12"));
		numbers.add(atlas3.findRegion("3 - Copy"));
		numbers.add(atlas3.findRegion("4 - Copy"));
		numbers.add(atlas3.findRegion("6 - Copy"));
		numbers.add(atlas3.findRegion("8 - Copy"));
		numbers.add(atlas3.findRegion("10 - Copy"));
		numbers.add(atlas3.findRegion("11 - Copy"));
		for (int i = 0; i < numbers.size(); i++) {
			numberImages.add(new ImageButton(new TextureRegionDrawable(numbers.get(i))));
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

	//draws the board, and randomly generated numbers
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(startingBoard, 0, 0, 650, 650);
		batch.end();
		
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		//stage.setDebugAll(true);
		if (counter) {
			batch.begin();
			playerOrder.setVisible(false);
			font2.draw(batch, orders.getOrderedPlayers().get(0).getName() + " "+ "is going first", 30, 160);
			batch.end();
			batch.begin();
			font2.draw(batch, orders.getOrderedPlayers().get(1).getName() + " "+ "is going second", 30, 120);
			batch.end();
			if (GamePlayers.getGamePlayers().size() == 3) {
				batch.begin();
				font2.draw(batch, orders.getOrderedPlayers().get(2).getName() + " "+ "is going third", 30, 80);
				batch.end();
			}
			if (GamePlayers.getGamePlayers().size() == 4) {
				batch.begin();
				font2.draw(batch, orders.getOrderedPlayers().get(2).getName() + " "+ "is going third", 30, 80);
				font2.draw(batch, orders.getOrderedPlayers().get(3).getName() + " "+ "is going fourth", 30, 40);
				batch.end();
			}
		}
		if (start) {
			TextButton endTurn = new TextButton("End Turn", skin, "tStyle");
			endTurn.setBounds(300, 20, 250, 50);
			stage.addActor(endTurn);
			batch.begin();
			font2.draw(batch, orders.getOrderedPlayers().get(j).getName() + "'s "
					+ "turn!", 30, 80);
			batch.end();
			endTurn.addListener(new ChangeListener(){
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					actor.setVisible(false);
					j = (j+1) %PlayerColorScreen.getNumberOfPlayers();
				}
			});
			
		}

	}

	//disposes of all resources
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
	//resizes the stage to fit with the new window size
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
	//Allows the user to put numbers on the main island, and place pieces on the main island
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		test++;
			
		//System.out.println(screenX);
		System.out.println(Gdx.graphics.getHeight()-1-screenY);
		System.out.println(vp.getSli().oneAway(213, 321, 237, 321));
		if (CatanPieces.getSelectInitialPlacements())
		if(CatanPieces.getSelectInitialPlacements()){
			cp.findSettlement(screenX, Gdx.graphics.getHeight() - 1 - screenY);
			for(int i = 0; i<CatanPieces.getGamePieces().size(); i++){
				if(!CatanPieces.getGamePieces().get(i).isVisible()){
					iCopy = i;
					if(!piece1.equals("Road") && !piece2.equals("ShipSettler")){
						
						if(vp.valid(CatanPieces.getGamePieces().get(i), 
					CatanPieces.getGamePieces().get(i).getName().substring(CatanPieces.getGamePieces().get(i).getName().indexOf("|") + 1), screenX
					, Gdx.graphics.getHeight() - 1 - screenY
					, CatanPieces.getGamePieces().get(i).getName().substring(0, CatanPieces.getGamePieces().get(i).getName().indexOf("|")))){
					CatanPieces.getGamePieces().get(i).setPosition(CatanPieces.getPositions().get(cp.getSettlementIndexX())-5,
							CatanPieces.getPositions().get(cp.getSettlementIndexY())-7);
					CatanPieces.getGamePieces().get(i).setVisible(true);
					}
					}
					else{
						if(!vp.valid(CatanPieces.getGamePieces().get(i), 
								CatanPieces.getGamePieces().get(i).getName().substring(CatanPieces.getGamePieces().get(i).getName().indexOf("|") + 1), screenX
								, Gdx.graphics.getHeight() - 1 - screenY
								, CatanPieces.getGamePieces().get(i).getName().substring(0, CatanPieces.getGamePieces().get(i).getName().indexOf("|")))){
							return false;
						}
						cp.findRoad(screenX, Gdx.graphics.getHeight() - 1 - screenY);
						cp.midpoint(CatanPieces.getPositions().get(cp.getFirstX()), 
								CatanPieces.getPositions().get(cp.getFirstY()), 
								CatanPieces.getPositions().get(cp.getSecondX()), 
								CatanPieces.getPositions().get(cp.getSecondY()));
						int distance = 0;
						int y = 15;
						if(cp.getRoadRotation() != 90){
							distance = CatanPieces.distance(CatanPieces.getPositions().get(cp.getFirstX()), 
									CatanPieces.getPositions().get(cp.getFirstY()), 
									CatanPieces.getPositions().get(cp.getSecondX()), 
									CatanPieces.getPositions().get(cp.getSecondY()),10,0);
						}
						else{
							distance = CatanPieces.distance(CatanPieces.getPositions().get(cp.getFirstX()), 
									CatanPieces.getPositions().get(cp.getFirstY()), 
									CatanPieces.getPositions().get(cp.getSecondX()), 
									CatanPieces.getPositions().get(cp.getSecondY()),0,0);
						}
						CatanPieces.getGamePieces().get(i).setBounds(cp.getmpX() - distance/2, 
								cp.getmpY() - y/2, distance, y);
						CatanPieces.getGamePieces().get(i).setOrigin(distance/2, y/2);
						CatanPieces.getGamePieces().get(i).setTransform(true);
						CatanPieces.getGamePieces().get(i).setRotation(cp.getRoadRotation());
						if(cp.getRoadRotation() == 90){
						CatanPieces.getGamePieces().get(i).setScaleY(.5f);
						CatanPieces.getGamePieces().get(i).setScaleX(.74f);
						CatanPieces.getGamePieces().get(i).setX(CatanPieces.getGamePieces().get(i).getX() + .5f);
						CatanPieces.getGamePieces().get(i).setY(CatanPieces.getGamePieces().get(i).getY() + .5f);
						}
						else{
							CatanPieces.getGamePieces().get(i).setScaleY(.95f);
							CatanPieces.getGamePieces().get(i).setScaleX(.95f);
						}
						CatanPieces.getGamePieces().get(i).setVisible(true);
					}
					if(finalizePosition == null){
					skin.get("tStyle", TextButtonStyle.class).checked = null;//don't want the check to be blue 
					finalizePosition = new TextButton("Finalize Position", skin, "tStyle");
					finalizePosition.setBounds(300, 20, 250, 50);
					stage.addActor(finalizePosition);
					finalizePosition.addListener(new ChangeListener(){
						@Override
						public void changed(ChangeEvent event, Actor actor) {
							String name = CatanPieces.getGamePieces().get(iCopy).getName();
							String type = name.substring(CatanPieces.getGamePieces().get(iCopy).getName().indexOf("|") + 1);
							if (type.equals("harborsettlement1")) {
								SettlementLocationIndices.getHarborSettlementLocations()[ValidPositions.getCounter()] = true;
								SettlementLocationIndices.getSettlementColors()[ValidPositions.getCounter()] = ValidPositions.getColors();
							}
							else if (type.equals("settlement")) {
								SettlementLocationIndices.getSettlementLocations()[ValidPositions.getCounter()] = true;
								SettlementLocationIndices.getSettlementColors()[ValidPositions.getCounter()] = ValidPositions.getColors();
							}
							else if (type.equals("road1")) {
								SettlementLocationIndices.getRoadShip()[ValidPositions.getCounter()] = 1;
								SettlementLocationIndices.getRoadColors()[ValidPositions.getCounter()] = ValidPositions.getColors();
							}
							else if (type.equals("shipsettler")) {
								SettlementLocationIndices.getRoadColors()[ValidPositions.getCounter()] = ValidPositions.getColors();
								if (SettlementLocationIndices.getRoadShip()[ValidPositions.getCounter()] == 0) {
									SettlementLocationIndices.getRoadShip()[ValidPositions.getCounter()] = 2;	
								}
								else {
								SettlementLocationIndices.getRoadShip()[ValidPositions.getCounter()]++;
								}
							}
							CatanPieces.getGamePieces().get(iCopy).clearListeners();
							//If there are two players, they need to each place a harbor settlement and a settlement
							if(iCopy == CatanPieces.getGamePieces().size() - 1 && piece1.equals("Road")
									&& piece2.equals("ShipSettler") && PlayerColorScreen.getNumberOfPlayers() == 2){
								piece1 = "";
								piece2 = "";
								counter = false;
								cp.neutralPlacements();
							}
							else if(iCopy != CatanPieces.getGamePieces().size() - 1){
								CatanPieces.addGamePiecesListener(iCopy+1);
							}
							else if(piece1.equals("HarborSettlement") && piece2.equals("Settlement")){
								piece1 = "Road";
								piece2 = "ShipSettler";
								cp.selectPositions(piece1, piece2);
							}
							else if(iCopy == CatanPieces.getGamePieces().size() - 1){
								counter = false;//don't draw the text on the screen anymore
								actor.setVisible(false);//set the finalize position button so you can't see it
								makeStartButton();
							}
						}

						private void makeStartButton() {
						TextButton startButton = new TextButton("Start Game", skin, "tStyle");
						startButton.setBounds(300, 20, 250, 50);
						stage.addActor(startButton);
						startButton.addListener(new ChangeListener(){
							@Override
							public void changed(ChangeEvent event, Actor actor) {
								start = true;
								CatanPieces.setSelectInitialPlacements(false);
							}
						});
						
						}
					});
					}
					break;
				}
			}
			return false;
		}
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
							multiplexer.addProcessor(0, stage);//stage has to be the first processor in the multiplexer!
							break outer;
						} else {
							for (int k = 0; k < HexLocations.length; k++) {
								if (HexLocations[k] == i) {
									swap(HexLocations[j / 2], i);
									int temp = HexLocations[k];
									HexLocations[k] = HexLocations[j / 2];
									HexLocations[j / 2] = temp;
									numberImages.get(i).setVisible(true);
									multiplexer.addProcessor(0, stage);//stage has to be the first processor in the multiplexer!
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

	//swaps two numbers on the main island
	private void swap(int m, int n) {
		float x1 = numberImages.get(m).getX();
		float y1 = numberImages.get(m).getY();
		float x2 = numberImages.get(n).getX();
		float y2 = numberImages.get(n).getY();
		numberImages.get(m).setPosition(x2, y2);
		numberImages.get(n).setPosition(x1, y1);
	}

	//determines if the mouse click is within a hexagon on the main island, true if it is, and
	//false otherwise
	private boolean isWithinRange(int screenX, int screenY, int hexX, int hexY) {
		if (((screenX - hexX <= 30 && screenX >= hexX) || (hexX - screenX <= 6 && hexX >= screenX))
				&& ((screenY - hexY <= 30 && screenY >= hexY) || (hexY
						- screenY <= 7 && hexY >= screenY))) {
			return true;
		}
		return false;
	}
	
	//returns the stage for this class
	public static Stage getStage() {
		return stage;
	}
	
	//returns the orders object for this class
	public PlayerOrder getOrders() {
		return orders;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
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
