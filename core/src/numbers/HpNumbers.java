package numbers;

import com.badlogic.gdx.graphics.Texture;

public class HpNumbers {

	private Texture[] hp;

	public HpNumbers()
	{
		hp = new Texture[] {
				new Texture("number/0.png"),
				new Texture("number/1.png"),
				new Texture("number/2.png"),
				new Texture("number/3.png"),
				new Texture("number/4.png"),
				new Texture("number/5.png"),
				new Texture("number/6.png"),
				new Texture("number/7.png"),
				new Texture("number/8.png"),
				new Texture("number/9.png"),
				new Texture("number/10.png")
		};
	}
	
	public Texture[] getHp()
	{
		return hp;
	}
}
