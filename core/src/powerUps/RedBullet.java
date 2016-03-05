package powerUps;

import com.badlogic.gdx.graphics.Texture;

public class RedBullet extends PowerUp {
	
	public static final int SPEED = 1;

	public RedBullet(Texture texture, int posX, int posY) 
	{
		super(texture, posX, posY, "red");
	}

	@Override
	public void update()
	{
		updateCollisionBox(SPEED);
		posY -= SPEED;
	}
}
