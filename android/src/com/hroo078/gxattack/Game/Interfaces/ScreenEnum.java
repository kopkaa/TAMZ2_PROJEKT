package com.hroo078.gxattack.Game.Interfaces;

import com.hroo078.gxattack.Game.Screens.AboutScreen;
import com.hroo078.gxattack.Game.Screens.AbstractScreen;
import com.hroo078.gxattack.Game.Screens.GameScreen;
import com.hroo078.gxattack.Game.Screens.MenuScreen;
import com.hroo078.gxattack.Game.Screens.ScoreScreen;

public enum ScreenEnum {

    MAIN_MENU {
        public AbstractScreen getScreen() {
            return new MenuScreen();
        }
    },
    GAME {
        public AbstractScreen getScreen() {
            return new GameScreen();
        }
    },
    SCORE {
      public AbstractScreen getScreen() {return new ScoreScreen(); }
    },
    ABOUT {
        public AbstractScreen getScreen() {
            return new AboutScreen();
        }
    };

    public abstract AbstractScreen getScreen();
}