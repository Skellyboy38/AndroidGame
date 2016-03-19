package bullets;

import com.badlogic.gdx.graphics.Texture;

public class GreenBullet extends Bullet {
	
	public final static int SPEED = 5;

	public GreenBullet(Texture texture, int posX, int posY, int damage) {
		super(texture, posX, posY, damage);
	}

	@Override
	public void update() {
		posY += SPEED;
		updateCollisionBox(SPEED);
	}

}
