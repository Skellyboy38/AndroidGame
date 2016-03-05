package collisionDetection;

import java.util.ArrayList;

import com.badlogic.gdx.math.Intersector;

import bullets.Bullet;
import enemy.Enemy;
import Characters.Player;

public class CollisionDetector {

	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Bullet> bullets;

	private boolean gameOver;

	public CollisionDetector(Player player, ArrayList<Enemy> enemies)
	{
		this.player = player;
		this.enemies = enemies;
		this.bullets = player.getBullets();

		gameOver = false;
	}

	public void update()
	{
		characterCollision();
		bulletCollisions();
	}

	public void characterCollision()
	{
		for(Enemy e : enemies)
		{
			if(Intersector.overlaps(player.getCollisionBox(), e.getCollisionBox()))
			{
				gameOver = true;
			}
		}
	}

	public void bulletCollisions()
	{
		for(Bullet b : bullets)
		{
			for(Enemy e : enemies)
			{
				if(Intersector.overlaps(b.getCollisionBox(), e.getCollisionBox()))
				{
					b.kill();
					e.hit();
				}
			}
		}
	}

	public boolean isGameOver()
	{
		return gameOver;
	}

	public void reset()
	{
		gameOver = false;
	}
}
