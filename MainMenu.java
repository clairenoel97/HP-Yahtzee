import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * creates the main menu and its actions
 * @see main();
 * @see MainMenu();
 * @see playAction
 * @see instructAction
 */
public class MainMenu extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;

	/**
	 * Launch the application
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public static void main(String[] args) throws FontFormatException, IOException 
	{
		new MainMenu();
	}

	/**
	 * Create the frame
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public MainMenu() throws FontFormatException, IOException
	{
		// set up
		setBounds(100, 100, 860, 442);
		getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		setResizable(false);
		
		// creates the buttons in a panel for the main menu
		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setBackground(Color.BLACK);
		
		// play game button
		JButton playButton = new JButton("Play Game");
		playButton.setFont(new Font("Harry Potter", Font.PLAIN, 35));
		buttonPanel.add(playButton);
		playButton.addActionListener(new playAction());
		
		//instructions button
		JButton instructButton = new JButton("Instructions");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("HarryPotter.ttf")));
		instructButton.setFont(new Font("Harry Potter", Font.PLAIN, 35));
		buttonPanel.add(instructButton);
		instructButton.addActionListener(new instructAction());
		
		add(new ScreenComponent());
		pack();

        // background picture 
		JLabel label = new JLabel();  
        label.setIcon(new ImageIcon("HPMain.png"));
        add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(400, 400, size.width, size.height);
        
        setVisible(true);
	}
	
	/**
	 * action listener for play game button
	 */
    private class playAction implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		JFrame a;
			try {
				a = new Wand();
	    		a.setVisible(true);
			} catch (FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		setVisible(false);	
    	}
    }
    
	/**
	 * action listener for instructions button
	 */
    private class instructAction implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		JFrame b;
			try {
				b = new Instructions();
	    		b.setVisible(true);
			} catch (FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	}
    }
}

/**
 * creates the title 
 */
class ScreenComponent extends JComponent
{
	private static final long serialVersionUID = 1L;
	public static final int x = 100;
	public static final int y = 70;
	private static final int width = 800;
	private static final int height = 411;
	
	// paints the title
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		String message = "Harry Potter Yahtzee";
		Font f = new Font("Harry Potter", Font.PLAIN, 70);
		g.setFont(f);
		g.drawString(message, x, y);	
	}
	
	// returns the size of the screen
	public Dimension getPreferredSize()
	{
		return new Dimension(width, height);
	}
}