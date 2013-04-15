import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


public class IsometricSquare {

	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int line, row, width, height;
	private int nextCenterX, nextCenterY, zoomLevel;
	private Point origin;
	private Polygon poly;
	private boolean highlighted, cliqued, isAvatarOn;
	
	public IsometricSquare (int line, int row, int nextCenterX, int nextCenterY, int zoomLevel) {
		this.line = line;
		this.row = row;
		this.nextCenterX = nextCenterX;
		this.nextCenterY = nextCenterY;
		this.zoomLevel = zoomLevel;
		highlighted = false ;
		cliqued = false ;
		width = (MAX_X/200)*zoomLevel;
     	height = (MAX_Y/200)*zoomLevel;
        origin = new Point (MAX_X/2 + (nextCenterX-nextCenterY)*width ,MAX_Y/2-height*50*2 +(100-nextCenterX-nextCenterY)*height);
        
    	int originLine = origin.x - line*width ; 
    	int originRow = origin.y + line*height;
    	int[] px = {originLine + width*row, originLine + width*(row+1), originLine+ width*row, originLine + width*(row-1) };
        int[] py = { originRow + height*(row-1), originRow + height*row, originRow + height*(row+1), originRow + height*row };
        poly = new Polygon(px, py, 4);

        
	}
	
    


    public void paintSquare(Graphics g) {
                
                if (highlighted){
                	g.setColor(Color.RED);
                	g.fillPolygon(poly);
                }
                
                else if (cliqued) {
                	g.setColor(Color.YELLOW);
                    g.fillPolygon(poly);
                }
                
                else if ((line-row)%2 ==0) {
                	g.setColor(new Color (0,128,0));
                    g.fillPolygon(poly);
                }
                
                else {
                	g.setColor(new Color (67,128,38));
                    g.fillPolygon(poly);
                }
                
                g.setColor(Color.BLACK);
        		g.drawPolygon(poly);
        		
            }
    
    public void paintAvatarOnMap (Graphics g, int i, int k) {
    	int x = poly.xpoints[0] + (int)(((double)i)*(((double)width)/((double)height)));
		int y = poly.ypoints[1] + k;
		g.setColor(Color.BLACK);
		g.fillOval(x-(5/2)*zoomLevel, y-5*zoomLevel, 5*zoomLevel,5*zoomLevel);
    }
    
    public int getLine () {
    	return line;
    }
    
    public int getRow () {
    	return row;
    }
    
    
    public boolean contains ( Point p) {
    	return poly.contains(p);
    }

    public void setHighlighted (boolean highlighted) {
    	this.highlighted = highlighted;
    }
    
    public void setCliqued (boolean cliqued) {
    	this.cliqued = cliqued;
    }
    
    public void setIsAvatarOn (boolean isAvatarOn) {
    	this.isAvatarOn = isAvatarOn;
    }
    
    }
