package com.hroo078.gxattack.Game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends GameObject {

    private SpriteBatch batch;
    public int lives;
    public boolean isAlive;
    private static boolean shootsAlreadyFired = false;

    public Player(int width, int height) {
        super(width, height);
        batch = new SpriteBatch();
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
            }
        }
    }
}
