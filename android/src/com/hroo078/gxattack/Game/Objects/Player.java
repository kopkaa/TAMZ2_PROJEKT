package com.hroo078.gxattack.Game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.Direction;
import com.hroo078.gxattack.Game.Interfaces.Type;

public class Player extends GameObject {

    public int lives;
    public boolean isAlive;
    private Bullet[] bullets = new Bullet[3];
    private static boolean shootsAlreadyFired = false;

    public Player(int width, int height) {
        super(width, height);
        lives = 3;
        isAlive = true;
        makeBullets();
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
        for (int i = 0; i < getBullets().length; i++) {
            getBullets()[i].update(dt);
        }
    }

    private void makeBullets() {
        for(int i = 0; i < getBullets().length; i++) {
            bullets[i] = new Bullet(10,10,Type.PLAYER);
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
                    for(int j=0; j < getBullets().length; j++) {
                        getBullets()[j].shoot((getPosX() + getWidth() / 2) - (getBullets()[j].getWidth() / 2 ), getPosY() + getHeight(), Direction.UP);
                        //GallaxyAttackGame.sound.playShootSound();
                    }
                }
            }
        }
    }

    public Bullet[] getBullets() {
        return bullets;
    }
}
