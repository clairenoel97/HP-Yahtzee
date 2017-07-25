import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * The Hand class contains an array list of dice and functions that
 * interact with and provide information about the hand.
 * @author Lucy Tibbetts
 * March 27 2017
 * CPSC 224 Assignment 4
 */
public class Hand {
	private ArrayList<Die> dice = new ArrayList<>();
	private int numDice = 7;
	private int numTurnsLeft = 3;
	
	/**
	 * constructor
	 * new dice are added to the hand
	 */
	public Hand() {
		for(int i = 0; i < numDice; i++)
			dice.add(new Die());
		decrementNumTurnsLeft();
	}
	
	public int getNumDice()
	{
		return numDice;
	}
	
	/**
	 * rolls all dice that are not kept and decrements numTurnsLeft
	 */
	public void rollDice()
	{
		if(getNumTurnsLeft() > 0)
		{
			for(int i = 0; i < numDice; i++)
			{
				if(!dice.get(i).getIsKept())
					dice.get(i).rollDie();
			}
			decrementNumTurnsLeft();
		}
	}
	
	/**
	 * returns the array list containing all instances of Die class in the hand
	 * @return dice: array list containing all instances of Die class in the hand
	 */
	public ArrayList<Die> getDice()
	{
		return dice;
	}
	
	/**
	 * displays the hand using images of dice
	 * @param frame the main JFrame
	 * @param handPanel the panel on which the hand is displayed
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public void displayHand(YahtzeeFrame frame, final JPanel handPanel) throws FontFormatException, IOException
	{
		handPanel.removeAll();
		for(int i = 0; i < numDice; i++)
		{
			dice.get(i).setIsKeptFalse();
			int character = dice.get(i).getCharacter();  
			final int house = dice.get(i).getHouse();
			String str = displayHouse(house);
		    String imgPath = character + ".png";
		    ImageIcon image = new ImageIcon(new ImageIcon(imgPath).getImage().getScaledInstance(150, 210, Image.SCALE_DEFAULT));
		    final JToggleButton characterButton = new JToggleButton(image);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("HarryPotter.ttf")));
			characterButton.setFont(new Font("Harry Potter", Font.PLAIN, 25));
			characterButton.setText(str);
		    characterButton.setHorizontalTextPosition(SwingConstants.CENTER);
		    characterButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		    if(house == 1)
		    	characterButton.setForeground(Color.red.darker()); 
		    else if(house == 2)
		    	characterButton.setForeground(Color.blue.darker().darker()); 
		    else if(house == 3)
		    	characterButton.setForeground(Color.yellow.darker()); 
		    else
		    	characterButton.setForeground(Color.green.darker().darker().darker()); 
			handPanel.add(characterButton);
			final int num = i;
			characterButton.setDisabledIcon(image);
			if(getNumTurnsLeft() == 0)
				characterButton.setEnabled(false);
			
			characterButton.addActionListener(new ActionListener() {
			       public void actionPerformed(ActionEvent e) {
			    	   if(e.getSource() == characterButton) {
			    		   if(dice.get(num).getIsKept() == false)
			    			   dice.get(num).setIsKeptTrue();
			    		   else 
			    			   dice.get(num).setIsKeptFalse();
			    		   if(house == 1)
			    		   {
				    		   UIManager.put("ToggleButton.select", Color.red.darker());
				    		   SwingUtilities.updateComponentTreeUI(characterButton);
			    		   }
			    		   else if(house == 2)
			    		   {
			    			   UIManager.put("ToggleButton.select", Color.blue.darker().darker());
				    		   SwingUtilities.updateComponentTreeUI(characterButton);
			    		   }
			    		   else if(house == 3)
			    		   {
			    			   UIManager.put("ToggleButton.select", Color.yellow.darker());
				    		   SwingUtilities.updateComponentTreeUI(characterButton);
			    		   }
			    		   else
			    		   {
			    			   UIManager.put("ToggleButton.select", Color.green.darker().darker().darker());
				    		   SwingUtilities.updateComponentTreeUI(characterButton);
			    		   }
			       }
				}});
		}
		frame.add(handPanel);
		frame.setVisible(true);
	}
	
	public String displayHouse(int house)
	{
		if(house == 1)
			return "Gryffindor";
		else if(house == 2)
			return "Ravenclaw";
		else if(house == 3)
			return "Hufflepuff";
		else
			return "Slytherin";
	}
	
	/**
	 * resets the hand
	 */
	public void resetHand()
	{
		resetNumTurns();
		for(int i = 0; i < numDice; i++)
		{
			dice.get(i).setIsKeptFalse();
		}
	}
	
	/**
	 * returns the total of the house values for all dice in the hand
	 * @return total: total of the house values for all dice in the hand
	 */
	public int totalOfAllDice()
	{
		int total = 0;
	    for (int diePosition = 0; diePosition < numDice; diePosition++)
	    {
	        int num = dice.get(diePosition).getHouse();
	        if(num == 1)
	        	total+=20;
	        else if(num == 2)
	        	total+=15;
	        else if(num == 3)
	        	total+= 10;
	        else
	        	total+=5;
	    }
	    return total;
	}
	
	/**
	 * returns the maximum number of the same dice found in the hand
	 * @return maxCount: maximum number of the same dice found in the hand
	 */
	public int maxOfACharacterFound()
	{
		 int maxCount = 0;
		 int currentCount;
		 for(int dieValue = 1; dieValue <= 12; dieValue++)
		 {
			 currentCount = 0;
		     for (int diePosition = 0; diePosition < numDice; diePosition++)
		     {
		    	 if (dice.get(diePosition).getCharacter() == dieValue)
		                currentCount++;
		     }
		     if (currentCount > maxCount)
		    	 maxCount = currentCount;
		 }
		 return maxCount;
	}
	
	/**
	 * returns the maximum number of characters from the same house found in the hand
	 * @return maxCount: maximum number of characters from the same house in the hand
	 */
	public int maxOfAHouseFound()
	{
		int maxCount = 0; 
		int currentCount;
		for(int house = 1; house <= 4; house++)
		 {
			 currentCount = 0;
		     for (int diePosition = 0; diePosition < numDice; diePosition++)
		     {
		    	 if (dice.get(diePosition).getHouse() == house)
		                currentCount++;
		     }
		     if (currentCount > maxCount)
		    	 maxCount = currentCount;
		 }
		 return maxCount;
	}
	
	/**
	 * returns the number of turns per hand
	 * @return number of turns per hand
	 */
	public int getNumTurnsLeft() {
		return numTurnsLeft;
	}
	
	/**
	 * resets number of turns left to 3
	 */
	public void resetNumTurns()
	{
		numTurnsLeft = 3;
	}
	
	/**
	 * decrements number of turns left
	 */
	public void decrementNumTurnsLeft()
	{
		numTurnsLeft--;
	}
	
	public void setNumTurnsToZero()
	{
		numTurnsLeft = 0;
	}
}