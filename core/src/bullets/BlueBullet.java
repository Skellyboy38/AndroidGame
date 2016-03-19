package bullets;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlueBullet extends Bullet {
	
	public final static int SPEED = 1;
	public final static int HIT_DELAY = 1;
	private boolean canHit;
	private float elapsedTime;

	public BlueBullet(Texture texture, int posX, int posY, int damage) {
		super(texture, posX, posY, damage);
		canHit = true;
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
			return true;
		}
		else
			return false;
	}

}
