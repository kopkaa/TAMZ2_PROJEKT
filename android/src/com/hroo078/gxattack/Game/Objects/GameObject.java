package com.hroo078.gxattack.Game.Objects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hroo078.gxattack.Game.UI.SpriteSheet;

public abstract class GameObject extends Sprite{
    protected SpriteBatch batch;
    protected TextureRegion objectTexture;
    protected int width, height;
    protected float posX, posY, speed;

    private SpriteSheet sheet = new SpriteSheet("sheet.xml");

    public GameObject(int width, int height) {
        batch = new SpriteBatch();
        this.width = width;
        this.height = height;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) { this.speed = speed; }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
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

    public void update(float dt){

    }

    public void setTexture(String name) {
        objectTexture = sheet.getSpriteRegion(name);
    }
}
