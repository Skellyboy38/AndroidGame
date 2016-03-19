package bullets;

import com.badlogic.gdx.graphics.Texture;

public class RedBullet extends Bullet {
	
	public final static int SPEED = 4;

	public RedBullet(Texture texture, int posX, int posY, int damage) {
		super(texture, posX, posY, damage);
	}

	@Override
	public void update() {
		posY += SPEED;
		updateCollisionBox(SPEED);
	}
	
	@Override
	public boolean canHit() {
		return true;
	}
}
