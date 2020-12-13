package com.hroo078.gxattack.Game.UI;

import com.badlogic.gdx.math.Rectangle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ExplosionAnimation {
    private Animation<TextureRegion> explosionAnimation;
    private float explosionTimer;

    private Rectangle boundingBox;

    public ExplosionAnimation(Texture texture, Rectangle boundingBox, float totalAnimationTime) {
        this.boundingBox = boundingBox;


        TextureRegion[][] textureRegion2D = TextureRegion.split(texture, 64, 64);


        TextureRegion[] textureRegion1D = new TextureRegion[16];
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                textureRegion1D[index] = textureRegion2D[i][j];
                index++;
            }
        }

        explosionAnimation = new Animation<TextureRegion>(totalAnimationTime/16, textureRegion1D);
        explosionTimer = 0;
    }

    public void update(float deltaTime) {
        explosionTimer += deltaTime;
    }

    public void draw (SpriteBatch batch) {
        batch.begin();
        batch.draw(explosionAnimation.getKeyFrame(explosionTimer),
                boundingBox.x,
                boundingBox.y,
                boundingBox.width,
                boundingBox.height);
        batch.end();
    }

    public boolean isFinished() {
        return explosionAnimation.isAnimationFinished(explosionTimer);
    }
}
