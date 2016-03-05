package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;

import Characters.Player;
import bullets.BulletFactory;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import enemy.Enemy;
import enemy.EnemyFactory;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 320;
	public static final int HEIGHT = 560;
	public static final int SPAWN_DELAY = 2;

	float elapsedTime;
	boolean canSpawnEnemy;
	
	SpriteBatch batch;
	Player player;
	BulletFactory bulletFactory;
	EnemyFactory enemyFactory;
	
	ArrayList<Enemy> enemies;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bulletFactory = new BulletFactory();
		enemyFactory = new EnemyFactory();
		player = new Player(batch, bulletFactory);
		enemies = new ArrayList<Enemy>();
		
		canSpawnEnemy = true;
		elapsedTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		spawnEnemy();
		
		batch.begin();
		player.render();
		
		Iterator<Enemy> iter = enemies.iterator();
		while(iter.hasNext())
		{
			Enemy e = iter.next();
			e.update();
			if(e.getY() < (-1)*e.getHeight())
			{
				iter.remove();
			}
			else
			{
				batch.draw(e.getTexture(), e.getX(), e.getY());
			}
		}
		
		batch.end();
	}
	
	public void spawnEnemy()
	{
		elapsedTime += Gdx.graphics.getDeltaTime();
		if(elapsedTime >= SPAWN_DELAY)
		{
			Enemy e = enemyFactory.createEnemy();
			enemies.add(e);
			elapsedTime = 0;
		}
	}
}
