
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.*;



public class Paint extends JFrame {

	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int TALK_VISIBLE_DURATION = 5000;
	private Image image;
	private Graphics buffer;
	private Weather weather;
	private Talking talking;
	private Yelling yelling;
	private IsometricMap isometricMap;
	private MiniMap miniMap;
	
	
	public static void main (String [] args){
		Paint paint = new Paint ();
		paint.setDefaultCloseOperation(EXIT_ON_CLOSE);
		paint.setVisible(true);
		
	}
	
	public Paint () {

		miniMap = new MiniMap ();
		isometricMap = new IsometricMap ();
		weather = new Weather ();
		talking = new Talking ("prout prout prout", TALK_VISIBLE_DURATION);
		yelling = new Yelling ("WHAT THE FUCK");
		isometricMap = new IsometricMap();
		addMouseListener(isometricMap);
		addMouseMotionListener(isometricMap);
		addMouseWheelListener(isometricMap);
		setBackground(new Color(0,162,232));
		changeCursor("sword.gif");
		new Animator ();
		//new Music ("music.wav");

	}
	
	public void paint (Graphics g) {
		
		image= createImage(getSize().width,getSize().height);
		buffer=image.getGraphics();
		isometricMap.paintMap(buffer,getWidth(),getHeight());
		buffer.setColor(Color.WHITE);
		weather.paintWeather(buffer);
		yelling.paintYelling(buffer);
		g.drawImage(image,0,0,this);
		
    
        miniMap.paintMiniMap (g,isometricMap.getRowAvatar(),isometricMap.getLineAvatar());
		
	}
	
	public void changeCursor (String cursorFile) {
		  Toolkit toolkit = Toolkit.getDefaultToolkit();
		  Image image = toolkit.getImage(cursorFile);
		  Cursor c = toolkit.createCustomCursor(image , new Point(getX(),getY()), "img");
		  setCursor (c);
	}
	
	class Animator implements Runnable {
		private Thread thread;

		public Animator () {
			thread = new Thread (this);
			thread.start();
		}
		
		public void run () {
			while (true) {
			try {
				thread.sleep(10);
			}catch (InterruptedException e) {}
			
			repaint ();
			}
		}
	}

}
