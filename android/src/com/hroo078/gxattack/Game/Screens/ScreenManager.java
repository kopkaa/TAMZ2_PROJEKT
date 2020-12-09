package com.hroo078.gxattack.Game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager {

    private static ScreenManager instance;

    private Game game;

    public ScreenManager(Game game) {
        super();
        this.game = game;
    }


    public void init(Game game) {
        this.game = game;
    }

    public void showScreen(ScreenEnum screenEnum) {

        Screen currentScreen = game.getScreen();
        game.setScreen(screenEnum.getScreen());

        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }


}
