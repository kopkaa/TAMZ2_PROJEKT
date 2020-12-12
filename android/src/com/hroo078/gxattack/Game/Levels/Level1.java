package com.hroo078.gxattack.Game.Levels;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.hroo078.gxattack.Game.Interfaces.ILevel;
import com.hroo078.gxattack.Game.Objects.Bullet;
import com.hroo078.gxattack.Game.Objects.Enemies.Enemy;
import com.hroo078.gxattack.Game.Objects.Enemies.UFOenemy;
import com.hroo078.gxattack.Game.Screens.AbstractScreen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Level1 implements Screen, ILevel {

    private boolean isFinished;

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

        for (int row = 0; row <= 4; row++) {
                Enemy e = new UFOenemy(50,50);
                e.setPosition(60*row, Gdx.graphics.getHeight()/2 - e.getHeight()*3 );
                enemyList.add(e);
        }
    }


    public void updateEnemies(float dt) {
        ListIterator<Enemy> enemyShipListIterator = enemyList.listIterator();
        while (enemyShipListIterator.hasNext()) {
            Enemy enemyShip = enemyShipListIterator.next();
            enemyShip.update(dt);
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
