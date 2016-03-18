package enemy;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.MyGdxGame;

public class EnemyFactory {
	
	private Random random;
	private int spawnLocationX;
	private int firstWallSpawnX, secondWallSpawnX;
	public static final int WALL_GAP = 60;
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
			return new PinkEnemy(pink, new Texture("enemy/pink_hit.png"), spawnLocationX, MyGdxGame.HEIGHT);
		}
		else if(type.equals("green"))
		{
			Texture green = new Texture("enemy/green.png");
			spawnLocationX = random.nextInt(MyGdxGame.WIDTH - green.getWidth());
			return new GreenEnemy(green, new Texture("enemy/green_hit.png"), spawnLocationX, MyGdxGame.HEIGHT);
		}
		else
			return null;
	}
	
	public Enemy[] createWall()
	{
		Texture wall = new Texture("enemy/wall.png");
		firstWallSpawnX = random.nextInt(MyGdxGame.WIDTH - WALL_GAP) - wall.getWidth();
		secondWallSpawnX = firstWallSpawnX + WALL_GAP + wall.getWidth();
		return new Enemy[] {new Wall(new Texture("enemy/wall.png"), new Texture("enemy/wall_hit.png"), firstWallSpawnX, MyGdxGame.HEIGHT), new Wall(wall, new Texture("enemy/wall_hit.png"), secondWallSpawnX, MyGdxGame.HEIGHT) };
	}
}
