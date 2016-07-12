package com.catan;

import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//This class is used to allow users to select a player name
public class PlayerScreen implements Screen {
	    private CatanGame game;
	    private Stage stage;
	    private static BitmapFont font;
	    private Skin skin;
	    private Pixmap pixmap;
	    private TextureAtlas atlas;
	    private static boolean selectName = false; //toggles if the user is selecting a name or a color
	    private static SpriteBatch batch;
	    private static int XCoord = 260;
	    private static int YCoord = 420;
	    private static boolean increase = false; //toggles when to increase the YCoord
	    private static TextButton continueButton;
	    
	    //Constructor takes the main game object as a parameter, in order to be able to switch screens
		public PlayerScreen(CatanGame game){
			this.game = game;
		}
		
		@Override
		//adds all of the actors to the stage 
		public void show() {
			batch = new SpriteBatch();
			stage = new Stage();
			Gdx.input.setInputProcessor(stage);
			font = new BitmapFont(Gdx.files.internal("gameFonts.fnt"));
			skin = new Skin();
		    atlas = new TextureAtlas(Gdx.files.internal("myTextures.txt")); //gets the spritesheet from the assets folder of the core project

		 // Generate a 1x1 white texture and store it in the skin named "pmap".
	        pixmap = new Pixmap(1, 1, Format.RGBA8888);// (width in pixels, height in pixels, format)
	        //Format is an enumeration and RGBA8888 is an enum constant specifying the pixel format
	        pixmap.setColor(Color.WHITE); 
	        pixmap.fill(); //fills the complete bitmap with the currently set color
	        skin.add("pmap", new Texture(pixmap)); //adds the pixmap to the skin

	        // Store the libgdx font under the name "default".
	        skin.add("default", font); //adds the BitmapFont to the skin
	        
	        TextureRegion upr = atlas.findRegion("t7"); //gets the image named "t5" from the spriteSheet 
	        
	        TextButtonStyle textButtonStyle = new TextButtonStyle();
	        textButtonStyle.up = new TextureRegionDrawable(upr); //when the button is not clicked or hovered over
	        textButtonStyle.down = skin.newDrawable("pmap", Color.DARK_GRAY); //when the button is clicked 
	        textButtonStyle.over = skin.newDrawable("pmap", Color.LIGHT_GRAY); //when the mouse is hovered over the button
	        textButtonStyle.font = font; 
	        skin.add("tStyle", textButtonStyle); //adds the textButtonStyle to the skin
	        
	        TextButton pickAName = new TextButton("Select A Player Name", skin, "tStyle");
	        pickAName.setBounds(160, 400, 340, 100);
	        stage.addActor(pickAName);
	        pickAName.addListener(new ChangeListener(){

				@Override
				public void changed(ChangeEvent event, Actor actor) {
					selectName = true;
					MyTextInputListener listener = new MyTextInputListener();
					Gdx.input.getTextInput(listener, "Select a Player Name", "", "");
				}
	        });
	        
	        TextButton back = new TextButton("Back", skin, "tStyle");
	        back.setBounds(500, 20, 100, 50);
	        stage.addActor(back);
	        back.addListener(new ChangeListener(){
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					selectName = false;
					increase = false;
					GamePlayers.getGamePlayers().clear();
                  game.setScreen(new ScenarioScreen(game));					
				}
	        });
	        
	        continueButton = new TextButton("Continue", skin, "tStyle");
			continueButton.setVisible(false);
			continueButton.setBounds(160, 50, 180, 100);
			stage.addActor(continueButton);
			continueButton.addListener(new ChangeListener(){

				@Override
				public void changed(ChangeEvent event, Actor actor) {
					selectName = false;
					game.setScreen(new PlayerColorScreen(game));
				}
			});
		}
		
		//returns the "Continue" text button
		public static TextButton getContinueButton(){
			return continueButton;
		}
		
		//returns the selectName boolean
		public static boolean getSelectName(){
			return selectName;
		}
		
		//sets the selectName boolean
		public static void setSelectName(boolean name){
			selectName = name;
		}

		@Override
		//renders the screen, draws the actors in the stage, and updates the actors in the stage
		public void render(float delta) {
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clears the frame buffer. Now we are free to render a fresh frame with
			//new scene graphics
			stage.act(Gdx.graphics.getDeltaTime()); //updates all the actors in the stage.
			//Delta is the time in seconds between the last frame
	        stage.draw(); //draws all the actors in the stage
	        //stage.setDebugAll(true); sets debug lines for everything
	        //batch.setProjectionMatrix(stage.getViewport().getCamera().combined);
	        if(MyTextInputListener.getDrawNames()){
	        	YCoord = 420;
	        	for(int i = 0; i<GamePlayers.getGamePlayers().size(); i++){
	        		if(increase){
		        		setYCoord(getYCoord() - 35);
		        	}
	        		batch.begin();
	        	font.draw(batch, GamePlayers.getGamePlayers().get(i).getName(), XCoord, YCoord);
	        	batch.end();
	        }
	        }
		}
		
		//returns the font
		public static BitmapFont getFont(){
			return font;
		}
		
		//returns the YCoord 
		public static int getYCoord(){
			return YCoord;
		}
		
		//sets the YCoord
		public static void setYCoord(int y){
			YCoord = y;
		}
		
		//returns the increase boolean
		public static boolean getIncrease(){
			return increase;
		}
		
		//sets the increase boolean
		public static void setIncrease(boolean inc){
			increase = inc;
		}
		
		@Override
		//sets the new stage size to scale with the new window size
		public void resize(int width, int height) {
			stage.getViewport().update(width, height, true);//resizes the stage based on the stage's viewport
	        //the third parameter changes the camera position so it is centered on the stage, making 0,0 
			//the bottom left corner

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
		//disposes of all allocated resources
		public void dispose() {
			stage.dispose();
			skin.dispose();
			font.dispose();
			atlas.dispose();
			pixmap.dispose();
			batch.dispose();
			Gdx.input.setInputProcessor(null);

		}

}
