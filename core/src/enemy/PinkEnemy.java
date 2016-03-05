package enemy;

import com.badlogic.gdx.graphics.Texture;

public class PinkEnemy extends Enemy {

	public static final int SPEED = 3;
	public static final int HP = 2;

	public PinkEnemy(Texture texture, int posX, int posY) 
	{
		super(texture, posX, posY, HP);
	}

	@Override
	public void update()
	{
		updateCollisionBox(SPEED);
		posY -= SPEED;
	}
}
