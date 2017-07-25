/**
 * The Scorecard class contains an array of scorecardlines and functions
 * that allow the scorecard to be set and printed as needed.
 * @author Lucy Tibbetts
 * March 27 2017
 * CPSC 224 Assignment 4
 */
public class Scorecard {
	private ScorecardLine[] scorecardLines;
	private int numLines;

	/**
	 * constructor
	 * creates and fills an array of scorecard lines
	 * sets the line number and type of each scorecard line
	 * @param myGame current instance of the Game class
	 */
	public Scorecard() 
	{
		numLines = 11;
		scorecardLines = new ScorecardLine[numLines];
		for(int i = 0; i < numLines; i++)
		{
			scorecardLines[i] = new ScorecardLine();
			scorecardLines[i].setLineNum(i + 1);
			scorecardLines[i].setLineType();
		}
	}
	
	/**
	 * @return scorecardLines: array of scorecard lines
	 */
	public ScorecardLine[] getScorecard()
	{
		return scorecardLines;
	}
	
	/**
	 * @return numLines: the number of lines in a scorecard
	 */
	public int getNumLines()
	{
		return numLines;
	}

	/**
	 * sets the score of all empty scorecard lines
	 * @param myHand current instance of the Hand class
	 * @param myGame current instance of the Game class
	 */
	public void setScorecard(Hand myHand)
	{
		for(int i = 0; i < scorecardLines.length; i++)
		{
			if(!scorecardLines[i].getIsSet())
			{
				scorecardLines[i].setScore(myHand);
			}
		}
	}
}