/**
 * The Bonus class provides information about how and when a bonus is added.
 * @author Lucy Tibbetts
 * February 21 2017
 * CPSC 224 Assignment 3
 */
public class GoldenSnitchBonus {
	private int bonusScore;
	private int bonusRule;
	
	/**
	 * constructor
	 * sets the bonus score and role using the appropriate functions
	 * @param myGame current instance of the Game class
	 */
	public GoldenSnitchBonus()
	{
		setBonusScore();
		setBonusRule();
	}
	
	/**
	 * sets the value that is added as a bonus
	 */
	public void setBonusScore()
	{
		bonusScore = 45;
	}
	
	/**
	 * returns the integer representing the value added as a bonus
	 * @return bonusScore: the integer representing the value added as a bonus
	 */
	public int getBonusScore()
	{
		return bonusScore;
	}
	
	/**
	 * sets the minimum value that must be reached for a bonus to be added
	 * @param myGame current instance of the Game class
	 */
	public void setBonusRule()
	{
		bonusRule = 200;
	}
	
	/**
	 * returns the minimum value that must be reached for a bonus to be added
	 * @return bonusRule: the minimum value that must be reached for a bonus to be added
	 */
	public int getBonusRule()
	{
		return bonusRule;
	}
}