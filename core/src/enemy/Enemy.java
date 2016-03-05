package enemy;

import com.badlogic.gdx.graphics.Texture;

public abstract class Enemy {
	protected int posX;
	protected int posY;
	
	private Texture texture;
	private int hp;
	
	public Enemy(Texture texture, int posX, int posY, int hp)
	{
		this.texture = texture;
		this.posX = posX;
		this.posY = posY;
		this.hp = hp;
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
	
	public void hit()
	{
		hp--;
	}
	
	public boolean isDead()
	{
		return hp == 0;
	}
	
	abstract public void update();
}
