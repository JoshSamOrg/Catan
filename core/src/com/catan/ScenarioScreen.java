package com.catan;

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

//This class is used to select which scenario the user(s) want to play
public class ScenarioScreen implements Screen {
    private CatanGame game;
    private Stage stage;
    private BitmapFont font;
    private Skin skin;
    private Pixmap pixmap;
    private TextureAtlas atlas;
    private Table table;
    
    //Constructor takes the main game object as a parameter, in order to be able to switch screens
	public ScenarioScreen(CatanGame game){
		this.game = game;
	}
	
	@Override
	//adds all of the actors to the stage 
	public void show() {
		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);
		font = new BitmapFont(Gdx.files.internal("gameFonts.fnt"));
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
        
        TextureRegion upr = atlas.findRegion("t6"); //gets the image named "t5" from the spriteSheet 
        
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = new TextureRegionDrawable(upr); //when the button is not clicked or hovered over
        textButtonStyle.down = skin.newDrawable("pmap", Color.DARK_GRAY); //when the button is clicked 
        textButtonStyle.checked = skin.newDrawable("pmap", Color.BLUE); //when the button is clicked and then released
        textButtonStyle.over = skin.newDrawable("pmap", Color.LIGHT_GRAY); //when the mouse is hovered over the button
        textButtonStyle.font = font; 
        skin.add("tStyle", textButtonStyle); //adds the textButtonStyle to the skin
        
        TextButton s1 = new TextButton("Scenario 1", skin, "tStyle"); //scenario 1 button
        TextButton s2 = new TextButton("Scenario 2", skin, "tStyle"); //scenario 2 button
        TextButton s3 = new TextButton("Scenario 3", skin, "tStyle"); //scenario 3 button
        TextButton s4 = new TextButton("Scenario 4", skin, "tStyle"); //scenario 4 button
        TextButton s5 = new TextButton("Scenario 5", skin, "tStyle"); //scenario 5 button
        TextButton back = new TextButton("Back", skin, "tStyle");
        back.setBounds(500, 20, 100, 50);
        back.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new MainMenuScreen(game));
			}
        });
        stage.addActor(back);
        table.add(s1).width(300).height(50).spaceBottom(10);
        table.row();
        table.add(s2).width(300).height(50).spaceBottom(10);
        table.row();
        table.add(s3).width(300).height(50).spaceBottom(10);
        table.row();
        table.add(s4).width(300).height(50).spaceBottom(10);
        table.row();
        table.add(s5).width(300).height(50).spaceBottom(10);
        s5.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				game.setScreen(new PlayerScreen(game));
			}
        });
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
		Gdx.input.setInputProcessor(null);

	}

}
