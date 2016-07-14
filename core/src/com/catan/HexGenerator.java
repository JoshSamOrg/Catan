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
	private BitmapFont font,font2;
	private Skin skin;
	private Pixmap pixmap;
	private TextButton button;

	public HexGenerator(CatanGame game) {
		this.game = game;
	}

	public void show() {
		orders=new PlayerOrder();
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
		
		stage=new Stage();
		Gdx.input.setInputProcessor(stage);
		font=new BitmapFont(Gdx.files.internal("gameFonts.fnt"));
		font2=new BitmapFont(Gdx.files.internal("gameFonts.fnt"));
		font2.getData().setScale(.7f, .7f);
		skin=new Skin();
		atlas2 = new TextureAtlas(Gdx.files.internal("myTextures.txt"));
		pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("pmap", new Texture(pixmap));
		skin.add("default", font);
		skin.add("default2", font2);
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
			font2.draw(batch, orders.getCounter().get(0).getName() + " " + "is going first", 5, 160);
			batch.end();
			batch.begin();
			font2.draw(batch, orders.getCounter().get(1).getName() + " " + "is going second", 5, 120);
			batch.end();
			if(orders.getCount()==3) {
				batch.begin();
				font2.draw(batch, orders.getCounter().get(2).getName() + " " + "is going third", 5, 80);
				batch.end();
			}
			if(orders.getCount()==4) {
				batch.begin();
				font2.draw(batch, orders.getCounter().get(2).getName() + " " + "is going third", 5, 80);
				font2.draw(batch, orders.getCounter().get(3).getName() + " " + "is going fourth", 5, 40);
				batch.end();
			}
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
