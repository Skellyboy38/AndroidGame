package enemy;

import com.badlogic.gdx.graphics.Texture;

public class PinkEnemy extends Enemy {

	public static final int SPEED = 5;
	public static final int HP = 3;
	public static final int POINTS = 150;

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
	
	@Override
	public int getPoints()
	{
		return POINTS;
	}
}
