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

public class LoadingScreen implements Screen{
	private static boolean setter=false;
	private CatanGame game;
    private Stage stage;
    private BitmapFont font;
    private Skin skin;
    private Pixmap pixmap;
    private TextureAtlas atlas;
    private Table table;
    private static boolean pickNumbers = false;
    
    public LoadingScreen(CatanGame game){
    	this.game = game;
    }
	
	@Override
	public void show() {
		stage = new Stage(); //stage is an inputprocessor
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
        
        TextureRegion upr = atlas.findRegion("t9"); //gets the image named "t5" from the spriteSheet 
        
        TextButtonStyle textButtonStyle = new TextButtonStyle();
        textButtonStyle.up = new TextureRegionDrawable(upr); //when the button is not clicked or hovered over
        textButtonStyle.down = skin.newDrawable("pmap", Color.DARK_GRAY); //when the button is clicked 
        textButtonStyle.checked = skin.newDrawable("pmap", Color.BLUE); //when the button is clicked and then released
        textButtonStyle.over = skin.newDrawable("pmap", Color.LIGHT_GRAY); //when the mouse is hovered over the button
        textButtonStyle.font = font; 
        skin.add("tStyle", textButtonStyle); //adds the textButtonStyle to the skin
        
        TextButton generateRandomBandN = new TextButton("Random Board and Random Numbers", skin, "tStyle");
        TextButton generateRandomBandPickN = new TextButton("Random Board, Pick Numbers", skin, "tStyle");
        table.add(generateRandomBandN).width(545).height(50).spaceBottom(10);
        table.row();
        table.add(generateRandomBandPickN).width(438).height(50).spaceBottom(10);
        table.row();
        generateRandomBandPickN.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				pickNumbers = true;
				game.setScreen(new HexGenerator(game));
			}
        });
        generateRandomBandN.addListener(new ChangeListener(){
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				pickNumbers = false;
				setter=true;
				game.setScreen(new HexGenerator(game));
			}
        });
	}
	
	public static boolean getPickNumbers(){
		return pickNumbers;
	}
	
	public boolean getSetter() {
		return setter;
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clears the frame buffer. Now we are free to render a fresh frame with
		//new scene graphics
		stage.act(Gdx.graphics.getDeltaTime()); //updates all the actors in the stage.
		//Delta is the time in seconds between the last frame
        stage.draw(); //draws all the actors in the stage
        //stage.setDebugAll(true); sets debug lines for everything
		
	}

	@Override
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
	public void dispose() {
		stage.dispose();
		skin.dispose();
		font.dispose();
		atlas.dispose();
		pixmap.dispose();
		Gdx.input.setInputProcessor(null);
		
	}

}
