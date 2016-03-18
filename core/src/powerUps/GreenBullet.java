package powerUps;

import com.badlogic.gdx.graphics.Texture;

public class GreenBullet extends PowerUp {

	public static final int SPEED = 2;

	public GreenBullet(Texture texture, int posX, int posY) 
	{
		super(texture, posX, posY, "green");
	}

	@Override
	public void update()
	{
		updateCollisionBox(SPEED);
		posY -= SPEED;
	}
}
