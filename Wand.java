import java.awt.Color;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Wand extends JFrame 
{
	private static final long serialVersionUID = 1L;
	
	// play game button
	private JButton playGameButton = new JButton();
	
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws FontFormatException 
	 */
	public static void main(String[] args) throws FontFormatException, IOException 
	{
		new Wand();
	}

	public Wand() throws FontFormatException, IOException 
	{
		// setup
		setBounds(100, 100, 800, 500);
		getContentPane().setBackground(Color.WHITE);
		setResizable(false); 
		playGameButton.setIcon(new ImageIcon("Wand.png"));
		playGameButton.setBounds(250, 125, 300, 219);
		playGameButton.setBorderPainted(false);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().add(playGameButton);
		
		JLabel newLabel = new JLabel("Please select the wand to roll the dice");
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("HarryPotter.ttf")));
		newLabel.setFont(new Font("Harry Potter", Font.PLAIN, 40));
		newLabel.setBounds(100, 50, 600, 75);
		getContentPane().add(newLabel);
		
		playGameButton.addActionListener(new ActionListener() {
		       public void actionPerformed(ActionEvent e) {
		             if(e.getSource() == playGameButton) {
		            	 try {
							YahtzeeFrame.playYahtzee();
							setVisible(false);	
						} catch (IOException | FontFormatException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		              }
		       }
			});

		setVisible(true);
	}
}