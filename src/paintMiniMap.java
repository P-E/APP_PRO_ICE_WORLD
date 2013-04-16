
import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Point;
//import java.awt.Polygon;
//import java.awt.Toolkit;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;

import javax.swing.JApplet;



public class paintMiniMap extends JApplet {

	private int x , y;
	
	public paintMiniMap(int x, int y){
		this.x=x;
		this.y=y;
	}
    public void paintMiniMap(Graphics g) {
            g.setColor(Color.RED);
            g.fillOval(x,y,7,7);
                
            g.setColor(Color.BLACK);
        	g.drawRect(0,0,100,100);
    }

}
    
