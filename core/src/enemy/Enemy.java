package enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Enemy {
	protected int posX;
	protected int posY;
	protected boolean isHit;

	private Texture texture;
	private Texture hit;
	private int hp;
	protected Rectangle collisionBox;

	private int height;

	public Enemy(Texture texture, Texture hit, int posX, int posY, int hp)
	{
		isHit = false;
		this.texture = texture;
		this.hit = hit;
		this.posX = posX;
		this.posY = posY;
		this.hp = hp;
		height = texture.getHeight();
		collisionBox = new Rectangle(posX, posY, texture.getWidth(), height);
	}

	public Texture getTexture()
	{
		if(isHit)
		{
			isHit = false;
			return hit;
		}
		else
			return texture;
	}

	public Rectangle getCollisionBox()
	{
		return collisionBox;
	}

	public int getX()
	{
		return posX;
	}

	public int getY()
	{
		return posY;
	}

	public void hit()
	{
		isHit = true;
		if(hp > 0)
		{
			hp--;
		}
	}

	public boolean isDead()
	{
		return hp == 0;
	}
	
	public int getHp()
	{
		return hp;
	}

	public int getHeight()
	{
		return height;
	}

	public void dispose()
	{
		texture.dispose();
	}

	public void updateCollisionBox(int speed)
	{
		collisionBox.setY(collisionBox.getY() - speed);
	}

	abstract public void update();
	abstract public int getPoints();
}
