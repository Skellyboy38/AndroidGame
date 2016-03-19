package Characters;

import java.util.ArrayList;
import java.util.Iterator;

import bullets.Bullet;
import bullets.BulletFactory;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.mygdx.game.MyGdxGame;

public class Player {

	public static final int LEFT_KEY = 21;
	public static final int RIGHT_KEY = 22;
	public static final int SPACE_KEY = 62;

	public static final int SPEED = 4;
	public static final int START_HEIGHT = 100;

	public static final float BULLET_DELAY = 0.1f;
	
	public static final Texture DEFAULT = new Texture("player/normal.png");
	public static final Texture RED = new Texture("player/red.png");
	public static final Texture GREEN = new Texture("player/green.png");
	public static final Texture BLUE = new Texture("player/blue.png");

	private boolean canSpawnBullet;
	private int level;

	private Texture texture;
	private SpriteBatch batch;
	private BulletFactory factory;
	private ArrayList<Bullet> bullets;
	private String bulletType;
	private Rectangle collisionBox;
	private boolean isDead;

	private int characterWidth;
	private int characterHeight;

	private int posX;
	private int posY;

	public Player(SpriteBatch batch, BulletFactory factory)
	{
		this.batch = batch;
		this.factory = factory;
		isDead = false;
		texture = DEFAULT;
		characterWidth = texture.getWidth();
		characterHeight = texture.getHeight();
		posX = MyGdxGame.WIDTH/2 - characterWidth/2;
		posY = START_HEIGHT;
		bullets = new ArrayList<Bullet>();
		bulletType = "default";
		canSpawnBullet = true;
		collisionBox = new Rectangle(posX, posY, characterWidth, characterHeight);
		level = 1;
	}

	public void update()
	{
		enableBullet();

		if(Gdx.input.isKeyPressed(LEFT_KEY) && posX > 0)
		{
			collisionBox.setX(collisionBox.getX() - SPEED);
			posX -= SPEED;
		}
		if(Gdx.input.isKeyPressed(RIGHT_KEY) && (posX + characterWidth) < MyGdxGame.WIDTH)
		{
			collisionBox.setX(collisionBox.getX() + SPEED);
			posX += SPEED;
		}
		if(Gdx.input.isKeyPressed(SPACE_KEY) && canSpawnBullet)
		{
			spawnBullet(posX + characterWidth/2, posY + characterHeight, bulletType);
			canSpawnBullet = false;
		}
	}
	
	public void levelUp()
	{
		level++;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public void resetLevel()
	{
		level = 1;
	}

	public void render()
	{
		update();
		batch.draw(texture, posX, posY);
		
		Iterator<Bullet> iter = bullets.iterator();
		while(iter.hasNext())
		{
			Bullet b = iter.next();
			b.update();
			if(b.getY() > MyGdxGame.HEIGHT || b.shouldKill())
			{
				b.dispose();
				iter.remove();
			}
			else
			{
				batch.draw(b.getTexture(), b.getX(), b.getY());
			}
		}
	}
	
	public boolean isDead()
	{
		return isDead;
	}
	
	public void kill()
	{
		isDead = true;
	}

	public void enableBullet()
	{
		if(!Gdx.input.isKeyPressed(SPACE_KEY))
		{
			canSpawnBullet = true;
		}
	}

	public void spawnBullet(int x, int y, String type)
	{
		bullets.addAll(factory.CreateBullet(type, x, y, level));
	}
	
	public ArrayList<Bullet> getBullets()
	{
		return bullets;
	}
	
	public Rectangle getCollisionBox()
	{
		return collisionBox;
	}
	
	public void dispose()
	{
		texture.dispose();
		for(Bullet b : bullets)
		{
			b.dispose();
		}
	}
	
	public void restart()
	{
		bullets.clear();
		posX = MyGdxGame.WIDTH/2 - characterWidth/2;
		posY = START_HEIGHT;
		collisionBox.setX(posX);
		collisionBox.setY(posY);
		texture = DEFAULT;
		isDead = false;
		bulletType = "default";
		level = 1;
	}
	
	public void powerUp(String type)
	{
		if(type.equals("red"))
		{
			if(!bulletType.equals(type))
			{
				texture = RED;
				resetLevel();
				this.bulletType = type;
			}
			else
				levelUp();
		}
		else if(type.equals("green"))
		{
			if(!bulletType.equals(type))
			{
				texture = GREEN;
				resetLevel();
				this.bulletType = type;
			}
			else
				levelUp();
		}
		else if(type.equals("blue"))
		{
			if(!bulletType.equals(type))
			{
				texture = BLUE;
				resetLevel();
				this.bulletType = type;
			}
			else
				levelUp();
		}
	}
}
