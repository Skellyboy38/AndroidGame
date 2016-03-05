package enemy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Enemy {
	protected int posX;
	protected int posY;
	
	private Texture texture;
	private int hp;
	protected Rectangle collisionBox;
	
	private int height;
	
	public Enemy(Texture texture, int posX, int posY, int hp)
	{
		this.texture = texture;
		this.posX = posX;
		this.posY = posY;
		this.hp = hp;
		height = texture.getHeight();
		collisionBox = new Rectangle(posX, posY, texture.getWidth(), height);
	}
	
	public Texture getTexture()
	{
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
		hp--;
	}
	
	public boolean isDead()
	{
		return hp == 0;
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
		collisionBox.setHeight(collisionBox.getHeight() - speed);
	}
	
	abstract public void update();
}
