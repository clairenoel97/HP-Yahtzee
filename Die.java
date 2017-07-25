

import java.util.Random;

/**
 * The Die class contains data fields representing the numerical value of the die
 * and whether or not the die is selected by the player. The class also provides
 * accessors and mutators for these fields.
 * @author Lucy Tibbetts
 * March 27 2017
 * CPSC 224 Assignment 4
 */
public class Die {
	
	/**
	 * 1 = Harry Potter
	 * 2 = Hermione Granger
	 * 3 = Ron Weasley
	 * 4 = Luna Lovegood
	 * 5 = Cho Chang
	 * 6 = Gilderoy Lockhart
	 * 7 = Cedric Diggory
	 * 8 = Nymphadora Tonks
	 * 9 = Pomona Sprout
	 * 10 = Draco Malfoy
	 * 11 = Vincent Crabbe
	 * 12 = Gregory Goyle
	 */
	private int character;
	
	private boolean isKept;
	
	/**
	 * 1 = Gryffindor
	 * 2 = Ravenclaw
	 * 3 = Hufflepuff
	 * 4 = Slytherin
	 */
	private int hogwartsHouse;
	
	private int numSides = 12;
	
	/**
	 * constructor
	 * the die is rolled by calling the appropriate function and isKept is set to false
	 * @param myGame current instance of the Game class
	 */
	public Die() 
	{
		rollDie();
		isKept = false;
		setHouse();
	}

	/**
	 * rolls the die, setting sideOnTop to a random integer
	 * @param myGame current instance of the Game class
	 */
	public void rollDie()
	{
		Random num = new Random();
		character = num.nextInt(numSides) + 1;
		setHouse();
	}
	
	public void setHouse()
	{
		if(character <= 3)
			hogwartsHouse = 1; // Gryffindor
		else if(character <= 6)
			hogwartsHouse = 2; // Ravenclaw
		else if(character <= 9)
			hogwartsHouse = 3; // HufflePuff
		else
			hogwartsHouse = 4; // Slytherin
	}
	
	public int getHouse()
	{
		return hogwartsHouse;
	}
	
	/**
	 * sets isKept to true
	 */
	public void setIsKeptTrue()
	{
		isKept = true;
	}
	
	/**
	 * sets isKept to false
	 */
	public void setIsKeptFalse()
	{
		isKept = false;
	}
	
	/**
	 * returns the integer representing the die's value
	 * @return sideOnTop: the integer representing the die's value
	 */
	public int getCharacter()
	{
		return character;
	}
	
	/**
	 * returns true if die is kept or false if die is not kept
	 * @return isKept: true if die is kept or false if die is not kept
	 */
	public boolean getIsKept()
	{
		return isKept;
	}
}