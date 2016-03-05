package enemy;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class EnemyFactory {
	
	private Random random;
	private int spawnLocationX;
	private String type;
	public static final String[] TYPES = {"pink", "green"};

	public EnemyFactory()
	{
		random = new Random();
	}
	
	public Enemy createEnemy()
	{
		type = TYPES[random.nextInt(TYPES.length)];
		
		if(type.equals("pink"))
		{
			Texture pink = new Texture("enemy/pink.png");
			spawnLocationX = random.nextInt(MyGdxGame.WIDTH - pink.getWidth());
			return new PinkEnemy(pink, spawnLocationX, MyGdxGame.HEIGHT);
		}
		else if(type.equals("green"))
		{
			Texture green = new Texture("enemy/green.png");
			spawnLocationX = random.nextInt(MyGdxGame.WIDTH - green.getWidth());
			return new GreenEnemy(green, spawnLocationX, MyGdxGame.HEIGHT);
		}
		else
			return null;
	}
}
