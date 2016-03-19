package bullets;

import java.util.Arrays;
import java.util.HashSet;

import com.badlogic.gdx.graphics.Texture;

public class BulletFactory {

	public BulletFactory()
	{
		
	}
	
	public HashSet<Bullet> CreateBullet(String type, int x, int y, int level)
	{
		if(type.equals("default"))
		{
			return new HashSet<Bullet>(Arrays.asList(new DefaultBullet(new Texture("bullet/default.png"), x, y)));
		}
		else if(type.equals("red"))
		{
			return new HashSet<Bullet>(Arrays.asList(new RedBullet(new Texture("bullet/red/1.png"), x, y, level)));
		}
		else if(type.equals("green"))
		{
			if(level >= 1 && level < 4)
			{
				return new HashSet<Bullet>(Arrays.asList(
						new GreenBullet(new Texture("bullet/green/1.png"), x - 8, y, 1 +(int)(level/2))
								));
			}
			else if(level >= 4 && level < 7)
			{
				return new HashSet<Bullet>(Arrays.asList(
						new GreenBullet(new Texture("bullet/green/1.png"), x + 5, y, 1 + (int)(level/2)),
						new GreenBullet(new Texture("bullet/green/1.png"), x - 21, y, 1 + (int)(level/2))
								));
			}
			else if(level >= 7 && level < 10)
			{
				return new HashSet<Bullet>(Arrays.asList(
						new GreenBullet(new Texture("bullet/green/1.png"), x - 8, y, 1 + (int)(level/2)),
						new GreenBullet(new Texture("bullet/green/1.png"), x - 34, y, 1 + (int)(level/2)),
						new GreenBullet(new Texture("bullet/green/1.png"), x + 18, y, 1 + (int)(level/2))
								));
			}
			else
			{
				return new HashSet<Bullet>(Arrays.asList(
						new GreenBullet(new Texture("bullet/green/1.png"), x - 8, y, 1 + (int)(level/2)),
						new GreenBullet(new Texture("bullet/green/1.png"), x - 34, y, 1 + (int)(level/2)),
						new GreenBullet(new Texture("bullet/green/1.png"), x + 18, y, 1 + (int)(level/2)),
						new GreenBullet(new Texture("bullet/green/1.png"), x - 60, y, 1 + (int)(level/2)),
						new GreenBullet(new Texture("bullet/green/1.png"), x + 44, y, 1 + (int)(level/2))
								));
			}
		}
		else if(type.equals("blue"))
		{
			if(level <= 3)
			{
				return new HashSet<Bullet>(Arrays.asList(new BlueBullet(new Texture("bullet/blue/1.png"), new Texture("bullet/blue/1-hit.png"), x, y, 1 + (int)(level/4))));
			}
			else if(level <= 7)
			{
				return new HashSet<Bullet>(Arrays.asList(new BlueBullet(new Texture("bullet/blue/2.png"), new Texture("bullet/blue/2-hit.png"), x, y, 1 + (int)(level/4))));
			}
			else if(level <= 11)
			{
				return new HashSet<Bullet>(Arrays.asList(new BlueBullet(new Texture("bullet/blue/3.png"), new Texture("bullet/blue/3-hit.png"), x, y, 1 + (int)(level/4))));
			}
			else if(level <= 15)
			{
				return new HashSet<Bullet>(Arrays.asList(new BlueBullet(new Texture("bullet/blue/4.png"), new Texture("bullet/blue/4-hit.png"), x, y, 1 + (int)(level/4))));
			}
			else
			{
				return new HashSet<Bullet>(Arrays.asList(new BlueBullet(new Texture("bullet/blue/5.png"), new Texture("bullet/blue/5-hit.png"), x, y, 1 + (int)(level/4))));
			}
			
		}
		else
			return null;
	}
}
