package com.hroo078.gxattack.Game.Objects;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.Direction;
import com.hroo078.gxattack.Game.Interfaces.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Player extends GameObject {

    public int lives;
    public boolean isAlive;
   List<Bullet> bullets = new ArrayList<Bullet>();
    private int bulletsActive;
    private static boolean shootsAlreadyFired = false;

    public Player(int width, int height) {
        super(width, height);
        lives = 3;
        isAlive = true;
    }

    private void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(objectTexture, getPosX(), getPosY(), width, height);
        batch.end();
    }

    @Override
    public void update(float dt) {
        draw(batch);
        checkInput();
        drawBullets(dt);
    }

    private void drawBullets(float dt) {
        ListIterator<Bullet> bullets = this.bullets.listIterator();
        while (bullets.hasNext()) {
            Bullet bull = bullets.next();
            bull.update(dt);
        }
    }


    public void checkInput() {
        int screenTouchedSt = 0;
        for (int i = 0; i < 3; i++) {
            if (Gdx.input.isTouched(i)) {
                screenTouchedSt++;
                if (Gdx.input.getY(i) > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 5) { // spodni cast obrazovky

                    if (Gdx.input.getX(i) > getPosX() ) {
                        setPosX(getPosX() + getSpeed());  // pohyb doprava
                    }

                    else if (Gdx.input.getX(i) < getPosX() ) {
                        setPosX(getPosX() - getSpeed());  // pohyb doleva
                    }
                }
                else {
                    Bullet bull = new Bullet(10,10, Type.PLAYER);
                    bull.setPosition(getPosX() + getWidth() / 2, getPosY());
                    bullets.add(bull);
                    GallaxyAttackGame.sound.playRockSound();
                }
            }
        }


    }

    public List<Bullet> getBullets() {
        return bullets;
    }
}
