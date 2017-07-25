import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * creates the main menu and its actions
 * @see main();
 * @see Instructions();
 */
public class Instructions extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Instructions frame = new Instructions();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public Instructions() throws FontFormatException, IOException 
	{
		// setup
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(new BorderLayout());
		setSize(1500, 1000);
		setLocationRelativeTo(null);
		
		// creates the title for the instructions screen
		JLabel instructions = new JLabel("Instructions");
		instructions.setForeground(Color.WHITE);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("HarryPotter.ttf")));
		instructions.setFont(new Font("Harry Potter", Font.PLAIN, 50));
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		titlePanel.add(instructions);
		getContentPane().add(titlePanel, BorderLayout.NORTH);
        
		// creates the panel for all of the pages
		JPanel pageContainer = new JPanel();
		pageContainer.setBackground(Color.BLACK);
		getContentPane().add(pageContainer, BorderLayout.SOUTH);
		
		//page 1
		ImageIcon icon1 = new ImageIcon(new ImageIcon("Instructions1.png").getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
		JLabel label1 = new JLabel(icon1);
		pageContainer.add(label1);
		  
		//page 2
		ImageIcon icon2 = new ImageIcon(new ImageIcon("Instructions2.png").getImage().getScaledInstance(600, 800, Image.SCALE_DEFAULT));
		JLabel label2 = new JLabel(icon2);
		pageContainer.add(label2);
		  
		setVisible(true);
	}
}