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

public class PickNumbersScreen implements Screen, InputProcessor {
    private CatanGame game;
    private SpriteBatch batch;
    private Texture board;
    private Stage stage;
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
    private int[] coords = {h1x,h1y,h2x,h2y,h3x,h3y,h4x,h4y,h5x,h5y,h6x,h6y,grassx,grassy,h7x,h7y,h8x,h8y,
    		h9x,h9y,h10x,h10y,h11x,h11y,h12x,h12y,h13x,h13y,h14x,h14y};
    private TextureAtlas atlas;
    private boolean[] openSpots = {true,true,true,true,true,true,true,true,true,true,true,true,true,true,true};//size = 15
    private int[] HexLocations = {15,15,15,15,15,15,15,15,15,15,15,15,15,15,15}; //size = 15
    private ArrayList<TextureRegion> numbers;
    private ArrayList<ImageButton> numberImages;
    private InputMultiplexer multiplexer;
	
	public PickNumbersScreen(CatanGame game){
		this.game = game;
	}
	
	@Override
	public void show() {
		multiplexer = new InputMultiplexer();
		batch = new SpriteBatch();
		board = new Texture("Scenario5Final.png");
		stage = new Stage();
		multiplexer.addProcessor(stage);
		multiplexer.addProcessor(this);
		Gdx.input.setInputProcessor(multiplexer);
		atlas = new TextureAtlas(Gdx.files.internal("mainIslandNumbers.txt"));
		numbers = new ArrayList<TextureRegion>();
		numberImages = new ArrayList<ImageButton>();
		drawNumbers();
	}

	private void drawNumbers() {
     numbers.add(atlas.findRegion("12"));
     numbers.add(atlas.findRegion("green3"));
     numbers.add(atlas.findRegion("green3"));
     numbers.add(atlas.findRegion("green6"));
     numbers.add(atlas.findRegion("green6"));
     numbers.add(atlas.findRegion("orange4"));
     numbers.add(atlas.findRegion("orange4"));
     numbers.add(atlas.findRegion("orange5"));
     numbers.add(atlas.findRegion("orange8"));
     numbers.add(atlas.findRegion("orange8"));
     numbers.add(atlas.findRegion("orange9"));
     numbers.add(atlas.findRegion("orange10"));
     numbers.add(atlas.findRegion("orange10"));
     numbers.add(atlas.findRegion("orange11"));
     numbers.add(atlas.findRegion("orange11"));
     for(int i = 0; i<numbers.size(); i++){
    	 numberImages.add(new ImageButton(new TextureRegionDrawable(numbers.get(i))));
    	 numberImages.get(i).setBounds(imageStartX, imageY, 25, 25);
    	 stage.addActor(numberImages.get(i));
    	 imageStartX+=40;
    	 numberImages.get(i).addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				actor.setVisible(false);
				multiplexer.removeProcessor(stage);
			}
    	 });
     }
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clears the frame buffer. Now we are free to render a fresh frame with
		//new scene graphics
		batch.begin();
		batch.draw(board, 0, 0, 650, 650);
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime()); //updates all the actors in the stage.
		//Delta is the time in seconds between the last frame
        stage.draw(); //draws all the actors in the stage
        //stage.setDebugAll(true); sets debug lines for everything
		
	}

	@Override
	public void resize(int width, int height) {
		
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
		board.dispose();
		batch.dispose();
		multiplexer.clear();
		Gdx.input.setInputProcessor(null);
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
		outer: for(int i = 0; i<numberImages.size(); i++){
			if(!numberImages.get(i).isVisible()){
				for(int j = 0; j<coords.length-1; j+=2){
					if(isWithinRange(screenX, Gdx.graphics.getHeight() - 1 - screenY, coords[j], coords[j+1])){
						if(openSpots[j/2]){
				HexLocations[j/2] = i;
				numberImages.get(i).setPosition(coords[j], coords[j+1]);
				numberImages.get(i).setVisible(true);
				openSpots[j/2] = false;
				multiplexer.addProcessor(stage);
				break outer;
			}
						else{
							for(int k = 0; k<HexLocations.length; k++){
								if(HexLocations[k] == i){
									swap(HexLocations[j/2], i);
									int temp = HexLocations[k];
									HexLocations[k] = HexLocations[j/2];
									HexLocations[j/2] = temp;
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
		if(((screenX - hexX <= 30 && screenX >= hexX) || (hexX - screenX <= 6 && hexX >= screenX)) 
				&& ((screenY - hexY <= 30 && screenY >= hexY)
				|| (hexY - screenY <= 7 && hexY >= screenY))){
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
