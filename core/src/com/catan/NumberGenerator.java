package com.catan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class NumberGenerator {
private SpriteBatch batch;
private Skin skin;
private Pixmap pixmap;
private Stage stage;
private TextureAtlas atlas;

NumberGenerator() {
	pixmap = new Pixmap(1, 1, Format.RGBA8888);
	batch=new SpriteBatch();
	skin=new Skin();
	stage=new Stage();
	atlas=new TextureAtlas(Gdx.files.internal("mainIslandNumbers.txt"));
}

public void generate() {
	pixmap.setColor(Color.WHITE);
	pixmap.fill();
	skin.add("pmap", new Texture(pixmap));
}
}
