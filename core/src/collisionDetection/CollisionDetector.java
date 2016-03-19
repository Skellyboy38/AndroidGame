package collisionDetection;

import java.util.ArrayList;

import powerUps.PowerUp;

import com.badlogic.gdx.math.Intersector;

import bullets.Bullet;
import enemy.Enemy;
import Characters.Player;

public class CollisionDetector {

	private Player player;
	private ArrayList<Enemy> enemies;
	private ArrayList<Bullet> bullets;
	private ArrayList<PowerUp> powerUps;

	public CollisionDetector(Player player, ArrayList<Enemy> enemies, ArrayList<PowerUp> powerUps)
	{
		this.player = player;
		this.enemies = enemies;
		this.bullets = player.getBullets();
		this.powerUps = powerUps;
	}

	public void update()
	{
		characterCollision();
		bulletCollisions();
		powerUpCollisions();
	}
	
	public void powerUpCollisions()
	{
		for(PowerUp p : powerUps)
		{
			if(Intersector.overlaps(p.getCollisionBox(), player.getCollisionBox()))
			{
				player.powerUp(p.getType());
				p.kill();
			}
		}
	}

	public void characterCollision()
	{
		for(Enemy e : enemies)
		{
			if(Intersector.overlaps(player.getCollisionBox(), e.getCollisionBox()))
			{
				player.kill();
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
					e.hit(b.getDamage());
				}
			}
		}
	}
}
