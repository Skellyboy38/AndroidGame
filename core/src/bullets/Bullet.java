package bullets;

import com.badlogic.gdx.graphics.Texture;

public abstract class Bullet {
	
	protected int posX;
	protected int posY;
	
	private Texture texture;
	
	public Bullet(Texture texture, int posX, int posY)
	{
		this.texture = texture;
		this.posX = posX;
		this.posY = posY;
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
	
	abstract public void update();
}
