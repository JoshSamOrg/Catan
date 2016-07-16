package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class CatanPieces implements Screen, InputProcessor {
    private SpriteBatch batch;
    private Stage stage;
    private ArrayList<Integer> settlementPositionsMainIsland;
    private ArrayList<Integer> harborSettlementPositionsMainIsland;
    private ArrayList<Integer> settlementPositionsGreenIsland;
    private ArrayList<Integer> harborSettlementPositionsGreenIsland;
    private ArrayList<Integer> settlementPositionsOrangeIsland;
    private ArrayList<Integer> harborSettlementPositionsOrangeIsland;
    private Texture texture;
    private TextureAtlas atlas;
    private InputMultiplexer multiplexer;
	private CatanGame game;
	private ImageButton settlement;
	
	public CatanPieces(CatanGame game){
		this.game = game;
	}
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		stage = new Stage();
		settlementPositionsMainIsland = new ArrayList<Integer>();
		findSettlementPositionsMainIsland();
		harborSettlementPositionsMainIsland = new ArrayList<Integer>();
		findHarborSettlementPositionsMainIsland();
		settlementPositionsGreenIsland = new ArrayList<Integer>();
		findSettlementPositionsGreenIsland();
		harborSettlementPositionsGreenIsland = new ArrayList<Integer>();
		findHarborSettlementPositionsGreenIsland();
		settlementPositionsOrangeIsland = new ArrayList<Integer>();
		findSettlementPositionsOrangeIsland();
		harborSettlementPositionsOrangeIsland = new ArrayList<Integer>();
		findHarborSettlementPositionsOrangeIsland();
		texture = new Texture(Gdx.files.internal("Scenario5Final.png"));
		atlas = new TextureAtlas(Gdx.files.internal("Red.txt"));
		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(this);
		Gdx.input.setInputProcessor(multiplexer);
		TextureRegion reg = atlas.findRegion("redRoad");
		settlement = new ImageButton(new TextureRegionDrawable(reg));
		settlement.setBounds(10, 10, 15, 20);
		stage.addActor(settlement);
		settlement.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				settlement.setVisible(false);
			}
		});
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(texture, 0, 0, 650, 650);
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime()); //updates all the actors in the stage.
		//Delta is the time in seconds between the last frame
        stage.draw(); //draws all the actors in the stage
        //stage.setDebugAll(true); sets debug lines for everything
		
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
		settlement.setPosition(screenX - (settlement.getWidth()/2), Gdx.graphics.getHeight() - 1 - screenY - (settlement.getHeight()/2));
		settlement.setVisible(true);
		System.out.println(screenX);
		System.out.println(Gdx.graphics.getHeight()-1 - screenY);
//		Gdx.app.setLogLevel(Application.LOG_DEBUG);
//		Gdx.app.log("X", screenX + "");
//		Gdx.app.log("Y", Gdx.graphics.getHeight()-1 - screenY + "");
		return false;
	}
	
	public ArrayList<Integer> getSettlementPositionsOrangeIsland(){
		return settlementPositionsOrangeIsland;
	}
	
	public ArrayList<Integer> getHarborSettlementPositionsOrangeIsland(){
		return harborSettlementPositionsOrangeIsland;
	}
	
	public ArrayList<Integer> getHarborSettlementPositionsGreenIsland(){
		return harborSettlementPositionsGreenIsland;
	}
	
	public ArrayList<Integer> getSettlementPositionsGreenIsland(){
		return settlementPositionsGreenIsland;
	}
	
	public ArrayList<Integer> getHarborSettlementPositionsMainIsland(){
		return harborSettlementPositionsMainIsland;
	}
	
	public ArrayList<Integer> getSettlementPositionsMainIsland(){
		return settlementPositionsMainIsland;
	}
	
	public void findSettlementPositionsOrangeIsland(){
		settlementPositionsOrangeIsland.add(268);//1
		settlementPositionsOrangeIsland.add(290);
		settlementPositionsOrangeIsland.add(248);//2
		settlementPositionsOrangeIsland.add(280);
		settlementPositionsOrangeIsland.add(248);//3
		settlementPositionsOrangeIsland.add(254);
		settlementPositionsOrangeIsland.add(268);//4
		settlementPositionsOrangeIsland.add(243);
		settlementPositionsOrangeIsland.add(269);//5
		settlementPositionsOrangeIsland.add(215);
		settlementPositionsOrangeIsland.add(290);//6
		settlementPositionsOrangeIsland.add(205);
		settlementPositionsOrangeIsland.add(290);//7
		settlementPositionsOrangeIsland.add(180);
		settlementPositionsOrangeIsland.add(311);//8
		settlementPositionsOrangeIsland.add(170);
		settlementPositionsOrangeIsland.add(333);//9
		settlementPositionsOrangeIsland.add(180);
		settlementPositionsOrangeIsland.add(354);//10
		settlementPositionsOrangeIsland.add(172);
		settlementPositionsOrangeIsland.add(375);//11
		settlementPositionsOrangeIsland.add(181);
		settlementPositionsOrangeIsland.add(397);//12
		settlementPositionsOrangeIsland.add(171);
		settlementPositionsOrangeIsland.add(419);//13
		settlementPositionsOrangeIsland.add(178);
		settlementPositionsOrangeIsland.add(439);//14
		settlementPositionsOrangeIsland.add(170);
		settlementPositionsOrangeIsland.add(461);//15
		settlementPositionsOrangeIsland.add(180);
		settlementPositionsOrangeIsland.add(482);//16
		settlementPositionsOrangeIsland.add(172);
		settlementPositionsOrangeIsland.add(503);//17
		settlementPositionsOrangeIsland.add(182);
		settlementPositionsOrangeIsland.add(504);//18
		settlementPositionsOrangeIsland.add(208);
		settlementPositionsOrangeIsland.add(524);//19
		settlementPositionsOrangeIsland.add(218);
		settlementPositionsOrangeIsland.add(526);//20
		settlementPositionsOrangeIsland.add(242);
		settlementPositionsOrangeIsland.add(545);//21
		settlementPositionsOrangeIsland.add(255);
		settlementPositionsOrangeIsland.add(547);//22
		settlementPositionsOrangeIsland.add(281);
		settlementPositionsOrangeIsland.add(525);//23
		settlementPositionsOrangeIsland.add(289);
		settlementPositionsOrangeIsland.add(503);//24
		settlementPositionsOrangeIsland.add(279);
		settlementPositionsOrangeIsland.add(482);//25
		settlementPositionsOrangeIsland.add(291);
		settlementPositionsOrangeIsland.add(461);//26
		settlementPositionsOrangeIsland.add(282);
		settlementPositionsOrangeIsland.add(461);//27
		settlementPositionsOrangeIsland.add(255);
		settlementPositionsOrangeIsland.add(440);//28
		settlementPositionsOrangeIsland.add(244);
		settlementPositionsOrangeIsland.add(418);//29
		settlementPositionsOrangeIsland.add(255);
		settlementPositionsOrangeIsland.add(418);//30
		settlementPositionsOrangeIsland.add(281);
		settlementPositionsOrangeIsland.add(397);//31
		settlementPositionsOrangeIsland.add(290);
		settlementPositionsOrangeIsland.add(375);//32
		settlementPositionsOrangeIsland.add(280);
		settlementPositionsOrangeIsland.add(376);//33
		settlementPositionsOrangeIsland.add(255);
		settlementPositionsOrangeIsland.add(355);//34
		settlementPositionsOrangeIsland.add(243);
		settlementPositionsOrangeIsland.add(333);//35
		settlementPositionsOrangeIsland.add(255);
		settlementPositionsOrangeIsland.add(333);//36
		settlementPositionsOrangeIsland.add(279);
		settlementPositionsOrangeIsland.add(311);//37
		settlementPositionsOrangeIsland.add(291);
		settlementPositionsOrangeIsland.add(290);//38
		settlementPositionsOrangeIsland.add(280);
		settlementPositionsOrangeIsland.add(289);//39
		settlementPositionsOrangeIsland.add(255);
		settlementPositionsOrangeIsland.add(311);//40
		settlementPositionsOrangeIsland.add(244);
		settlementPositionsOrangeIsland.add(398);//41
		settlementPositionsOrangeIsland.add(244);
		settlementPositionsOrangeIsland.add(482);//42
		settlementPositionsOrangeIsland.add(243);
		settlementPositionsOrangeIsland.add(504);//43
		settlementPositionsOrangeIsland.add(254);
		settlementPositionsOrangeIsland.add(483);//44
		settlementPositionsOrangeIsland.add(218);
		settlementPositionsOrangeIsland.add(462);//45
		settlementPositionsOrangeIsland.add(206);
		settlementPositionsOrangeIsland.add(439);//46
		settlementPositionsOrangeIsland.add(218);
		settlementPositionsOrangeIsland.add(418);//47
		settlementPositionsOrangeIsland.add(206);
		settlementPositionsOrangeIsland.add(398);//48
		settlementPositionsOrangeIsland.add(216);
		settlementPositionsOrangeIsland.add(376);//49
		settlementPositionsOrangeIsland.add(207);
		settlementPositionsOrangeIsland.add(354);//50
		settlementPositionsOrangeIsland.add(217);
		settlementPositionsOrangeIsland.add(333);//51
		settlementPositionsOrangeIsland.add(207);
		settlementPositionsOrangeIsland.add(311);//52
		settlementPositionsOrangeIsland.add(216);
	}
	
	public void findHarborSettlementPositionsOrangeIsland(){
		harborSettlementPositionsOrangeIsland.add(268);//1
		harborSettlementPositionsOrangeIsland.add(290);
		harborSettlementPositionsOrangeIsland.add(248);//2
		harborSettlementPositionsOrangeIsland.add(280);
		harborSettlementPositionsOrangeIsland.add(248);//3
		harborSettlementPositionsOrangeIsland.add(254);
		harborSettlementPositionsOrangeIsland.add(268);//4
		harborSettlementPositionsOrangeIsland.add(243);
		harborSettlementPositionsOrangeIsland.add(269);//5
		harborSettlementPositionsOrangeIsland.add(215);
		harborSettlementPositionsOrangeIsland.add(290);//6
		harborSettlementPositionsOrangeIsland.add(205);
		harborSettlementPositionsOrangeIsland.add(290);//7
		harborSettlementPositionsOrangeIsland.add(180);
		harborSettlementPositionsOrangeIsland.add(311);//8
		harborSettlementPositionsOrangeIsland.add(170);
		harborSettlementPositionsOrangeIsland.add(333);//9
		harborSettlementPositionsOrangeIsland.add(180);
		harborSettlementPositionsOrangeIsland.add(354);//10
		harborSettlementPositionsOrangeIsland.add(172);
		harborSettlementPositionsOrangeIsland.add(375);//11
		harborSettlementPositionsOrangeIsland.add(181);
		harborSettlementPositionsOrangeIsland.add(397);//12
		harborSettlementPositionsOrangeIsland.add(171);
		harborSettlementPositionsOrangeIsland.add(419);//13
		harborSettlementPositionsOrangeIsland.add(178);
		harborSettlementPositionsOrangeIsland.add(439);//14
		harborSettlementPositionsOrangeIsland.add(170);
		harborSettlementPositionsOrangeIsland.add(461);//15
		harborSettlementPositionsOrangeIsland.add(180);
		harborSettlementPositionsOrangeIsland.add(482);//16
		harborSettlementPositionsOrangeIsland.add(172);
		harborSettlementPositionsOrangeIsland.add(503);//17
		harborSettlementPositionsOrangeIsland.add(182);
		harborSettlementPositionsOrangeIsland.add(504);//18
		harborSettlementPositionsOrangeIsland.add(208);
		harborSettlementPositionsOrangeIsland.add(524);//19
		harborSettlementPositionsOrangeIsland.add(218);
		harborSettlementPositionsOrangeIsland.add(526);//20
		harborSettlementPositionsOrangeIsland.add(242);
		harborSettlementPositionsOrangeIsland.add(545);//21
		harborSettlementPositionsOrangeIsland.add(255);
		harborSettlementPositionsOrangeIsland.add(547);//22
		harborSettlementPositionsOrangeIsland.add(281);
		harborSettlementPositionsOrangeIsland.add(525);//23
		harborSettlementPositionsOrangeIsland.add(289);
		harborSettlementPositionsOrangeIsland.add(503);//24
		harborSettlementPositionsOrangeIsland.add(279);
		harborSettlementPositionsOrangeIsland.add(482);//25
		harborSettlementPositionsOrangeIsland.add(291);
		harborSettlementPositionsOrangeIsland.add(461);//26
		harborSettlementPositionsOrangeIsland.add(282);
		harborSettlementPositionsOrangeIsland.add(461);//27
		harborSettlementPositionsOrangeIsland.add(255);
		harborSettlementPositionsOrangeIsland.add(440);//28
		harborSettlementPositionsOrangeIsland.add(244);
		harborSettlementPositionsOrangeIsland.add(418);//29
		harborSettlementPositionsOrangeIsland.add(255);
		harborSettlementPositionsOrangeIsland.add(418);//30
		harborSettlementPositionsOrangeIsland.add(281);
		harborSettlementPositionsOrangeIsland.add(397);//31
		harborSettlementPositionsOrangeIsland.add(290);
		harborSettlementPositionsOrangeIsland.add(375);//32
		harborSettlementPositionsOrangeIsland.add(280);
		harborSettlementPositionsOrangeIsland.add(376);//33
		harborSettlementPositionsOrangeIsland.add(255);
		harborSettlementPositionsOrangeIsland.add(355);//34
		harborSettlementPositionsOrangeIsland.add(243);
		harborSettlementPositionsOrangeIsland.add(333);//35
		harborSettlementPositionsOrangeIsland.add(255);
		harborSettlementPositionsOrangeIsland.add(333);//36
		harborSettlementPositionsOrangeIsland.add(279);
		harborSettlementPositionsOrangeIsland.add(311);//37
		harborSettlementPositionsOrangeIsland.add(291);
		harborSettlementPositionsOrangeIsland.add(290);//38
		harborSettlementPositionsOrangeIsland.add(280);
	}
	
	public void findSettlementPositionsGreenIsland(){
		settlementPositionsGreenIsland.add(291);//1
		settlementPositionsGreenIsland.add(427);
		settlementPositionsGreenIsland.add(291);//2
		settlementPositionsGreenIsland.add(400);
		settlementPositionsGreenIsland.add(269);//3
		settlementPositionsGreenIsland.add(391);
		settlementPositionsGreenIsland.add(270);//4
		settlementPositionsGreenIsland.add(363);
		settlementPositionsGreenIsland.add(248);//5
		settlementPositionsGreenIsland.add(352);
		settlementPositionsGreenIsland.add(248);//6
		settlementPositionsGreenIsland.add(327);
		settlementPositionsGreenIsland.add(269);//7
		settlementPositionsGreenIsland.add(317);
		settlementPositionsGreenIsland.add(290);//8
		settlementPositionsGreenIsland.add(328);
		settlementPositionsGreenIsland.add(311);//9
		settlementPositionsGreenIsland.add(316);
		settlementPositionsGreenIsland.add(333);//10
		settlementPositionsGreenIsland.add(327);
		settlementPositionsGreenIsland.add(332);//11
		settlementPositionsGreenIsland.add(354);
		settlementPositionsGreenIsland.add(355);//12
		settlementPositionsGreenIsland.add(364);
		settlementPositionsGreenIsland.add(376);//13
		settlementPositionsGreenIsland.add(354);
		settlementPositionsGreenIsland.add(376);//14
		settlementPositionsGreenIsland.add(327);
		settlementPositionsGreenIsland.add(398);//15
		settlementPositionsGreenIsland.add(317);
		settlementPositionsGreenIsland.add(418);//16
		settlementPositionsGreenIsland.add(328);
		settlementPositionsGreenIsland.add(419);//17
		settlementPositionsGreenIsland.add(353);
		settlementPositionsGreenIsland.add(440);//18
		settlementPositionsGreenIsland.add(364);
		settlementPositionsGreenIsland.add(462);//19
		settlementPositionsGreenIsland.add(353);
		settlementPositionsGreenIsland.add(461);//20
		settlementPositionsGreenIsland.add(328);
		settlementPositionsGreenIsland.add(483);//21
		settlementPositionsGreenIsland.add(318);
		settlementPositionsGreenIsland.add(504);//22
		settlementPositionsGreenIsland.add(328);
		settlementPositionsGreenIsland.add(525);//23
		settlementPositionsGreenIsland.add(317);
		settlementPositionsGreenIsland.add(546);//24
		settlementPositionsGreenIsland.add(329);
		settlementPositionsGreenIsland.add(547);//25
		settlementPositionsGreenIsland.add(352);
		settlementPositionsGreenIsland.add(525);//26
		settlementPositionsGreenIsland.add(365);
		settlementPositionsGreenIsland.add(525);//27
		settlementPositionsGreenIsland.add(389);
		settlementPositionsGreenIsland.add(503);//28
		settlementPositionsGreenIsland.add(401);
		settlementPositionsGreenIsland.add(503);//29
		settlementPositionsGreenIsland.add(426);
		settlementPositionsGreenIsland.add(482);//30
		settlementPositionsGreenIsland.add(438);
		settlementPositionsGreenIsland.add(461);//31
		settlementPositionsGreenIsland.add(428);
		settlementPositionsGreenIsland.add(440);//32
		settlementPositionsGreenIsland.add(438);
		settlementPositionsGreenIsland.add(419);//33
		settlementPositionsGreenIsland.add(427);
		settlementPositionsGreenIsland.add(395);//34
		settlementPositionsGreenIsland.add(438);
		settlementPositionsGreenIsland.add(375);//35
		settlementPositionsGreenIsland.add(428);
		settlementPositionsGreenIsland.add(354);//36
		settlementPositionsGreenIsland.add(439);
		settlementPositionsGreenIsland.add(332);//37
		settlementPositionsGreenIsland.add(428);
		settlementPositionsGreenIsland.add(311);//38
		settlementPositionsGreenIsland.add(437);
		settlementPositionsGreenIsland.add(312);//39
		settlementPositionsGreenIsland.add(390);
		settlementPositionsGreenIsland.add(332);//40
		settlementPositionsGreenIsland.add(401);
		settlementPositionsGreenIsland.add(355);//41
		settlementPositionsGreenIsland.add(390);
		settlementPositionsGreenIsland.add(375);//42
		settlementPositionsGreenIsland.add(402);
		settlementPositionsGreenIsland.add(397);//43
		settlementPositionsGreenIsland.add(391);
		settlementPositionsGreenIsland.add(418);//44
		settlementPositionsGreenIsland.add(402);
		settlementPositionsGreenIsland.add(441);//45
		settlementPositionsGreenIsland.add(390);
		settlementPositionsGreenIsland.add(461);//46
		settlementPositionsGreenIsland.add(402);
		settlementPositionsGreenIsland.add(483);//47
		settlementPositionsGreenIsland.add(389);
		settlementPositionsGreenIsland.add(291);//48
		settlementPositionsGreenIsland.add(355);
		settlementPositionsGreenIsland.add(312);//49
		settlementPositionsGreenIsland.add(363);
		settlementPositionsGreenIsland.add(397);//50
		settlementPositionsGreenIsland.add(364);
		settlementPositionsGreenIsland.add(483);//51
		settlementPositionsGreenIsland.add(363);
		settlementPositionsGreenIsland.add(504);//52
		settlementPositionsGreenIsland.add(353);
		
	}
	
	public void findHarborSettlementPositionsGreenIsland(){
		harborSettlementPositionsGreenIsland.add(291);//1
		harborSettlementPositionsGreenIsland.add(427);
		harborSettlementPositionsGreenIsland.add(291);//2
		harborSettlementPositionsGreenIsland.add(400);
		harborSettlementPositionsGreenIsland.add(269);//3
		harborSettlementPositionsGreenIsland.add(391);
		harborSettlementPositionsGreenIsland.add(270);//4
		harborSettlementPositionsGreenIsland.add(363);
		harborSettlementPositionsGreenIsland.add(248);//5
		harborSettlementPositionsGreenIsland.add(352);
		harborSettlementPositionsGreenIsland.add(248);//6
		harborSettlementPositionsGreenIsland.add(327);
		harborSettlementPositionsGreenIsland.add(269);//7
		harborSettlementPositionsGreenIsland.add(317);
		harborSettlementPositionsGreenIsland.add(290);//8
		harborSettlementPositionsGreenIsland.add(328);
		harborSettlementPositionsGreenIsland.add(311);//9
		harborSettlementPositionsGreenIsland.add(316);
		harborSettlementPositionsGreenIsland.add(333);//10
		harborSettlementPositionsGreenIsland.add(327);
		harborSettlementPositionsGreenIsland.add(332);//11
		harborSettlementPositionsGreenIsland.add(354);
		harborSettlementPositionsGreenIsland.add(355);//12
		harborSettlementPositionsGreenIsland.add(364);
		harborSettlementPositionsGreenIsland.add(376);//13
		harborSettlementPositionsGreenIsland.add(354);
		harborSettlementPositionsGreenIsland.add(376);//14
		harborSettlementPositionsGreenIsland.add(327);
		harborSettlementPositionsGreenIsland.add(398);//15
		harborSettlementPositionsGreenIsland.add(317);
		harborSettlementPositionsGreenIsland.add(418);//16
		harborSettlementPositionsGreenIsland.add(328);
		harborSettlementPositionsGreenIsland.add(419);//17
		harborSettlementPositionsGreenIsland.add(353);
		harborSettlementPositionsGreenIsland.add(440);//18
		harborSettlementPositionsGreenIsland.add(364);
		harborSettlementPositionsGreenIsland.add(462);//19
		harborSettlementPositionsGreenIsland.add(353);
		harborSettlementPositionsGreenIsland.add(461);//20
		harborSettlementPositionsGreenIsland.add(328);
		harborSettlementPositionsGreenIsland.add(483);//21
		harborSettlementPositionsGreenIsland.add(318);
		harborSettlementPositionsGreenIsland.add(504);//22
		harborSettlementPositionsGreenIsland.add(328);
		harborSettlementPositionsGreenIsland.add(525);//23
		harborSettlementPositionsGreenIsland.add(317);
		harborSettlementPositionsGreenIsland.add(546);//24
		harborSettlementPositionsGreenIsland.add(329);
		harborSettlementPositionsGreenIsland.add(547);//25
		harborSettlementPositionsGreenIsland.add(352);
		harborSettlementPositionsGreenIsland.add(525);//26
		harborSettlementPositionsGreenIsland.add(365);
		harborSettlementPositionsGreenIsland.add(525);//27
		harborSettlementPositionsGreenIsland.add(389);
		harborSettlementPositionsGreenIsland.add(503);//28
		harborSettlementPositionsGreenIsland.add(401);
		harborSettlementPositionsGreenIsland.add(503);//29
		harborSettlementPositionsGreenIsland.add(426);
		harborSettlementPositionsGreenIsland.add(482);//30
		harborSettlementPositionsGreenIsland.add(438);
		harborSettlementPositionsGreenIsland.add(461);//31
		harborSettlementPositionsGreenIsland.add(428);
		harborSettlementPositionsGreenIsland.add(440);//32
		harborSettlementPositionsGreenIsland.add(438);
		harborSettlementPositionsGreenIsland.add(419);//33
		harborSettlementPositionsGreenIsland.add(427);
		harborSettlementPositionsGreenIsland.add(395);//34
		harborSettlementPositionsGreenIsland.add(438);
		harborSettlementPositionsGreenIsland.add(375);//35
		harborSettlementPositionsGreenIsland.add(428);
		harborSettlementPositionsGreenIsland.add(354);//36
		harborSettlementPositionsGreenIsland.add(439);
		harborSettlementPositionsGreenIsland.add(332);//37
		harborSettlementPositionsGreenIsland.add(428);
		harborSettlementPositionsGreenIsland.add(311);//38
		harborSettlementPositionsGreenIsland.add(437);
	}
	
	public void findHarborSettlementPositionsMainIsland(){
		harborSettlementPositionsMainIsland.add(204);//1
		harborSettlementPositionsMainIsland.add(425);
		harborSettlementPositionsMainIsland.add(205);//2
		harborSettlementPositionsMainIsland.add(399);
		harborSettlementPositionsMainIsland.add(184);//3
		harborSettlementPositionsMainIsland.add(391);
		harborSettlementPositionsMainIsland.add(183);//4
		harborSettlementPositionsMainIsland.add(364);
		harborSettlementPositionsMainIsland.add(163);//5
		harborSettlementPositionsMainIsland.add(352);
		harborSettlementPositionsMainIsland.add(163);//6
		harborSettlementPositionsMainIsland.add(326);
		harborSettlementPositionsMainIsland.add(183);//7
		harborSettlementPositionsMainIsland.add(316);
		harborSettlementPositionsMainIsland.add(183);//8
		harborSettlementPositionsMainIsland.add(290);
		harborSettlementPositionsMainIsland.add(162);//9
		harborSettlementPositionsMainIsland.add(280);
		harborSettlementPositionsMainIsland.add(161);//10
		harborSettlementPositionsMainIsland.add(252);
		harborSettlementPositionsMainIsland.add(184);//11
		harborSettlementPositionsMainIsland.add(244);
		harborSettlementPositionsMainIsland.add(184);//12
		harborSettlementPositionsMainIsland.add(214);
		harborSettlementPositionsMainIsland.add(205);///13
		harborSettlementPositionsMainIsland.add(205);
		harborSettlementPositionsMainIsland.add(205);//14
		harborSettlementPositionsMainIsland.add(179);
	}
	
	public void findSettlementPositionsMainIsland(){
		settlementPositionsMainIsland.add(140);//1
		settlementPositionsMainIsland.add(438);
		settlementPositionsMainIsland.add(162);//2
		settlementPositionsMainIsland.add(428);
		settlementPositionsMainIsland.add(161);//3
		settlementPositionsMainIsland.add(399);
		settlementPositionsMainIsland.add(140);//4
		settlementPositionsMainIsland.add(389);
		settlementPositionsMainIsland.add(119);//5
		settlementPositionsMainIsland.add(400);
		settlementPositionsMainIsland.add(184);//6
		settlementPositionsMainIsland.add(437);
		settlementPositionsMainIsland.add(204);//7
		settlementPositionsMainIsland.add(425);
		settlementPositionsMainIsland.add(184);//8
		settlementPositionsMainIsland.add(391);
		settlementPositionsMainIsland.add(119);//9
		settlementPositionsMainIsland.add(425);
		settlementPositionsMainIsland.add(98);//10
		settlementPositionsMainIsland.add(390);
		settlementPositionsMainIsland.add(98);//11
		settlementPositionsMainIsland.add(361);
		settlementPositionsMainIsland.add(120);//12
		settlementPositionsMainIsland.add(353);
		settlementPositionsMainIsland.add(141);//13
		settlementPositionsMainIsland.add(361);
		settlementPositionsMainIsland.add(163);//14
		settlementPositionsMainIsland.add(352);
		settlementPositionsMainIsland.add(78);//15
		settlementPositionsMainIsland.add(351);
		settlementPositionsMainIsland.add(77);//16
		settlementPositionsMainIsland.add(325);
		settlementPositionsMainIsland.add(98);//17
		settlementPositionsMainIsland.add(315);
		settlementPositionsMainIsland.add(120);//18
		settlementPositionsMainIsland.add(326);
		settlementPositionsMainIsland.add(141);//19
		settlementPositionsMainIsland.add(316);
		settlementPositionsMainIsland.add(163);//20
		settlementPositionsMainIsland.add(326);
		settlementPositionsMainIsland.add(56);//21
		settlementPositionsMainIsland.add(314);
		settlementPositionsMainIsland.add(56);//22
		settlementPositionsMainIsland.add(291);
		settlementPositionsMainIsland.add(77);//23
		settlementPositionsMainIsland.add(279);
		settlementPositionsMainIsland.add(98);//24
		settlementPositionsMainIsland.add(290);
		settlementPositionsMainIsland.add(120);//25
		settlementPositionsMainIsland.add(282);
		settlementPositionsMainIsland.add(141);//26
		settlementPositionsMainIsland.add(289);
		settlementPositionsMainIsland.add(162);//27
		settlementPositionsMainIsland.add(280);
		settlementPositionsMainIsland.add(183);//28 
		settlementPositionsMainIsland.add(290);
		settlementPositionsMainIsland.add(183);//29
		settlementPositionsMainIsland.add(364);
		settlementPositionsMainIsland.add(205);//30
		settlementPositionsMainIsland.add(399);
		settlementPositionsMainIsland.add(77);//31
		settlementPositionsMainIsland.add(252);
		settlementPositionsMainIsland.add(98);//32
		settlementPositionsMainIsland.add(245);
		settlementPositionsMainIsland.add(119);//33
		settlementPositionsMainIsland.add(253);
		settlementPositionsMainIsland.add(141);//34
		settlementPositionsMainIsland.add(242);
		settlementPositionsMainIsland.add(161);//35
		settlementPositionsMainIsland.add(252);
		settlementPositionsMainIsland.add(184);//36
		settlementPositionsMainIsland.add(244);
		settlementPositionsMainIsland.add(184);//37
		settlementPositionsMainIsland.add(214);
		settlementPositionsMainIsland.add(100);//38
		settlementPositionsMainIsland.add(216);
		settlementPositionsMainIsland.add(119);//39
		settlementPositionsMainIsland.add(204);
		settlementPositionsMainIsland.add(141);//40
		settlementPositionsMainIsland.add(215);
		settlementPositionsMainIsland.add(163);//41
		settlementPositionsMainIsland.add(204);
		settlementPositionsMainIsland.add(205);//42
		settlementPositionsMainIsland.add(205);
		settlementPositionsMainIsland.add(205);//43
		settlementPositionsMainIsland.add(179);
		settlementPositionsMainIsland.add(185);//44
		settlementPositionsMainIsland.add(168);
		settlementPositionsMainIsland.add(162);//45
		settlementPositionsMainIsland.add(178);
		settlementPositionsMainIsland.add(141);//46
		settlementPositionsMainIsland.add(169);
		settlementPositionsMainIsland.add(120);//47
		settlementPositionsMainIsland.add(180);
		settlementPositionsMainIsland.add(183);//48
		settlementPositionsMainIsland.add(316);
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
