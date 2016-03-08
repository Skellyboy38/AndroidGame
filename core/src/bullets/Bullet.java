package bullets;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class Bullet {
	
	protected int posX;
	protected int posY;
	protected Rectangle collisionBox;
	
	private boolean kill;
	private Texture texture;
	private int damage;
	
	public Bullet(Texture texture, int posX, int posY, int damage)
	{
		this.texture = texture;
		this.posX = posX;
		this.posY = posY;
		kill = false;
		collisionBox = new Rectangle(posX, posY, texture.getWidth(), texture.getHeight());
		this.damage = damage;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public void kill()
	{
		kill = true;
	}
	
	public boolean shouldKill()
	{
		return kill;
	}
	
	public Texture getTexture()
	{
		return texture;
	}
	
	public int getX()
	{
		return posX;
	}
	
	public int getY()
	{
		return posY;
	}
	
	public void dispose()
	{
		texture.dispose();
	}
	
	public void updateCollisionBox(int speed)
	{
		collisionBox.setY(collisionBox.getY() + speed);
	}
	
	public Rectangle getCollisionBox()
	{
		return collisionBox;
	}
	
	abstract public void update();
}
