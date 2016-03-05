package powerUps;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class PowerUp {

	protected int posX;
	protected int posY;

	private Texture texture;
	protected Rectangle collisionBox;
	
	private String type;

	private int height;

	public PowerUp(Texture texture, int posX, int posY, String type)
	{
		this.texture = texture;
		this.posX = posX;
		this.posY = posY;
		height = texture.getHeight();
		collisionBox = new Rectangle(posX, posY, texture.getWidth(), height);
		this.type = type;
	}
	
	public String getType()
	{
		return type;
	}

	public Texture getTexture()
	{
		return texture;
	}

	public Rectangle getCollisionBox()
	{
		return collisionBox;
	}

	public void updateCollisionBox(int speed)
	{
		collisionBox.setY(collisionBox.getY() - speed);
	}
	
	public int getX()
	{
		return posX;
	}
	
	public int getY()
	{
		return posY;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void dispose()
	{
		texture.dispose();
	}

	abstract public void update();
}
