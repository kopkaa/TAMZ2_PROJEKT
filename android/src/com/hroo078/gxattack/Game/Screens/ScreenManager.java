package com.hroo078.gxattack.Game.Screens;

import android.util.Log;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.hroo078.gxattack.Game.Interfaces.ScreenEnum;

public class ScreenManager {

    private Game game;

    public ScreenManager(Game game) {
        this.game = game;
    }

    public void showScreen(ScreenEnum screenEnum) {

        Screen currentScreen = game.getScreen();
        if (currentScreen != null) {
            currentScreen.dispose();
        }

        game.setScreen(screenEnum.getScreen());

    }


}
