package com.hroo078.gxattack.Game.Screens;

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