package com.hroo078.gxattack.Game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class ScreenManager {

    private static ScreenManager instance;

    private Game game;

    private ScreenManager() {
        super();
    }

    public static ScreenManager getInstance() {
        if(instance == null) {
            new ScreenManager();
        }
        return instance;
    }

    public void init(Game game) {
        this.game = game;
    }

    public void showScreen(ScreenEnum screenEnum, Object... params) {
        
        Screen currentScreen = game.getScreen();

        AbstractScreen newScreen = screenEnum.getScreen(params);
        newScreen.buildStage();
        game.setScreen(newScreen);

        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }


}
