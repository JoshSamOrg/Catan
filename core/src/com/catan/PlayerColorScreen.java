package com.catan;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox.CheckBoxStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

//This class is the screen that users can use to select the players
//that are going to play the game
public class PlayerColorScreen implements Screen {
    private CatanGame game;
    private Stage stage;
    private BitmapFont font;
    private Skin skin;
    private Pixmap pixmap;
    private TextureAtlas atlas;
    private Table table;
    private static ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
    private static CheckBoxStyle white;
    private static CheckBoxStyle blue;
    private static CheckBoxStyle orange;
    private static CheckBoxStyle red;
	
    //Constructor that takes the main game object as a parameter, in order to be able to switch screens
	public PlayerColorScreen(CatanGame game){
		this.game = game;
	}
	
	@Override
	public void show() {
		selectPlayers();
	}
	
	//Allows the users to select what colors they want to play with
	public void selectPlayers(){
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
        
        white = new CheckBoxStyle();
        Texture texture = new Texture(Gdx.files.internal("playerCheckBox.png"));
        Sprite sprite = new Sprite(texture);
        white.checkboxOff = new SpriteDrawable(sprite);
        texture = new Texture(Gdx.files.internal("playerCheckBoxRed.png"));
        sprite = new Sprite(texture);
        white.checkboxOn = new SpriteDrawable(sprite);
        white.font = font;
        white.fontColor = Color.WHITE;
        skin.add("white", white);
        
        orange = new CheckBoxStyle();
        texture = new Texture(Gdx.files.internal("playerCheckBox.png"));
        sprite = new Sprite(texture);
        orange.checkboxOff = new SpriteDrawable(sprite);
        texture = new Texture(Gdx.files.internal("playerCheckBoxRed.png"));
        sprite = new Sprite(texture);
        orange.checkboxOn = new SpriteDrawable(sprite);
        orange.font = font;
        orange.fontColor = Color.ORANGE;
        skin.add("orange", orange);
        
        blue = new CheckBoxStyle();
        texture = new Texture(Gdx.files.internal("playerCheckBox.png"));
        sprite = new Sprite(texture);
        blue.checkboxOff = new SpriteDrawable(sprite);
        texture = new Texture(Gdx.files.internal("playerCheckBoxRed.png"));
        sprite = new Sprite(texture);
        blue.checkboxOn = new SpriteDrawable(sprite);
        blue.font = font;
        blue.fontColor = Color.BLUE;
        skin.add("blue", blue);
        
        red = new CheckBoxStyle();
        texture = new Texture(Gdx.files.internal("playerCheckBox.png"));
        sprite = new Sprite(texture);
        red.checkboxOff = new SpriteDrawable(sprite);
        texture = new Texture(Gdx.files.internal("playerCheckBoxRed.png"));
        sprite = new Sprite(texture);
        red.checkboxOn = new SpriteDrawable(sprite);
        red.font = font;
        red.fontColor = Color.RED;
        skin.add("red", red);
        TextFieldStyle tfStyle = new TextFieldStyle();
        tfStyle.font = font;
        tfStyle.fontColor = Color.GREEN;
        skin.add("tfStyle", tfStyle);
        TextField fieldpt1 = new TextField("Select the blue check box by your name to", skin, "tfStyle");
        table.add(fieldpt1).width(600).height(50);
        table.row();
        TextField fieldpt2 = new TextField("choose the color you want your pieces to be.", skin, "tfStyle");
        table.add(fieldpt2).width(635).height(50);
        table.row();
        TextField colors = new TextField("The valid colors to choose from are", skin, "tfStyle");
        table.add(colors).width(630).height(50);
        table.row();
        TextField colors2 = new TextField("'red', 'blue', 'white', and 'orange'.", skin, "tfStyle");
        table.add(colors2).width(630).height(50);
        table.row();
        
        for(int i = 0; i<GamePlayers.getGamePlayers().size(); i++){
        	boxes.add(new CheckBox(GamePlayers.getGamePlayers().get(i).getName(), skin, "white"));
        	boxes.get(boxes.size()-1).setName(GamePlayers.getGamePlayers().get(i).getName());
        	table.add(boxes.get(boxes.size()-1)).width(150).height(60);
        	table.row();
        	boxes.get(boxes.size()-1).addListener(new ChangeListener(){
                
				public void changed(ChangeEvent event, Actor actor) {
					MyTextInputListener listener = new MyTextInputListener();
					MyTextInputListener.setCurrentPlayer(actor.getName());
					Gdx.input.getTextInput(listener, "Select a Color", "", "");
				}
        	});
        	
        	TextureRegion upr = atlas.findRegion("t7"); //gets the image named "t5" from the spriteSheet 
        	TextButtonStyle textButtonStyle = new TextButtonStyle();
	        textButtonStyle.up = new TextureRegionDrawable(upr); //when the button is not clicked or hovered over
	        textButtonStyle.down = skin.newDrawable("pmap", Color.DARK_GRAY); //when the button is clicked 
	        textButtonStyle.over = skin.newDrawable("pmap", Color.LIGHT_GRAY); //when the mouse is hovered over the button
	        textButtonStyle.font = font; 
	        skin.add("tStyle", textButtonStyle); //adds the textButtonStyle to the skin
	        
	        TextButton back = new TextButton("Back", skin, "tStyle");
	        back.setBounds(500, 20, 100, 50);
	        stage.addActor(back);
	        back.addListener(new ChangeListener(){
				@Override
				public void changed(ChangeEvent event, Actor actor) {
					PlayerScreen.setSelectName(false);
					PlayerScreen.setIncrease(false);
					GamePlayers.getGamePlayers().clear();
					MyTextInputListener.getValidColors().clear();
					game.setScreen(new PlayerScreen(game));
				}
	        });
        }
	}
	
	//returns the arraylist of checkBoxes
	public static ArrayList<CheckBox> getCheckBoxes(){
		return boxes;
	}
	
	//returns the number of players currently playing the game
	public static int getNumberOfPlayers(){
		int number = 0;
		for(int i = 0; i<boxes.size(); i++){
			if(boxes.get(i).isChecked()){
				number++;
			}
		}
		return number;
	}
	
	//returns the checkBoxStyle with the red font
	public static CheckBoxStyle getRed(){
		return red;
	}
	
	//returns the checkBoxStyle with the orange font
	public static CheckBoxStyle getOrange(){
		return orange;
	}
	
	//returns the checkBoxStyle with the blue font
	public static CheckBoxStyle getBlue(){
		return blue;
	}
	
	//returns the checkBoxStyle with the white font
	public static CheckBoxStyle getWhite(){
		return white;
	}

	@Override
	//Main render method that gets called continuously
	//updates and draws all the actors in the stage
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clears the frame buffer. Now we are free to render a fresh frame with
		//new scene graphics
		stage.act(Gdx.graphics.getDeltaTime()); //updates all the actors in the stage.
		//Delta is the time in seconds between the last frame
        stage.draw(); //draws all the actors in the stage
        //stage.setDebugAll(true); //sets debug lines for everything
	}

	@Override
	//resizes the stage to fit and scale based on a window resize
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
