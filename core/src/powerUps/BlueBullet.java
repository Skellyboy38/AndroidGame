package powerUps;

import com.badlogic.gdx.graphics.Texture;

public class BlueBullet extends PowerUp {

	public static final int SPEED = 1;

	public BlueBullet(Texture texture, int posX, int posY) 
	{
		super(texture, posX, posY, "blue");
	}

	@Override
	public void update()
	{
		updateCollisionBox(SPEED);
		posY -= SPEED;
	}
}
