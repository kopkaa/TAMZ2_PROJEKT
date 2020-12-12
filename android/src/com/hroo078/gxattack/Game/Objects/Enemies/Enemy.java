package com.hroo078.gxattack.Game.Objects.Enemies;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.Type;
import com.hroo078.gxattack.Game.Objects.Bullet;
import com.hroo078.gxattack.Game.Objects.GameObject;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends GameObject {
    List<Bullet> bullets = new ArrayList<Bullet>();

    public Enemy(float width, float height) {
        super(width, height);
    }

    public void shoot() {
        Bullet bull = new Bullet(10,10, Type.ENEMY);
        bull.setPosition(getPosX() + getWidth() / 2, getHeight());
        bullets.add(bull);
    }

    public void draw() {
        batch.begin();
        batch.draw(sheetTexture, getPosX(), getPosY(), width, height);
        batch.end();
    }

    public void enemyBulletCollision() {

    }

    @Override
    public void update(float dt) {
        draw();
    }
}
