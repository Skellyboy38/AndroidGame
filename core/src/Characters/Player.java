package Characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

public class Player {
	
	public static final int LEFT_KEY = 21;
	public static final int RIGHT_KEY = 22;
	
	public static final int SPEED = 3;
	
	private Texture texture;
	private SpriteBatch batch;
	
	private int characterWidth;
	
	private int posX;
	private int posY;
	
	public Player(SpriteBatch batch)
	{
		this.batch = batch;
		texture = new Texture("player/normal.png");
		characterWidth = texture.getWidth();
		posX = MyGdxGame.WIDTH/2 - characterWidth/2;
		posY = 100;
	}
	
	public void update()
	{
		if(Gdx.input.isKeyPressed(LEFT_KEY) && posX > 0)
		{
			posX -= SPEED;
		}
		if(Gdx.input.isKeyPressed(RIGHT_KEY) && (posX + characterWidth) < MyGdxGame.WIDTH)
		{
			posX += SPEED;
		}
	}
	
	public void render()
	{
		update();
		batch.draw(texture, posX, posY);
	}
}
