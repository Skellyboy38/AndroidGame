package score;

public class Score {
	
	private int score;
	private String scoreString;
	
	public Score()
	{
		score = 0;
		scoreString = "Score: 0";
	}
	
	public void increaseScore(int value)
	{
		score += value;
		scoreString = "Score: " + score;
	}
	
	public String getScore()
	{
		return scoreString;
	}
	
	public void restart()
	{
		score = 0;
		scoreString = "Score: 0";
	}
}
