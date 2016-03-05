package powerUps;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

public class PowerUpFactory {
	
	private String[] types;
	private Random random;
	private String type;
	
	public PowerUpFactory()
	{
		types = new String[] {"green", "red", "blue"};
		random = new Random();
	}
	
	public PowerUp createPowerUp(int posX, int posY)
	{
		type = types[random.nextInt(3)];
		
		if(type.equals("red"))
		{
			return new RedBullet(new Texture("powers/red.png"), posX, posY);
		}
		else if(type.equals("blue"))
		{
			return new BlueBullet(new Texture("powers/blue.png"), posX, posY);
		}
		else if(type.equals("green"))
		{
			return new GreenBullet(new Texture("powers/green.png"), posX, posY);
		}
		else
			return null;
	}
}
