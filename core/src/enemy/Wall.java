package enemy;

import com.badlogic.gdx.graphics.Texture;

public class Wall extends Enemy{
	
	public static final int SPEED = 2;
	public static final int HP = 9;
	public static final int POINTS = 1000;

	public Wall(Texture texture, Texture hit, int posX, int posY) 
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
