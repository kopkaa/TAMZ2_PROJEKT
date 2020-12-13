package com.hroo078.gxattack.Game.Objects;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.ScreenEnum;
import com.hroo078.gxattack.Game.Interfaces.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Player extends GameObject {

    public int lives;
    public List<Bullet> bullets = new ArrayList<Bullet>();
    private final float timeBetweenShots = 0.5f;
    private float timeSinceLastShot = 0;


    public Player(float width, float height) {
        super(width, height);
        lives = 3;
    }

    private void draw() {
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        batch.draw(objectTexture, getPosX(), getPosY(), width, height);
        batch.end();
    }

    @Override
    public void update(float dt) {
        if(lives <= 0) {
            GallaxyAttackGame.screenManager.showScreen(ScreenEnum.END);
        }
        draw();
        timeSinceLastShot += dt;
        checkInput();
        drawBullets(dt);
    }

    private void drawBullets(float dt) {
        ListIterator<Bullet> bullets = this.bullets.listIterator();
        while (bullets.hasNext()) {
            Bullet bull = bullets.next();
            bull.update(dt);

            if(bull.posY >= Gdx.graphics.getHeight()) {
                this.bullets.remove(bull);
                break;
            }
        }
    }


    public void checkInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            GallaxyAttackGame.soundManager.stopGameMusic();
            GallaxyAttackGame.screenManager.showScreen(ScreenEnum.MAIN_MENU);
        }
        for (int i = 0; i < 3; i++) {
            if (Gdx.input.isTouched(i)) {

                if (Gdx.input.getY(i) > Gdx.graphics.getHeight() - Gdx.graphics.getHeight() / 5) { // spodni cast obrazovky

                    if (Gdx.input.getX(i) > getPosX() && !(Gdx.input.getX(i) < Gdx.graphics.getWidth() / 2)) {
                        setPosX(getPosX() + getSpeed());  // pohyb doprava
                    }

                    else if (Gdx.input.getX(i) < getPosX() && !(Gdx.input.getX(i) > Gdx.graphics.getWidth() / 2) ) {
                        setPosX(getPosX() - getSpeed());  // pohyb doleva
                    }
                }
                else { // shoot
                    shoot();
                }
            }
        }
    }

    public void shoot() {
        if(canShoot()) {
            Bullet bull = new Bullet(10,10, Type.PLAYER);
            bull.setPosition(getPosX() + getWidth() / 2, getHeight());

            bullets.add(bull);
            GallaxyAttackGame.soundManager.playLaserSound();
            timeSinceLastShot = 0;
        }
    }

    public boolean canShoot() {
        return (timeSinceLastShot - timeBetweenShots >= 0 );
    }

}
