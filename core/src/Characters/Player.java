package Characters;

import java.util.ArrayList;
import java.util.Iterator;

import bullets.Bullet;
import bullets.BulletFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Player {
	
	public static final int LEFT_KEY = 21;
	public static final int RIGHT_KEY = 22;
	
	public static final int SPEED = 3;
	public static final int START_HEIGHT = 100;
	
	public static final float BULLET_SPAWN_TIME = 0.5f;
	
	private Texture texture;
	private SpriteBatch batch;
	private BulletFactory factory;
	private ArrayList<Bullet> bullets;
	private String bulletType;
	
	private int characterWidth;
	private int characterHeight;
	
	private int posX;
	private int posY;
	
	public Player(SpriteBatch batch, BulletFactory factory)
	{
		this.batch = batch;
		this.factory = factory;
		texture = new Texture("player/normal.png");
		characterWidth = texture.getWidth();
		characterHeight = texture.getHeight();
		posX = MyGdxGame.WIDTH/2 - characterWidth/2;
		posY = START_HEIGHT;
		bullets = new ArrayList<Bullet>();
		bulletType = "default";
	}
	
	public void update()
	{
		if(Gdx.input.isKeyPressed(LEFT_KEY) && posX > 0)
		{
			posX -= SPEED;
		}
		if(Gdx.input.isKeyPressed(RIGHT_KEY) && (posX + characterWidth) < MyGdxGame.WIDTH)
		{
			posX += SPEED;
		}
		if(Gdx.input.isKeyPressed(LEFT_KEY) && Gdx.input.isKeyPressed(RIGHT_KEY))
		{
			spawnBullet(posX + characterWidth/2, posY + characterHeight);
		}
		
		Iterator<Bullet> iter = bullets.iterator();
		
		while(iter.hasNext())
		{
			Bullet b = iter.next();
			
			if(b.getY() > MyGdxGame.HEIGHT)
			{
				iter.remove();
			}
			else
			{
				b.update();
			}
		}
	}
	
	public void render()
	{
		update();
		batch.draw(texture, posX, posY);
		for(Bullet b : bullets)
		{
			batch.draw(b.getTexture(), b.getX(), b.getY());
		}
	}
	
	public void spawnBullet(int x, int y)
	{
		Bullet bullet = factory.CreateBullet(bulletType, x, y);
		
		bullets.add(bullet);
	}
}
