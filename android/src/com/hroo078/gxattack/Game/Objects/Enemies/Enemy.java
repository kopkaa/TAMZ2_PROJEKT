package com.hroo078.gxattack.Game.Objects.Enemies;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.hroo078.gxattack.Game.GallaxyAttackGame;
import com.hroo078.gxattack.Game.Interfaces.Type;
import com.hroo078.gxattack.Game.Objects.Bullet;
import com.hroo078.gxattack.Game.Objects.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public abstract class Enemy extends GameObject {
    public List<Bullet> bullets = new ArrayList<Bullet>();
    private int shootTimer = 0;
    private final float timeBetweenShots = 1.5f;
    private float timeSinceLastShot = 0;

    public Enemy(float width, float height) {
        super(width, height);
    }

    public void shoot() {
        if(canShoot()) {
            Bullet bull = new Bullet(10, 10, Type.ENEMY);
            bull.setPosition(getPosX() + getWidth() / 2, getPosY());
            bullets.add(bull);
            timeSinceLastShot = 0;
        }
    }

    private void drawBullets(float dt) {
        ListIterator<Bullet> bullets = this.bullets.listIterator();
        while (bullets.hasNext()) {
            Bullet bull = bullets.next();
            bull.update(dt);

            if(bull.getPosY() <= 0) {
                this.bullets.remove(bull);
                break;
            }
        }
    }

    public void draw() {
        batch.begin();
        batch.draw(sheetTexture, getPosX(), getPosY(), width, height);
        batch.end();
    }

    public boolean canShoot() {
        return (timeSinceLastShot - timeBetweenShots >= 0 );
    }

    @Override
    public void update(float dt) {
        shootTimer += dt*1000;
        Random r = new Random();
        int random  = r.nextInt(8000) + 30;
        if(random <= shootTimer) {
            shootTimer = 0;
            shoot();
        }
        drawBullets(dt);
        timeSinceLastShot += dt;
        draw();
    }

}
