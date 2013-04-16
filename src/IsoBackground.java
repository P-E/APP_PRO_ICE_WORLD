
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;



public class IsoBackground extends JPanel {
Image background;

	public IsoBackground(){
		background = getToolkit().getImage("images/background5.jpg" );
	}
    public void paintIsoBackground(Graphics g) {
        	g.drawImage(background,0,0,this);       
    }

}
