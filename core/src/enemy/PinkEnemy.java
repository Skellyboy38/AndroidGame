package enemy;

import com.badlogic.gdx.graphics.Texture;

public class PinkEnemy extends Enemy {

	public static final int SPEED = 3;
	public static final int HP = 8;

	public PinkEnemy(Texture texture, Texture hit, int posX, int posY) 
	{
		super(texture, hit, posX, posY, HP);
	}

	@Override
	public void update()
	{
		updateCollisionBox(SPEED);
		posY -= SPEED;
	}
}
