package bullets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlueBullet extends Bullet {
	
	public final static int SPEED = 1;
	public final static int HIT_DELAY = 1;
	private float elapsedTime;
	private boolean canHit;
	private Texture texture;

	public BlueBullet(Texture texture, Texture hitTexture, int posX, int posY, int damage) {
		super(texture, posX, posY, damage);
		canHit = false;
		this.texture = hitTexture;
	}
	
	@Override
	public Texture getTexture()
	{
		if(elapsedTime > HIT_DELAY)
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
		if(elapsedTime > HIT_DELAY)
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
