package enemy;

import com.badlogic.gdx.graphics.Texture;

public class GreenEnemy extends Enemy{

	public static final int SPEED = 4;
	public static final int HP = 3;

	public GreenEnemy(Texture texture, int posX, int posY) 
	{
		super(texture, posX, posY, HP);
	}

	@Override
	public void update()
	{
		posY -= SPEED;
	}
}
