package enemy;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class EnemyFactory {
	
	private Random random;
	private int spawnLocationX;

	public EnemyFactory()
	{
		random = new Random();
	}
	
	public Enemy createEnemy(String type)
	{
		if(type.equals("pink"))
		{
			Texture pink = new Texture("enemy/pink.png");
			spawnLocationX = random.nextInt(MyGdxGame.WIDTH - pink.getWidth());
			return new PinkEnemy(new Texture("enemy/pink.png"), spawnLocationX, MyGdxGame.HEIGHT);
		}
		else
			return null;
	}
}
