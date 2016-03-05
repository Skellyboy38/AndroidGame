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
	
	public boolean isGameOver()
	{
		return gameOver;
	}
	
	public void reset()
	{
		gameOver = false;
	}
}
