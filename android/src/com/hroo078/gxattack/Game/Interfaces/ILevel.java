package com.hroo078.gxattack.Game.Interfaces;

import com.hroo078.gxattack.Game.Objects.Enemies.Enemy;

import java.util.ArrayList;
import java.util.LinkedList;

public interface ILevel {
    public ArrayList<Enemy> enemyList = new ArrayList<>();
    public void initLevel();
    public void update(float dt);
    public void createEnemies();
    public boolean isFinished();
    public void dispose();
}
