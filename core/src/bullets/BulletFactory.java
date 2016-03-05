package bullets;

import com.badlogic.gdx.graphics.Texture;

public class BulletFactory {

	public BulletFactory()
	{
		
	}
	
	public Bullet CreateBullet(String type, int x, int y)
	{
		if(type.equals("default"))
		{
			return new DefaultBullet(new Texture("bullet/default.png"), x, y);
		}
		else
			return null;
	}
}
