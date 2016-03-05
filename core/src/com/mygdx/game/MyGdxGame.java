package com.mygdx.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import powerUps.PowerUp;
import powerUps.PowerUpFactory;
import score.Score;
import numbers.HpNumbers;
import Characters.Player;
import bullets.BulletFactory;
import collisionDetection.CollisionDetector;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import enemy.Enemy;
import enemy.EnemyFactory;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 320;
	public static final int HEIGHT = 560;
	public static final int SPAWN_DELAY = 1;
	public static final double POWER_UP_CHANCE = 0.5;

	float elapsedTime;
	boolean canSpawnEnemy;
	HpNumbers hp;
	Random random;
	double powerUpChance;

	SpriteBatch batch;
	BitmapFont font;
	Player player;
	BulletFactory bulletFactory;
	EnemyFactory enemyFactory;
	PowerUpFactory powerUpFactory;
	
	CollisionDetector collisions;
	Score score;

	ArrayList<Enemy> enemies;
	ArrayList<PowerUp> powerUps;

	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.setColor(1,1,1,1);
		font.setScale(2);
		random = new Random();
		
		bulletFactory = new BulletFactory();
		enemyFactory = new EnemyFactory();
		powerUpFactory = new PowerUpFactory();
		
		player = new Player(batch, bulletFactory);
		enemies = new ArrayList<Enemy>();
		powerUps = new ArrayList<PowerUp>();
		score = new Score();
		collisions = new CollisionDetector(player, enemies, powerUps);
		hp = new HpNumbers();

		canSpawnEnemy = true;
		elapsedTime = 0f;
	}

	@Override
	public void render () {
		batch.begin();
		if(!player.isDead())
		{
			Gdx.gl.glClearColor(1, 1, 1, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

			collisions.update();

			spawnEnemy();

			player.render();

			Iterator<Enemy> iter = enemies.iterator();
			while(iter.hasNext())
			{
				Enemy e = iter.next();
				e.update();
				if(e.getY() < (-1)*e.getHeight())
				{
					e.dispose();
					iter.remove();
				}
				else if(e.isDead())
				{
					spawnPowerUp(e.getX(), e.getY());
					e.dispose();
					iter.remove();
					score.increaseScore(e.getPoints());
				}
				else
				{
					batch.draw(e.getTexture(), e.getX(), e.getY());
					batch.draw(hp.getHp()[e.getHp()], e.getX(), e.getY());
				}
			}
			
			Iterator<PowerUp> iter2 = powerUps.iterator();
			while(iter2.hasNext())
			{
				PowerUp p = iter2.next();
				p.update();
				if(p.getY() < (-1)*p.getHeight())
				{
					p.dispose();
					iter2.remove();
				}
				else 
				{
					batch.draw(p.getTexture(), p.getX(), p.getY());
				}
			}

			font.draw(batch, score.getScore(), 10, 540);
		}
		else
		{
			endGame();
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
	
	public void spawnPowerUp(int posX, int posY)
	{
		powerUpChance = random.nextDouble();
		if(powerUpChance > POWER_UP_CHANCE)
		{
			powerUps.add(powerUpFactory.createPowerUp(posX, posY));
		}
	}

	public void endGame()
	{
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		font.draw(batch, "Game over", 10, 420);
		font.draw(batch, score.getScore(), 10, 380);
		font.draw(batch, "Play again? (enter)", 10, 340);
		
		if(Gdx.input.isKeyPressed(66))
		{
			restart();
		}
	}
	
	public void restart()
	{
		score.restart();
		player.restart();
		enemies.clear();
		powerUps.clear();
	}
}
