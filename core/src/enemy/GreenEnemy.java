package enemy;

import com.badlogic.gdx.graphics.Texture;

public class GreenEnemy extends Enemy{

	public static final int SPEED = 4;
	public static final int HP = 5;

	public GreenEnemy(Texture texture, Texture hit, int posX, int posY) 
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
