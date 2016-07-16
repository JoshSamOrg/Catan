package com.catan.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.catan.CatanGame;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                return new GwtApplicationConfiguration(700, 700); //was 480,320 AND 650, 550
        }

        @Override
        public ApplicationListener getApplicationListener () {
                return new CatanGame();
        }
}