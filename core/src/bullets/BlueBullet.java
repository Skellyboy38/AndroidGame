package bullets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlueBullet extends Bullet {
	
	public final static int SPEED = 1;
	public float hitDelay;
	private float elapsedTime;
	private boolean canHit;
	private Texture texture;

	public BlueBullet(Texture texture, Texture hitTexture, int posX, int posY, int damage, float hitDelay) {
		super(texture, posX, posY, damage);
		canHit = false;
		this.texture = hitTexture;
		this.hitDelay = hitDelay;
	}
	
	@Override
	public Texture getTexture()
	{
		if(elapsedTime > hitDelay)
		{
			return this.texture;
		}
		else
		{
			return super.getTexture();
		}
	}

	@Override
	public void update() {
		posY += SPEED;
		updateCollisionBox(SPEED);
		elapsedTime += Gdx.graphics.getDeltaTime();
	}
	
	public boolean canHit()
	{
		if(elapsedTime > hitDelay)
		{
			elapsedTime = 0;
			canHit = true;
			return true;
		}
		else
		{
			canHit = false;
			return false;
		}
	}

}
