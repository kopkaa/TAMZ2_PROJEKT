package com.hroo078.gxattack.Game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hroo078.gxattack.Game.UI.SpriteSheet;

public abstract class GameObject {
    protected Sprite sprite;
    protected TextureRegion objectTexture;
    protected int width, height;
    protected float posX, posY, speedX, speedY;

    private SpriteSheet sheet = new SpriteSheet("sheet.xml");

    public GameObject(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void moveBy(float dx, float dy) {
        setPosX(posX + dx);
        setPosY(posY + dy);
    }

    public void setTexture(String name) {
        objectTexture = sheet.getSpriteRegion(name);
    }
}
