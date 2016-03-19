package powerUps;

import com.badlogic.gdx.graphics.Texture;

public class BluePowerUp extends PowerUp {

	public static final int SPEED = 2;

	public BluePowerUp(Texture texture, int posX, int posY) 
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
