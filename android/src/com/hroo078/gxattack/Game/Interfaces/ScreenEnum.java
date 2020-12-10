package com.hroo078.gxattack.Game.Interfaces;

import com.hroo078.gxattack.Game.Screens.AboutScreen;
import com.hroo078.gxattack.Game.Screens.AbstractScreen;
import com.hroo078.gxattack.Game.Screens.GameScreen;
import com.hroo078.gxattack.Game.Screens.MenuScreen;

public enum ScreenEnum {

    MAIN_MENU {
        public AbstractScreen getScreen(Object... params) {
            return new MenuScreen();
        }
    },
    GAME {
        public AbstractScreen getScreen(Object... params) {
            return new GameScreen();
        }
    },
    ABOUT {
        public AbstractScreen getScreen(Object... params) {
            return new AboutScreen();
        }
    };

    public abstract AbstractScreen getScreen(Object... params);
}