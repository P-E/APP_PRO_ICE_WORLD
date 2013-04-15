
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
//import java.awt.Point;
//import java.awt.Polygon;
//import java.awt.Toolkit;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class MiniMap extends JPanel {
Image icone;
JFrame frame;

	public MiniMap(){
		
		icone = getToolkit().getImage("images/icone.jpg" );
	}
    public void paintMiniMap(Graphics g, int x, int y) {
    		g.setColor(Color.BLACK);
    		g.fillRect(10,40,240,240);
    		g.setColor(new Color (185,122,87));
    		g.fillRect(15,45,230,230);
    		g.setColor(new Color(0,162,232));
        	g.fillRect(20,50,220,220);
        	
        	 
        	g.drawImage(icone,2*x+30-9,2*y+60-9,frame);
        	
                
            
    }

}
    
