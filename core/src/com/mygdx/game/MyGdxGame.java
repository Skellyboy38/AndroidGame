package com.mygdx.game;

import Characters.Player;
import bullets.BulletFactory;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	public static final int WIDTH = 320;
	public static final int HEIGHT = 480;
	
	SpriteBatch batch;
	Player player;
	BulletFactory bulletFactory;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		bulletFactory = new BulletFactory();
		player = new Player(batch, bulletFactory);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		player.render();
		batch.end();
	}
}
