package com.catan;

import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

//This class displays the main menu screen for the game
public class MainMenuScreen implements Screen {
    private CatanGame game;
    private Stage stage;
    private BitmapFont font;
    private Skin skin;
    private Pixmap pixmap;
    private TextureAtlas atlas;
    private Table table;
    
    //Constructor- passes an instance of CatanGame, in order to have the ability to switch screens
    MainMenuScreen(CatanGame game){
    	this.game = game;
    }
	
	//renders the screen and updates the stage. This method is called continuously
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clears the frame buffer. Now we are free to render a fresh frame with
		//new scene graphics
		stage.act(Gdx.graphics.getDeltaTime()); //updates all the actors in the stage.
		//Delta is the time in seconds between the last frame
        stage.draw(); //draws all the actors in the stage
        //stage.setDebugAll(true); sets debug lines for everything
	}

	//resizes the stage when the screen is resized
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);//resizes the stage based on the stage's viewport
        //the third parameter changes the camera position so it is centered on the stage, making 0,0 
		//the bottom left corner
	}

	//This method is called once, and displays all the actors in the stage
	public void show() {
		stage = new Stage(new ScreenViewport()); //stage is an inputprocessor
		Gdx.input.setInputProcessor(stage); //the inputprocessor is the object that handles all input
	    font = new BitmapFont(Gdx.files.internal("gameFonts.fnt")); //gets the fonts from the assets folder of the core project
	    skin = new Skin();
	    table = new Table();
		table.setFillParent(true);// sizes the table to the stage
		stage.addActor(table);
	    atlas = new TextureAtlas(Gdx.files.internal("myTextures.txt")); //gets the spritesheet from the assets folder of the core project
	    
	 // Generate a 1x1 white texture and store it in the skin named "pmap".
        pixmap = new Pixmap(1, 1, Format.RGBA8888);// (width in pixels, height in pixels, format)
        //Format is an enumeration and RGBA8888 is an enum constant specifying the pixel format
        pixmap.setColor(Color.WHITE); 
        pixmap.fill(); //fills the complete bitmap with the currently set color
        skin.add("pmap", new Texture(pixmap)); //adds the pixmap to the skin

        // Store the libgdx font under the name "default".
        skin.add("default", font); //adds the BitmapFont to the skin
        
        TextureRegion upr = atlas.findRegion("t5"); //gets the image named "t5" from the spriteSheet 
        
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = new TextureRegionDrawable(upr); //when the button is not clicked or hovered over
        textButtonStyle.down = skin.newDrawable("pmap", Color.DARK_GRAY); //when the button is clicked 
        textButtonStyle.checked = skin.newDrawable("pmap", Color.BLUE); //when the button is clicked and then released
        textButtonStyle.over = skin.newDrawable("pmap", Color.LIGHT_GRAY); //when the mouse is hovered over the button
        textButtonStyle.font = font; 
        skin.add("tStyle", textButtonStyle); //adds the textButtonStyle to the skin
        
        TextButton button = new TextButton("New Game", skin, "tStyle"); //if you omit the third parameter(the style name),
        //the name "default" is used
        
        //spacing adds extra space around the edges of a cell
        //makes it easy to have consistent spacing between cells in a table
        table.add(button).width(300).height(100).spaceBottom(10);
        button.addListener(new ChangeListener(){

			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new NetworkScreen(game));//was new ScenarioScreen
			}
        });
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	//Disposes of all of the resources
	public void dispose() {
		stage.dispose();
		skin.dispose();
		font.dispose();
		atlas.dispose();
		pixmap.dispose();
		Gdx.input.setInputProcessor(null);
		try {
			Host.getServer().dispose();
		} catch (IOException e) {
			System.out.println("Server cannot be disposed of");
		}
	}

}
