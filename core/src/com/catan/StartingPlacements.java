package com.catan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class StartingPlacements {
	private static int posX=8,posY=160;
	private static HexGenerator place;
	private CatanGame game;
	private boolean first = true;
	private TextureAtlas orangeAtlas, whiteAtlas, blueAtlas, redAtlas;

	public StartingPlacements() {
		game = new CatanGame();
		place = new HexGenerator(game);
		orangeAtlas = new TextureAtlas(Gdx.files.internal("Orange.txt"));
		whiteAtlas = new TextureAtlas(Gdx.files.internal("White.txt"));
		blueAtlas = new TextureAtlas(Gdx.files.internal("Blue.txt"));
		redAtlas = new TextureAtlas(Gdx.files.internal("Red.txt"));

	}

	public void Start() {
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangeSettlement"))));
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangeHarborSettlement"))));
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangeRoad"))));
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangeShip"))));
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangeSettler"))));
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangePirateShip"))));
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangeCrew"))));
		place.getOrange().add(
				new ImageButton(new TextureRegionDrawable(orangeAtlas
						.findRegion("orangeCircle"))));

		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whiteSettlement"))));
		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whiteHarborSettlement"))));
		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whiteRoad"))));
		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whiteShip"))));
		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whiteSettler"))));
		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whitePirateShip"))));
		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whiteCrew"))));
		place.getWhite().add(
				new ImageButton(new TextureRegionDrawable(whiteAtlas
						.findRegion("whiteCircle"))));

		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("blueSettlement"))));
		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("blueHarborSettlement"))));
		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("blueRoad"))));
		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("blueShip"))));
		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("blueSettler"))));
		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("bluePirateShip"))));
		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("blueCrew"))));
		place.getBlue().add(
				new ImageButton(new TextureRegionDrawable(blueAtlas
						.findRegion("blueCircle"))));

		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redSettlement"))));
		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redHarborSettlement"))));
		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redRoad"))));
		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redShip"))));
		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redSettler"))));
		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redPirateShip"))));
		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redCrew"))));
		place.getRed().add(
				new ImageButton(new TextureRegionDrawable(redAtlas
						.findRegion("redCircle"))));
	}

	public void startPositions() {
		for (int i = 0; i < place.getOrders().getCount(); i++) {
			if (place.getOrders().getCounter().get(i).getColor().equals("orange")) {
				place.getOrange().get(0).setBounds(posX, posY, 10, 15);
				place.getStage().addActor(place.getOrange().get(i));
				
			} 
			
			else if (place.getOrders().getCounter().get(i).getColor().equals("white")) {
				place.getWhite().get(0).setBounds(posX, posY, 10, 15);
				place.getStage().addActor(place.getWhite().get(i));
			}
			
			else if (place.getOrders().getCounter().get(i).getColor().equals("blue")) {
				place.getBlue().get(0).setBounds(posX, posY, 10, 15);
				place.getStage().addActor(place.getBlue().get(i));
			}
			
			else if (place.getOrders().getCounter().get(i).getColor().equals("red")) {
				place.getRed().get(0).setBounds(posX, posY, 10, 15);
				place.getStage().addActor(place.getRed().get(i));
			}
		}
	}
}
