
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Element {
	public JLabel label;
	public JButton button;
	public int value;
	
	public Element() {
		value = 0;
		label = new JLabel("<html><span style='font-size:18px'>"+ value +"</span></html>");
		label.setForeground(Color.WHITE);
		button = new JButton();
		button.setPreferredSize(new Dimension(5, 30));
	}
}