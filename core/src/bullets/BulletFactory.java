package bullets;

import com.badlogic.gdx.graphics.Texture;

public class BulletFactory {

	public BulletFactory()
	{
		
	}
	
	public Bullet CreateBullet(String type, int x, int y, int level)
	{
		if(type.equals("default"))
		{
			return new DefaultBullet(new Texture("bullet/default.png"), x, y);
		}
		else if(type.equals("red"))
		{
			return new RedBullet(new Texture("bullet/red/1.png"), x, y, level);
		}
		else
			return null;
	}
}
