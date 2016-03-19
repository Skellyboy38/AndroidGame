package powerUps;

import com.badlogic.gdx.graphics.Texture;

public class RedPowerUp extends PowerUp {
	
	public static final int SPEED = 2;

	public RedPowerUp(Texture texture, int posX, int posY) 
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
