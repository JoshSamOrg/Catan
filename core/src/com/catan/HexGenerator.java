package com.catan;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

public class HexGenerator implements Screen {
	
	private PlayerOrder orders;
	private ArrayList<TextureRegion> board;
	private TextureRegion wood, ore, sheep, wheat, brick;
	int b, w, s, o, wo = 0;
	private TextureAtlas atlas, atlas2;
	private Texture startingBoard;
	private Random rand;
	private SpriteBatch batch;
	private CatanGame game;
	private int set, set2, set3, set4, set5, set6, set7, set8, set9, set10,
			set11, set12, set13, set14 = 0;
	private boolean counter=false;
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
	private Stage stage;
	private BitmapFont font;
	private Skin skin;
	private Pixmap pixmap;
	private TextButton button;

	public HexGenerator(CatanGame game) {
		this.game = game;
	}

	public void show() {
		orders=new PlayerOrder();
		orders.Orders();
		startingBoard = new Texture(Gdx.files.internal("Scenario5.PNG"));
		batch = new SpriteBatch();
		board = new ArrayList<TextureRegion>();
		rand = new Random();
		atlas = new TextureAtlas(Gdx.files.internal("hexesNoBlack.txt"));
		wood = atlas.findRegion("woodNoBlack");
		wheat = atlas.findRegion("wheatNoBlack");
		ore = atlas.findRegion("oreNoBlack");
		sheep = atlas.findRegion("sheepNoBlack");
		brick = atlas.findRegion("brickNoBlack");
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
		
		stage=new Stage();
		Gdx.input.setInputProcessor(stage);
		font=new BitmapFont(Gdx.files.internal("gameFonts.fnt"));
		skin=new Skin();
		atlas2 = new TextureAtlas(Gdx.files.internal("myTextures.txt"));
		pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("pmap", new Texture(pixmap));
		skin.add("default", font);
		TextureRegion upr=atlas2.findRegion("t5");
		TextButtonStyle textButtonStyle=new TextButtonStyle();
        textButtonStyle.up = new TextureRegionDrawable(upr);
        textButtonStyle.down = skin.newDrawable("pmap", Color.DARK_GRAY); 
        textButtonStyle.checked = skin.newDrawable("pmap", Color.BLUE);
        textButtonStyle.over = skin.newDrawable("pmap", Color.LIGHT_GRAY);
        textButtonStyle.font = font; 
        skin.add("tStyle", textButtonStyle);
        button = new TextButton("Player Order", skin, "tStyle");
        button.setBounds(50, 50, 200, 50);
        stage.addActor(button);
        button.addListener(new ChangeListener(){
        	@Override
			public void changed(ChangeEvent event, Actor actor) {
				counter=true;
				
			}
        });
        }

	public void render(float delta) {
		stage.act(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(startingBoard, 0, 0, 650, 650);
		if (bool) {
			set = rand.nextInt(board.size());
			bool = false;
		}
		batch.draw(board.get(set), -155.8f, 368.4f, 340f, 249.3f);
		board.add(board.get(set));
		board.remove(set);
		set = board.size() - 1;

		if (bool2) {
			set2 = rand.nextInt(board.size() - 1);
			bool2 = false;
		}
		batch.draw(board.get(set2), -108.3f, 368.4f, 340f, 249.3f);
		board.add(13, board.get(set2));
		board.remove(set2);
		set2 = board.size() - 2;

		if (bool3) {
			set3 = rand.nextInt(board.size() - 2);
			bool3 = false;
		}
		batch.draw(board.get(set3), -180.1f, 327.9f, 340f, 249.3f);
		board.add(12, board.get(set3));
		board.remove(set3);
		set3 = board.size() - 3;

		if (bool4) {
			set4 = rand.nextInt(board.size() - 3);
			bool4 = false;
		}
		batch.draw(board.get(set4), -132.6f, 327.9f, 340f, 249.3f);
		board.add(11, board.get(set4));
		board.remove(set4);
		set4 = board.size() - 4;

		if (bool5) {
			set5 = rand.nextInt(board.size() - 4);
			bool5 = false;
		}
		batch.draw(board.get(set5), -204.25f, 287.7f, 340f, 249.3f);
		board.add(10, board.get(set5));
		board.remove(set5);
		set5 = board.size() - 5;

		if (bool6) {
			set6 = rand.nextInt(board.size() - 5);
			bool6 = false;
		}
		batch.draw(board.get(set6), -156.68f, 287.7f, 340f, 249.3f);
		board.add(9, board.get(set6));
		board.remove(set6);
		set6 = board.size() - 6;

		if (bool7) {
			set7 = rand.nextInt(board.size() - 6);
			bool7 = false;
		}
		batch.draw(board.get(set7), -180.6f, 247.4f, 340f, 249.3f);
		board.add(8, board.get(set7));
		board.remove(set7);
		set7 = board.size() - 7;

		if (bool8) {
			set8 = rand.nextInt(board.size() - 7);
			bool8 = false;
		}
		batch.draw(board.get(set8), -133.1f, 247.3f, 340f, 249.3f);
		board.add(7, board.get(set8));
		board.remove(set8);
		set8 = board.size() - 8;

		if (bool9) {
			set9 = rand.nextInt(board.size() - 8);
			bool9 = false;
		}
		batch.draw(board.get(set9), -203.62f, 207.2f, 340f, 249.3f);
		board.add(6, board.get(set9));
		board.remove(set9);
		set9 = board.size() - 9;

		if (bool10) {
			set10 = rand.nextInt(board.size() - 9);
			bool10 = false;
		}
		batch.draw(board.get(set10), -156.25f, 207.2f, 340f, 249.3f);
		board.add(5, board.get(set10));
		board.remove(set10);
		set10 = board.size() - 10;

		if (bool11) {
			set11 = rand.nextInt(board.size() - 10);
			bool11 = false;
		}
		batch.draw(board.get(set11), -180.95f, 167.2f, 340f, 249.3f);
		board.add(4, board.get(set11));
		board.remove(set11);
		set11 = board.size() - 11;

		if (bool12) {
			set12 = rand.nextInt(board.size() - 11);
			bool12 = false;
		}
		batch.draw(board.get(set12), -133.57f, 167.1f, 340f, 249.3f);
		board.add(3, board.get(set12));
		board.remove(set12);
		set12 = board.size() - 12;

		if (bool13) {
			set13 = rand.nextInt(board.size() - 12);
			bool13 = false;
		}
		batch.draw(board.get(set13), -157.1f, 127.4f, 340f, 249.3f);
		board.add(2, board.get(set13));
		board.remove(set13);
		set13 = board.size() - 13;

		if (bool14) {
			set14 = rand.nextInt(board.size() - 13);
			bool14 = false;
		}
		batch.draw(board.get(set14), -109.8f, 127.4f, 340f, 249.3f);
		board.add(1, board.get(set14));
		board.remove(set14);
		set14 = board.size() - 14;
		
		if (counter) {
			button.setVisible(false);
			font.draw(batch, orders.getCounter().get(0).getName() + " " + "is going first", 50, 160);
			font.draw(batch, orders.getCounter().get(1).getName() + " " + "is going second", 50, 120);
			if(orders.getCount()==3) {
				font.draw(batch, orders.getCounter().get(2).getName() + " " + "is going third", 50, 80);	
			}
			if(orders.getCount()==4) {
				font.draw(batch, orders.getCounter().get(2).getName() + " " + "is going third", 50, 80);
				font.draw(batch, orders.getCounter().get(3).getName() + " " + "is going four", 50, 40);	
			}
		}
		batch.end();
		stage.draw();
	}

	public void dispose() {
		batch.dispose();
		startingBoard.dispose();
		atlas.dispose();
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

}
