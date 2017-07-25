/**
 * The ScorecardLine class contains data fields indicating the line number, the
 * score for that line, the line type (e.g. "three of a kind") and whether or 
 * not the line has been set. 
 * @author Lucy Tibbetts
 * March 27 2017
 * CPSC 224 Assignment 4
 */
public class ScorecardLine {
	private boolean isSet;
	private int lineNum;
	private int score;
	private String lineType;
	
	/**
	 * constructor
	 * sets the value isSet to false
	 */
	public ScorecardLine()
	{
		isSet = false;	
	}

	/**
	 * returns a boolean representing whether or not the value of a scorecard line has been set
	 * @return isSet: boolean representing whether or not the value of a scorecard line has been set
	 */
	public boolean getIsSet() 
	{
		return isSet;
	}
	
	/**
	 * isSet is set to true, indicating that a scorecard line has been selected
	 */
	public void setIsSet()
	{
		isSet = true;
	}
	
	/**
	 * returns the number associated with a particular scorecard line
	 * @return lineNum: the number associated with a particular scorecard line
	 */
	public int getLineNum()
	{
		return lineNum;
	}
	
	/**
	 * sets the number of a scorecard line to a specified integer
	 * @param num the number of the scorecard line
	 */
	public void setLineNum(int num)
	{
		lineNum = num;
	}
	
	/**
	 * returns the score associated with a scorecard line
	 * @return score: the score associated with a scorecard line
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * sets the score of a particular scorecard line based on the line number
	 * @param myHand: current instance of the Hand class
	 */
	public void setScore(Hand myHand)
	{
		// upper scorecard
		if(lineNum <= 4)
		{
			int count = 0;
			for(int diePosition = 0; diePosition < myHand.getNumDice(); diePosition++)
			{ 
				if(myHand.getDice().get(diePosition).getHouse() == lineNum)
				count++;
			}
			if(lineNum == 1)
				score = 20 * count;
			else if(lineNum == 2)
				score = 15 * count;
			else if(lineNum == 3)
				score = 10 * count;
			else 
				score = 5 * count;
		}
		// lower scorecard
		else if(lineNum == 5)
			score = threeOfAKindScore(myHand);
		else if(lineNum == 6)
			score = fourOfAKindScore(myHand);
		else if(lineNum == 7)
			score = fullHouseScore(myHand);
		else if(lineNum == 8)
			score = SnapeScore(myHand);
		else if(lineNum == 9)
			score = McGonagallScore(myHand);
		else if(lineNum == 10)
			score = DumbledoresArmyScore(myHand);
		else if(lineNum == 11)
			score = yahtzeeScore(myHand);
	}
	
	/**
	 * returns the string associated with the type of score on a specific line
	 * @return lineType: string associated with the type of score on a specific line
	 * 					 e.g. "yahtzee"
	 */
	public String getLineType()
	{
		return lineType;
	}
	
	/**
	 * sets the type of line based on the line number
	 */
	public void setLineType()
	{
		if(lineNum == 1)
			lineType = "Gryffindor";
		else if(lineNum == 2) 
			lineType = "Ravenclaw";
		else if(lineNum == 3) 
			lineType = "Hufflepuff";
		else if(lineNum == 4) 
			lineType = "Slytherin";
		else if(lineNum == 5)
			lineType = "3 of a kind";
		else if(lineNum == 6)
			lineType = "4 of a kind";
		else if(lineNum == 7)
			lineType = "Full House";
		else if(lineNum == 8)
			lineType = "Snape";
		else if(lineNum == 9)
			lineType = "McGonagall";
		else if(lineNum == 10)
			lineType = "Dumbledore's Army";
		else if(lineNum == 11)
			lineType = "Yahtzee";
	}

	/**
	 * returns the score for the 3 of a kind line
	 * @return score for the 3 of a kind line
	 * @param myHand current instance of the Hand class
	 * @param myGame current instance of the Game class
	 */
	public int threeOfAKindScore(Hand myHand)
	{
		if(myHand.maxOfACharacterFound() >= 3)
			return myHand.totalOfAllDice();
		else
			return 0;
	}
	
	/**
	 * returns the score for the 4 of a kind line
	 * @return score for the 4 of a kind line
	 * @param myHand current instance of the Hand class
	 */
	public int fourOfAKindScore(Hand myHand)
	{
		if(myHand.maxOfACharacterFound() >= 4)
			return myHand.totalOfAllDice();
		else
			return 0;
	}
	
	/**
	 * returns the score for the full house line
	 * @return score for the full house line
	 * @param myHand current instance of the Hand class
	 */
	public int fullHouseScore(Hand myHand)
	{
		 boolean foundFullHouse = false;
		 boolean found4 = false;
		 boolean found3 = false;
		 int count;
		 int HouseValue = 0;
		 for (int k = 1; k <= 4; k++)
		 {
			 count = 0;
			 for (int i = 0; i < 7; i++)
			 {
				 if(myHand.getDice().get(i).getHouse() == k)
					 count++;
			 }
			 if(count >= 4)
			 {
				 found4 = true;
				 HouseValue = k;
			 }
			 else if(count >= 3 && k != HouseValue)
			 {
				 found3 = true;
			 } 
			 if(found4 && found3)
				 foundFullHouse = true;
		 }
		 if(foundFullHouse)
			 return 25;
	     else
	    	 return 0;
	}

	
	/**
	 * returns the score for the small straight line
	 * @return score for the small straight line
	 * @param myHand current instance of the Hand class
	 */
	public int SnapeScore(Hand myHand)
	{
		int countHouse = 0;
		for (int i = 0; i < myHand.getNumDice(); i++)// go through the hand
		{
			if (myHand.getDice().get(i).getHouse() == 4)// count how many slytherin characters
			{
				countHouse++;
			}
		}
		if (countHouse >= 4) // award points if 5 or more slytherin characters
			return 30;
		else 
			return 0;
	}
	
	/**
	 * returns the score for the large straight line
	 * @return score for the large straight line
	 * @param myHand current instance of the Hand class
	 */
	public int McGonagallScore(Hand myHand)
	{
		int countHouse = 0;
		for (int i = 0; i < myHand.getNumDice() ; i++)// go through the hand
		{
			if (myHand.getDice().get(i).getHouse() == 1)// count how many gryffindor characters 
			{
				countHouse++;
			}
		}
		if (countHouse >= 5) // award points if 6 or more gryffindor charactesr
			return 40;
		else 
			return 0;
	}

	/**
	 * returns score for the chance line
	 * @return score for the chance line
	 * @param myHand current instance of the Hand class
	 */
	public int DumbledoresArmyScore(Hand myHand)
	{
		return myHand.totalOfAllDice();
	}
	
	/**
	 * returns score for the Yahtzee line
	 * @return score for the Yahtzee line
	 * @param myHand current instance of the Hand class
	 */
	public int yahtzeeScore(Hand myHand)
	{
		if(myHand.maxOfAHouseFound() == 7)
			return 50;
		else 
			return 0;
	}
}