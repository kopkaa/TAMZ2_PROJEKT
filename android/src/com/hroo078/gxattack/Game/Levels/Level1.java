package com.hroo078.gxattack.Game.Levels;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.hroo078.gxattack.Game.Interfaces.Direction;
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
    private  Direction enemyDirection;

    public Level1() {
        isFinished = false;
        enemyDirection = Direction.RIGHT;
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

        for (int row = 0; row <= 5; row++) {
                Enemy e = new UFOenemy(80,70);
                e.setPosition(100*row, Gdx.graphics.getHeight() - e.getHeight()*4 );
                enemyList.add(e);
        }
    }


    public void updateEnemies(float dt) {
        ListIterator<Enemy> enemyShipListIterator = enemyList.listIterator();
        while (enemyShipListIterator.hasNext()) {
            Enemy enemy = enemyShipListIterator.next();
            checkDirection(enemy);

            if(enemyDirection == Direction.RIGHT) {
                enemy.setPosX(enemy.getPosX() + dt*75);
            }
            if(enemyDirection == Direction.LEFT) {
                enemy.setPosX(enemy.getPosX() - dt*75);
            }

            enemy.update(dt);
        }
    }

    public void checkDirection(Enemy enemy) {
        if(enemy.getPosX() >= Gdx.graphics.getWidth() - enemy.getWidth()) {
            enemyDirection = Direction.LEFT;
        } else if(enemy.getPosX() <= 0){
            enemyDirection = Direction.RIGHT;
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
        enemyList.clear();
    }
}
