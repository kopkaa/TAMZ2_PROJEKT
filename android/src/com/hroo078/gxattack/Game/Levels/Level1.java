package com.hroo078.gxattack.Game.Levels;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.hroo078.gxattack.Game.Interfaces.ILevel;
import com.hroo078.gxattack.Game.Objects.Enemies.Enemy;
import com.hroo078.gxattack.Game.Objects.Enemies.UFOenemy;
import com.hroo078.gxattack.Game.Screens.AbstractScreen;

public class Level1 implements Screen, ILevel {

    private boolean isFinished;
    private Enemy[] enemies = new Enemy[5];

    public Level1() {
        isFinished = false;
    }
    @Override
    public void show() {

    }

    @Override
    public void initLevel() {
        createEnemies();
    }

    @Override
    public void createEnemies() {
        int numEnemies = 0;
        for (int row = 0; row <= 4; row++) {
                enemies[numEnemies] = new UFOenemy(50, 50);
                enemies[numEnemies].setPosition(60*row, Gdx.graphics.getHeight() - enemies[numEnemies].getHeight()*3 );
                numEnemies++;
        }
    }

    public void updateEnemies(float dt) {
        for(int i =0; i<= enemies.length-1; i++) {
            enemies[i].update(dt);
        }
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    @Override
    public void update(float dt) {
        updateEnemies(dt);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
