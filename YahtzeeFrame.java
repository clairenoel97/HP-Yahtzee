import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class YahtzeeFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private final static YahtzeeFrame frame = new YahtzeeFrame();
	private static Container contentPane;
	private static int linesLeft;
	
	private static Element gryffindor;
	private static Element ravenclaw;
	private static Element hufflepuff;
	private static Element slytherin;
	private static Element threeofakind;
	private static Element fourofakind;
	private static Element fullhouse;
	private static Element snape;
	private static Element mcgonagall;
	private static Element army;
	private static Element yahtzee;
	private static Element lowertotal;
	private static Element uppertotal;
	private static Element bonus;
	private static Element grandtotal;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					playYahtzee();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Sets up the game of Yahtzee by instantiating the necessary classes and 
	 * adding components to the JFrame.
	 * @throws IOException
	 * @throws FontFormatException 
	 */
	public static void playYahtzee() throws IOException, FontFormatException 
	{
		/*
		 * initialize number of lines
		 */
		linesLeft = 11;
		
		/* 
		 * initialize elements
		 */
		gryffindor = new Element();
		ravenclaw = new Element();
		hufflepuff = new Element();
		slytherin = new Element();
		threeofakind = new Element();
		fourofakind = new Element();
		fullhouse = new Element();
		snape = new Element();
		mcgonagall = new Element();
		army = new Element();
		yahtzee = new Element();
		lowertotal = new Element();
		uppertotal = new Element();
		bonus = new Element();
		grandtotal = new Element();
		
		/*
		 * create new game, hand, scorecard, and bonus objects
		 */
		final Hand newHand = new Hand();
		final Scorecard newScorecard = new Scorecard();
		final GoldenSnitchBonus newBonus = new GoldenSnitchBonus();

		/*
		 * create and configure panels
		 */
		final JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.black);
		final JPanel handPanel = new JPanel();
		handPanel.setBackground(Color.black);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("HarryPotter.ttf")));
		handPanel.setBorder(BorderFactory.createTitledBorder(null, "<html><span style='font-size:30px'>"+"Dice: "+"</span></html>", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, (new Font("Harry Potter", Font.PLAIN, 50)), Color.WHITE));
		final JPanel scorePanel = new JPanel();
		scorePanel.setBackground(Color.BLACK);
		scorePanel.setBorder(BorderFactory.createTitledBorder(null, "<html><span style='font-size:30px'>"+"Scorecard: "+"</span></html>", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, (new Font("Harry Potter", Font.PLAIN, 50)), Color.WHITE));
		final JPanel upperPanel = new JPanel();
		upperPanel.setBorder(BorderFactory.createTitledBorder(null, "<html><span style='font-size:30px'>"+"Upper Scorecard: "+"</span></html>", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, (new Font("Harry Potter", Font.PLAIN, 50)), Color.WHITE));
		upperPanel.setLayout(new GridLayout(6, 3));
		final JPanel lowerPanel = new JPanel();
		lowerPanel.setBackground(Color.BLACK);
		lowerPanel.setBorder(BorderFactory.createTitledBorder(null, "<html><span style='font-size:30px'>"+"Lower Scorecard: "+"</span></html>", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, (new Font("Harry Potter", Font.PLAIN, 50)), Color.WHITE));
		lowerPanel.setLayout(new GridLayout(9, 3));
		
		/*
		 * create button and label and add to button panel
		 */
		final JButton rollButton = new JButton("<html><span style='font-size:30px'>"+"Roll dice"+"</span></html>");
		rollButton.setFont(new Font("Harry Potter", Font.PLAIN, 30));
		buttonPanel.add(rollButton);
		final JButton scoreHandButton = new JButton("<html><span style='font-size:30px'>"+"Score hand"+"</span></html>");
		scoreHandButton.setFont(new Font("Harry Potter", Font.PLAIN, 30));
		buttonPanel.add(scoreHandButton);
		final JLabel message = new JLabel("<html><span style='font-size:35px'>"+ "Please select a score" +"</span></html>");
		message.setFont(new Font("Harry Potter", Font.PLAIN, 18));
		message.setForeground(Color.WHITE);
		buttonPanel.add(message);
		message.setVisible(false);
		
		/*
		 * add labels to upper panel
		 */
		upperPanel.setBackground(Color.BLACK);
		formatLabel("Gryffindor:", upperPanel);
		upperPanel.add(gryffindor.label);
		upperPanel.add(gryffindor.button);
		formatLabel("Ravenclaw:", upperPanel);
		upperPanel.add(ravenclaw.label);
		upperPanel.add(ravenclaw.button);
		formatLabel("Hufflepuff:", upperPanel);
		upperPanel.add(hufflepuff.label);
		upperPanel.add(hufflepuff.button);
		formatLabel("Slytherin:", upperPanel);
		upperPanel.add(slytherin.label);
		upperPanel.add(slytherin.button);
		formatLabel("Golden Snitch Bonus:", upperPanel);
		upperPanel.add(bonus.label);
		upperPanel.add(new JLabel(""));
		formatLabel("Upper Section Total:", upperPanel);
		upperPanel.add(uppertotal.label);
		upperPanel.add(new JLabel(""));
		
		/*
		 * add labels to lower panel
		 */
		formatLabel("Three of a kind:", lowerPanel);
		lowerPanel.add(threeofakind.label);
		lowerPanel.add(threeofakind.button);
		formatLabel("Four of a kind:", lowerPanel);
		lowerPanel.add(fourofakind.label);
		lowerPanel.add(fourofakind.button);
		formatLabel("Full House:", lowerPanel);
		lowerPanel.add(fullhouse.label);
		lowerPanel.add(fullhouse.button);
		formatLabel("Snape:", lowerPanel);
		lowerPanel.add(snape.label);
		lowerPanel.add(snape.button);
		formatLabel("McGonagall:", lowerPanel);
		lowerPanel.add(mcgonagall.label);
		lowerPanel.add(mcgonagall.button);
		formatLabel("Dumbledore's Army:", lowerPanel);
		lowerPanel.add(army.label);
		lowerPanel.add(army.button);
		formatLabel("Yahtzee:", lowerPanel);
		lowerPanel.add(yahtzee.label);
		lowerPanel.add(yahtzee.button);
		formatLabel("Lower Section Total:", lowerPanel);
		lowerPanel.add(lowertotal.label);
		lowerPanel.add(new JLabel(""));
		formatLabel("Grand Section Total:", lowerPanel);
		lowerPanel.add(grandtotal.label);
		lowerPanel.add(new JLabel(""));
		
		disableButtons();
		
		/*
		 * add panels to frame
		 */
		frame.add(buttonPanel, BorderLayout.NORTH);
		frame.add(handPanel, BorderLayout.CENTER);
		scorePanel.add(upperPanel);
		scorePanel.add(lowerPanel);
		frame.add(scorePanel, BorderLayout.SOUTH);
		
		/*
		 * add action listeners to frame
		 */
		rollButton.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		    	   if(e.getSource() == rollButton) {
		               try {
		            	newHand.rollDice();
						newHand.displayHand(frame, handPanel);
						newScorecard.setScorecard(newHand);
		    			displayScores(newScorecard);
		    			if(newHand.getNumTurnsLeft() < 3)
		    				scoreHandButton.setVisible(true);
			            if(newHand.getNumTurnsLeft() == 0)
			    		{
			            	rollButton.setVisible(false);
			    			scoreHandButton.setVisible(false);
			    		    message.setVisible(true);
			    	 	    enableButtons();
			    	 	    decrementLines();
			    		}
					} catch (FontFormatException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
		              }
		       }
			});
		
		scoreHandButton.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		             if(e.getSource() == scoreHandButton) {
		            	try {
			            	newHand.setNumTurnsToZero();
							newHand.displayHand(frame, handPanel);
							newScorecard.setScorecard(newHand);
			    			displayScores(newScorecard);
			         		scoreHandButton.setVisible(false);
			         		rollButton.setVisible(false);
			    			message.setVisible(true);
			    			enableButtons();
			    			decrementLines();
						} catch (FontFormatException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
		              }
		       }
			});
		
		gryffindor.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				gryffindor.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[0].getScore();
				newScorecard.getScorecard()[0].setIsSet();
				gryffindor.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				uppertotal.value += score;
				uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				if(uppertotal.value >= newBonus.getBonusRule()) {
					bonus.label.setText("<html><span style='font-size:20px'>" + newBonus.getBonusScore()
											+ "</span></html>");
					uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value 
											+ "</span></html>");
					grandtotal.value += newBonus.getBonusScore();
				}
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		ravenclaw.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				ravenclaw.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[1].getScore();
				newScorecard.getScorecard()[1].setIsSet();
				ravenclaw.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				uppertotal.value += score;
				uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				if(uppertotal.value >= newBonus.getBonusRule()) {
					bonus.label.setText("<html><span style='font-size:20px'>" + newBonus.getBonusScore()
											+ "</span></html>");
					uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value 
											+ "</span></html>");
					grandtotal.value += newBonus.getBonusScore();
				}
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		hufflepuff.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				hufflepuff.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[2].getScore();
				newScorecard.getScorecard()[2].setIsSet();
				hufflepuff.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				uppertotal.value += score;
				uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				if(uppertotal.value >= newBonus.getBonusRule()) {
					bonus.label.setText("<html><span style='font-size:20px'>" + newBonus.getBonusScore()
											+ "</span></html>");
					uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value 
											+ "</span></html>");
					grandtotal.value += newBonus.getBonusScore();
				}
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		slytherin.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				slytherin.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[3].getScore();
				newScorecard.getScorecard()[3].setIsSet();
				slytherin.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				uppertotal.value += score;
				uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				if(uppertotal.value >= newBonus.getBonusRule()) {
					bonus.label.setText("<html><span style='font-size:20px'>" + newBonus.getBonusScore()
											+ "</span></html>");
					uppertotal.label.setText("<html><span style='font-size:20px'>" + uppertotal.value 
											+ "</span></html>");
					grandtotal.value += newBonus.getBonusScore();
				}
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		threeofakind.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				threeofakind.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[4].getScore();
				newScorecard.getScorecard()[4].setIsSet();
				threeofakind.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				threeofakind.value = score;
				lowertotal.value += threeofakind.value;
				lowertotal.label.setText("<html><span style='font-size:20px'>" + lowertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		fourofakind.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				fourofakind.button.setVisible(false);
				message.setVisible(false);;
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[5].getScore();
				newScorecard.getScorecard()[5].setIsSet();
				fourofakind.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				fourofakind.value = score;
				lowertotal.value += fourofakind.value;
				lowertotal.label.setText("<html><span style='font-size:20px'>" + lowertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		fullhouse.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				fullhouse.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[6].getScore();
				newScorecard.getScorecard()[6].setIsSet();
				fullhouse.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				fullhouse.value = score;
				lowertotal.value += fullhouse.value;
				lowertotal.label.setText("<html><span style='font-size:20px'>" + lowertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		snape.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				snape.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[7].getScore();
				newScorecard.getScorecard()[7].setIsSet();
				snape.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				snape.value = score;
				lowertotal.value += snape.value;
				lowertotal.label.setText("<html><span style='font-size:20px'>" + lowertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		mcgonagall.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				mcgonagall.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[8].getScore();
				newScorecard.getScorecard()[8].setIsSet();
				mcgonagall.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				mcgonagall.value = score;
				lowertotal.value += mcgonagall.value;
				lowertotal.label.setText("<html><span style='font-size:20px'>" + lowertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		army.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				army.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[9].getScore();
				newScorecard.getScorecard()[9].setIsSet();
				army.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				army.value = score;
				lowertotal.value += army.value;
				lowertotal.label.setText("<html><span style='font-size:20px'>" + lowertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		yahtzee.button.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				disableButtons();
				yahtzee.button.setVisible(false);
				message.setVisible(false);
				rollButton.setVisible(true);
				newHand.resetNumTurns();
				int score = newScorecard.getScorecard()[5].getScore();
				newScorecard.getScorecard()[10].setIsSet();
				yahtzee.label.setText("<html><span style='font-size:20px'>" + score + "</span></html>");
				yahtzee.value = score;
				lowertotal.value += yahtzee.value;
				lowertotal.label.setText("<html><span style='font-size:20px'>" + lowertotal.value + "</span></html>");
				grandtotal.value = uppertotal.value + lowertotal.value;
				grandtotal.label.setText("<html><span style='font-size:20px'>" + grandtotal.value + "</span></html>");
				checkGameFinished(buttonPanel, handPanel, scorePanel);
			}
		});
		
		newHand.displayHand(frame, handPanel);
		frame.setVisible(true);
	}
	
	public static void displayScores(Scorecard newScorecard)
	{
		for(int i = 0; i < 11; i++)
		{
			int score = newScorecard.getScorecard()[i].getScore();
			if(i == 0) {
				gryffindor.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 1) {
				ravenclaw.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 2) {
				hufflepuff.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 3) {
				slytherin.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 4) {
				threeofakind.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 5) {
				fourofakind.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 6) {
				fullhouse.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 7) {
				snape.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 8) {
				mcgonagall.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 9) {
				army.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} else if(i == 10) {
				yahtzee.button.setText("<html><span style='font-size:18px'>" 
						+ score + "</span></html>");
			} 
		}
	}
	
	public static void decrementLines()
	{
		linesLeft--;
	}
	
	public static void checkGameFinished(final JPanel buttonPanel, JPanel handPanel, final JPanel scorePanel)
	{
		if(linesLeft == 0)
		{
			buttonPanel.removeAll();
			handPanel.removeAll();
			handPanel.setBorder(null);
			final JLabel message = new JLabel("<html><span style='font-size:50px'>"+ "Mischief Managed" +"</span></html>");
			message.setFont(new Font("Harry Potter", Font.PLAIN, 18));
			message.setForeground(Color.WHITE);
			handPanel.add(message);
			final JButton playAgainButton = new JButton("<html><span style='font-size:30px'>"+"Play Again"+"</span></html>");
			playAgainButton.setFont(new Font("Harry Potter", Font.PLAIN, 30));
			buttonPanel.add(playAgainButton);
			
			playAgainButton.addActionListener(new ActionListener() {
			       public void actionPerformed(ActionEvent e) {
			    	   if(e.getSource() == playAgainButton) {
			    		   frame.getContentPane().removeAll();
			    		   try {
							playYahtzee();
						} catch (IOException e1) {
							e1.printStackTrace();
						} catch (FontFormatException e1) {
							e1.printStackTrace();
						}
			    	   }
			       }
				});
		}
	}
	
	public static void disableButtons()
	{
		gryffindor.button.setEnabled(false);
		ravenclaw.button.setEnabled(false);
		hufflepuff.button.setEnabled(false);
		slytherin.button.setEnabled(false);
		threeofakind.button.setEnabled(false);
		fourofakind.button.setEnabled(false);
		fullhouse.button.setEnabled(false);
		snape.button.setEnabled(false);
		mcgonagall.button.setEnabled(false);
		yahtzee.button.setEnabled(false);
		army.button.setEnabled(false);
	}
	
	public static void enableButtons()
	{
		gryffindor.button.setEnabled(true);
		ravenclaw.button.setEnabled(true);
		hufflepuff.button.setEnabled(true);
		slytherin.button.setEnabled(true);
		threeofakind.button.setEnabled(true);
		fourofakind.button.setEnabled(true);
		fullhouse.button.setEnabled(true);
		snape.button.setEnabled(true);
		mcgonagall.button.setEnabled(true);
		yahtzee.button.setEnabled(true);
		army.button.setEnabled(true);
	}
	
	public static void formatLabel(String str, JPanel upperPanel)
	{
		JLabel label = new JLabel("<html><span style='font-size:18px'>"+ str +"</span></html>");
		label.setFont(new Font("Harry Potter", Font.PLAIN, 18));
		label.setForeground(Color.WHITE);
		upperPanel.add(label);
	}
	
	/**
	 * Constructor of the YahtzeeFrame
	 */
	public YahtzeeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 1000);
		contentPane = getContentPane();
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}