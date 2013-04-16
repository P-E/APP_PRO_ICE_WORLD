
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
Image minimap;

	public MiniMap(){
		minimap = getToolkit().getImage("images/minimap.jpg" );
		icone = getToolkit().getImage("images/icone.jpg" );
	}
    public void paintMiniMap(Graphics g, int x, int y) {
    		g.drawImage(minimap,13,42,this);
        	
        	 
        	g.drawImage(icone,2*x+30-9,2*y+60-9,this);
        	
                
            
    }

}
    
