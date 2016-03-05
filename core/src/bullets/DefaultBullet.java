package bullets;

import com.badlogic.gdx.graphics.Texture;

public class DefaultBullet extends Bullet {
	
	public static final int SPEED = 3;
	
	public DefaultBullet(Texture texture, int posX, int posY) 
	{
		super(texture, posX, posY);
	}
	
	@Override
	public void update()
	{
		posY += SPEED;
		updateCollisionBox(SPEED);
	}
	
}
