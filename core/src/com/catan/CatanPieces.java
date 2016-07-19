package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
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
    private int mouseX = 0;
    private int mouseY = 0;
    private int mpX = 0;
    private int mpY = 0;
    private int firstX = -1;
    private int firstY = -1;
    private int secondX = -1;
    private int secondY = -1;
    private ArrayList<Integer> positions; //adjust for the widget dimensions
    private Texture texture;
    private TextureAtlas atlas;
    private InputMultiplexer multiplexer;
	private CatanGame game;
	private ImageButton settlement;
	private ArrayList<ImageButton> settlements;
	private ArrayList<ImageButton> roads;
	
	public CatanPieces(CatanGame game){
		this.game = game;
	}
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		stage = new Stage();
		atlas = new TextureAtlas(Gdx.files.internal("Red.txt"));
		TextureRegion reg = atlas.findRegion("redRoad");
		settlement = new ImageButton(new TextureRegionDrawable(reg));
		settlement.setBounds(10, 10, 10, 10);
		stage.addActor(settlement);
		settlement.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				settlement.setVisible(false);
			}
		});
		positions = new ArrayList<Integer>();
		findPositions();
		texture = new Texture(Gdx.files.internal("Scenario5Final.png"));
		multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(this);
		Gdx.input.setInputProcessor(multiplexer);
		settlements = new ArrayList<ImageButton>();
		roads = new ArrayList<ImageButton>();
		roads.add(new ImageButton(new TextureRegionDrawable(reg)));
		findSettlements(282, 326);
		midpoint(positions.get(firstX), positions.get(firstY), positions.get(secondX), positions.get(secondY));
		roads.get(0).setBounds(mpX-5, mpY-5, 10, 10);
		stage.addActor(roads.get(0));
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
        //stage.setDebugAll(true); //sets debug lines for everything
		
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
		if(keycode == Keys.A){
			settlement.setPosition(settlement.getX()-1, settlement.getY());
			mouseX = mouseX - 1;
		}
		if(keycode == Keys.D){
			settlement.setPosition(settlement.getX()+1, settlement.getY());
			mouseX = mouseX + 1;
		}
		if(keycode == Keys.S){
			settlement.setPosition(settlement.getX(), settlement.getY()-1);
			mouseY = mouseY - 1;
		}
		if(keycode == Keys.W){
			settlement.setPosition(settlement.getX(), settlement.getY()+1);
			mouseY = mouseY + 1;
		}
		System.out.println(mouseX);
		System.out.println(mouseY);
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
		mouseX = screenX;
		mouseY = Gdx.graphics.getHeight()-1 - screenY;
		System.out.println(screenX);
		System.out.println(Gdx.graphics.getHeight()-1 - screenY);
		findSettlements(screenX, Gdx.graphics.getHeight()-1 - screenY);
		return false;
	}
	
	public void midpoint(int f, int g, int h, int i){
		mpX = (f+h)/2;
		mpY = (g+i)/2;
	}
	
	public int distance(int f, int g, int h, int i, int size){
		return (int) Math.sqrt((Math.pow((f-h-size), 2)) + (Math.pow((g-i), 2)));
	}
	
	public void findSettlements(int mousex, int mousey){
		int smallestDistance = 100;
		int times = 1;
		int stop = -1;
		while(times >= 0){
			smallestDistance = 100;
		for(int i = 0; i<positions.size()-1; i+=2){
			if(i != stop){
			if(distance(mousex, mousey, positions.get(i), positions.get(i+1), 0) < smallestDistance){
				smallestDistance = distance(mousex, mousey, positions.get(i), positions.get(i+1), 0);
				if(times == 1){
				firstX = i;
				firstY = i+1;
				}
				else{
					secondX = i;
					secondY = i+1;
				}
			}
			}
		}
		times--;
		stop = firstX;
		}
	}
	
	public ArrayList<Integer> getPositions(){
		return positions;
	}
	
	public void findPositions(){
		positions.add(141);//1
		positions.add(438);
		positions.add(119);//2
		positions.add(401);
		positions.add(119);//3
		positions.add(426);
		positions.add(98);//4
		positions.add(388);
		positions.add(98);//5
		positions.add(363);
		positions.add(77);//6
		positions.add(351);
		positions.add(77);//7
		positions.add(327);
		positions.add(55);//8
		positions.add(314);
		positions.add(55);//9
		positions.add(290);
		positions.add(76);//10
		positions.add(278);
		positions.add(76);//11
		positions.add(254);
		positions.add(98);//12
		positions.add(241);
		positions.add(98);//13
		positions.add(217);
		positions.add(119);//14
		positions.add(204);
		positions.add(119);//15
		positions.add(180);
		positions.add(140);//16
		positions.add(168);
		positions.add(162);//17
		positions.add(180);
		positions.add(183);//18
		positions.add(168);
		positions.add(205);//19
		positions.add(180);
		positions.add(226);//20
		positions.add(168);
		positions.add(248);//21
		positions.add(180);
		positions.add(269);//22
		positions.add(168);
		positions.add(290);//23
		positions.add(180);
		positions.add(311);//24
		positions.add(169);
		positions.add(333);//25
		positions.add(180);
		positions.add(354);//26
		positions.add(169);
		positions.add(376);//27
		positions.add(180);
		positions.add(397);//28
		positions.add(169);
		positions.add(419);//29
		positions.add(180);
		positions.add(440);//30
		positions.add(169);
		positions.add(461);//31
		positions.add(180);
		positions.add(482);//32
		positions.add(169);
		positions.add(504);//33
		positions.add(181);
		positions.add(504);//34
		positions.add(205);
		positions.add(525);//35
		positions.add(218);
		positions.add(525);//36
		positions.add(242);
		positions.add(546);//37
		positions.add(254);
		positions.add(546);//38
		positions.add(279);
		positions.add(567);//39
		positions.add(291);
		positions.add(567);//40
		positions.add(316);
		positions.add(547);//41
		positions.add(328);
		positions.add(546);//42
		positions.add(352);
		positions.add(525);//43
		positions.add(365);
		positions.add(525);//44
		positions.add(389);
		positions.add(504);//45
		positions.add(402);
		positions.add(503);//46
		positions.add(426);
		positions.add(482);//47
		positions.add(438);
		positions.add(461);//48
		positions.add(426);
		positions.add(439);//49
		positions.add(438);
		positions.add(418);//50
		positions.add(426);
		positions.add(396);//51
		positions.add(438);
		positions.add(375);//52
		positions.add(426);
		positions.add(353);//53
		positions.add(438);
		positions.add(332);//54
		positions.add(426);
		positions.add(311);//55
		positions.add(438);
		positions.add(290);//56
		positions.add(426);
		positions.add(269);//57
		positions.add(437);
		positions.add(247);//58
		positions.add(425);
		positions.add(226);//59
		positions.add(437);
		positions.add(205);//60
		positions.add(425);
		positions.add(183);//61
		positions.add(438);
		positions.add(162);//62
		positions.add(426);
		positions.add(204);//63
		positions.add(401);
		positions.add(183);//64
		positions.add(389);
		positions.add(162);//65
		positions.add(401);
		positions.add(140);//66
		positions.add(389);
		positions.add(140);//67
		positions.add(364);
		positions.add(162);//68
		positions.add(351);
		positions.add(183);//69
		positions.add(364);
		positions.add(119);//70
		positions.add(351);
		positions.add(98);//71
		positions.add(315);
		positions.add(119);//72
		positions.add(327);
		positions.add(141);//73
		positions.add(315);
		positions.add(162);//74
		positions.add(327);
		positions.add(98);//75
		positions.add(290);
		positions.add(119);//76
		positions.add(279);
		positions.add(140);//77
		positions.add(291);
		positions.add(162);//78
		positions.add(278);
		positions.add(183);//79
		positions.add(291);
		positions.add(184);//80
		positions.add(315);
		positions.add(119);//81
		positions.add(253);
		positions.add(141);//82
		positions.add(242);
		positions.add(161);//83
		positions.add(254);
		positions.add(141);//84
		positions.add(216);
		positions.add(183);//85
		positions.add(242);
		positions.add(184);//86
		positions.add(216);
		positions.add(162);//87
		positions.add(204);
		positions.add(205);//88
		positions.add(204);
		positions.add(247);//89
		positions.add(401);
		positions.add(227);//90
		positions.add(388);
		positions.add(227);//91
		positions.add(364);
		positions.add(205);//92
		positions.add(351);
		positions.add(205);//93
		positions.add(328);
		positions.add(226);//94
		positions.add(315);
		positions.add(226);//95
		positions.add(291);
		positions.add(205);//96
		positions.add(279);
		positions.add(205);//97
		positions.add(254);
		positions.add(227);//98
		positions.add(242);
		positions.add(226);//99
		positions.add(217);
		positions.add(247);//0
		positions.add(204);
		positions.add(290);//1
		positions.add(401);
		positions.add(269);//2
		positions.add(388);
		positions.add(270);//3
		positions.add(365);
		positions.add(248);//4
		positions.add(351);
		positions.add(248);//5
		positions.add(328);
		positions.add(269);//6
		positions.add(316);
		positions.add(269);//7
		positions.add(292);
		positions.add(247);//8
		positions.add(279);
		positions.add(248);//9
		positions.add(254);
		positions.add(268);//10
		positions.add(242);
		positions.add(269);//11
		positions.add(217);
		positions.add(290);//12
		positions.add(205);
		positions.add(332);//13
		positions.add(402);
		positions.add(311);//14
		positions.add(389);
		positions.add(312);//15
		positions.add(366);
		positions.add(290);//16
		positions.add(353);
		positions.add(290);//17
		positions.add(329);
		positions.add(311);//18
		positions.add(316);
		positions.add(311);//19
		positions.add(292);
		positions.add(290);//20
		positions.add(279);
		positions.add(290);//21
		positions.add(255);
		positions.add(311);//22
		positions.add(242);
		positions.add(311);//23
		positions.add(218);
		positions.add(333);//24
		positions.add(205);
		positions.add(375);//25
		positions.add(402);
		positions.add(355);//26
		positions.add(389);
		positions.add(355);//27
		positions.add(366);
		positions.add(333);//28
		positions.add(353);
		positions.add(333);//29
		positions.add(328);
		positions.add(354);//30
		positions.add(316);
		positions.add(354);//31
		positions.add(292);
		positions.add(333);//32
		positions.add(279);
		positions.add(333);//33
		positions.add(255);
		positions.add(354);//34
		positions.add(242);
		positions.add(354);//35
		positions.add(218);
		positions.add(375);//36
		positions.add(205);
		positions.add(418);//37
		positions.add(402);
		positions.add(397);//38
		positions.add(390);
		positions.add(397);//39
		positions.add(365);
		positions.add(376);//40
		positions.add(353);
		positions.add(376);//41
		positions.add(328);
		positions.add(397);//42
		positions.add(316);
		positions.add(397);//43
		positions.add(291);
		positions.add(375);//44
		positions.add(279);
		positions.add(375);//45
		positions.add(254);
		positions.add(397);//46
		positions.add(242);
		positions.add(397);//47
		positions.add(217);
		positions.add(418);//48
		positions.add(205);
		positions.add(461);//49
		positions.add(402);
		positions.add(440);//50
		positions.add(389);
		positions.add(440);//51
		positions.add(364);
		positions.add(419);//52
		positions.add(353);
		positions.add(419);//53
		positions.add(328);
		positions.add(440);//54
		positions.add(316);
		positions.add(440);//55
		positions.add(291);
		positions.add(418);//56
		positions.add(280);
		positions.add(418);//57
		positions.add(254);
		positions.add(440);//58
		positions.add(242);
		positions.add(440);//59
		positions.add(218);
		positions.add(461);//60
		positions.add(205);
		positions.add(483);//61
		positions.add(389);
		positions.add(483);//62
		positions.add(364);
		positions.add(461);//63
		positions.add(352);
		positions.add(461);//64
		positions.add(328);
		positions.add(483);//65
		positions.add(316);
		positions.add(482);//66
		positions.add(291);
		positions.add(461);//67
		positions.add(279);
		positions.add(461);//68
		positions.add(254);
		positions.add(482);//69
		positions.add(242);
		positions.add(482);//70
		positions.add(217);
		positions.add(504);//71
		positions.add(352);
		positions.add(504);//72
		positions.add(328);
		positions.add(525);//73
		positions.add(316);
		positions.add(525);//74
		positions.add(291);
		positions.add(503);//75
		positions.add(279);
		positions.add(503);//76
		positions.add(254);
		
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
