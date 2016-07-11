package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

//This class is the screen that users can use to select the players
//that are going to play the game
public class PlayerScreen implements Screen {
    CatanGame game;
    private Stage stage;
    private BitmapFont font;
    private Skin skin;
    private Pixmap pixmap;
    private TextureAtlas atlas;
    private Table table;
    private ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
	
    //Constructor that takes the main game object as a parameter, in order to be able to switch screens
	public PlayerScreen(CatanGame game){
		this.game = game;
	}
	
	@Override
	public void show() {
		stage = new Stage();
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
        
        CheckBoxStyle style = new CheckBoxStyle();
        
        Texture texture = new Texture(Gdx.files.internal("playerCheckBox.png"));
        Sprite sprite = new Sprite(texture);
        style.checkboxOff = new SpriteDrawable(sprite);
        
        texture = new Texture(Gdx.files.internal("playerCheckBoxRed.png"));
        sprite = new Sprite(texture);
        style.checkboxOn = new SpriteDrawable(sprite);
        style.font = font;
        skin.add("checkBoxStyle", style);
        GamePlayers.getGamePlayers().add(new Player("Sam"));
        GamePlayers.getGamePlayers().add(new Player("Josh"));
        GamePlayers.getGamePlayers().add(new Player("Mark"));
        
        for(int i = 0; i<GamePlayers.getGamePlayers().size(); i++){
        	boxes.add(new CheckBox(GamePlayers.getGamePlayers().get(i).getName(), skin, "checkBoxStyle"));
        	boxes.get(boxes.size()-1).setName(GamePlayers.getGamePlayers().get(i).getName());
        	table.add(boxes.get(boxes.size()-1)).width(150).height(60);
        	table.row();
        	boxes.get(boxes.size()-1).addListener(new ChangeListener(){
                
				public void changed(ChangeEvent event, Actor actor) {
					System.out.println(actor.getName());
				}
        	});
        }
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clears the frame buffer. Now we are free to render a fresh frame with
		//new scene graphics
		stage.act(Gdx.graphics.getDeltaTime()); //updates all the actors in the stage.
		//Delta is the time in seconds between the last frame
        stage.draw(); //draws all the actors in the stage
        //stage.setDebugAll(true); //sets debug lines for everything
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
