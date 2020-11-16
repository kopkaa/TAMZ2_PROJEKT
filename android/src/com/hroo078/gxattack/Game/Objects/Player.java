package com.hroo078.gxattack.Game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Player extends GameObject{

    public Player(int width, int height) {
        super(width, height);
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        batch.draw(objectTexture, 50, 50, 30, 30);
        batch.end();
    }
}
