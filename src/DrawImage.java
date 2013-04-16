import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

 
	public class DrawImage extends JPanel { 
		private Image image; 

		public DrawImage(String s) { 
			image = getToolkit().getImage(s); 
		} 

		public void paintComponent(Graphics g) { 
			super.paintComponent(g); 
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this); 
		} 
	}
