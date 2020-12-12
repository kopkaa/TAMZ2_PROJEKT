package com.hroo078.gxattack.Game.Objects;

import android.support.constraint.solver.widgets.Rectangle;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.hroo078.gxattack.Game.UI.SpriteSheet;

public abstract class GameObject extends Sprite{

    protected SpriteBatch batch;
    protected TextureRegion sheetTexture;
    protected Texture objectTexture;
    protected float  width, height, posX, posY, speed;

    private SpriteSheet sheet = new SpriteSheet("sheet.xml");

    public GameObject(float width, float height) {
        super.setSize(width,height);
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
        super.setPosition(posX,getPosY());
    }

    public void setPosY(float posY) {
        this.posY = posY;
        super.setPosition(getPosX(), posY);
    }

    public void setPosition(float posX, float posY) {
        super.setPosition(posX,posY);
        this.posX = posX;
        this.posY = posY;
    }

    public void moveBy(float dx, float dy) {
        setPosX(posX + dx);
        setPosY(posY + dy);
    }

    public void update(float dt){

    }

    public void setTexture(String name, boolean isSheetTexture) {
        if(isSheetTexture) {
            sheetTexture = sheet.getSpriteRegion(name);
        } else {
            objectTexture = new Texture(name);
        }

    }
}
