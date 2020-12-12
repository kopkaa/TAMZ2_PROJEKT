package com.hroo078.gxattack.Game.Interfaces;

public interface ILevel {
    public void initLevel();
    public void update(float dt);
    public void createEnemies();
    public boolean isFinished();
}
