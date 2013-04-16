
import iceworld.given.ICEWorldImmigration;
import iceworld.given.IcetizenLook;

import java.awt.*;


import javax.swing.*;



public class Paint extends JFrame {
    //public int currentLine, currentRow;
	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int TALK_VISIBLE_DURATION = 5000;
	private Image image;
	private Graphics buffer;
	private IsoBackground isoBackground;
	private Weather weather;
	private Talking talking;
	private Yelling yelling;
	private IsometricMap isometricMap;
	private MiniMap miniMap;
    public static LoggedinUser me = new LoggedinUser();





	public static void main (String [] args){
		Paint paint = new Paint ();
		paint.setDefaultCloseOperation(EXIT_ON_CLOSE);
		paint.setVisible(true);

	}
    public void setLoggedinUser(LoggedinUser loggedinUser) {
        me = loggedinUser;
    }

    public LoggedinUser getLoggedinUser(){
        return me;
    }
	public Paint () {
        me.loggedin();
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
		isoBackground = new IsoBackground ();
		miniMap = new MiniMap ();
		isometricMap = new IsometricMap ();
		weather = new Weather ();
		talking = new Talking ("prout prout prout", TALK_VISIBLE_DURATION);
		yelling = new Yelling ("WHAT THE FUCK");
		isometricMap = new IsometricMap();
		addMouseListener(isometricMap);
		addMouseMotionListener(isometricMap);
		addMouseWheelListener(isometricMap);
		//setBackground(new Color(0,162,232));
		changeCursor("sword.gif");
		new Animator ();
		this.pack();

		//new Music ("music.wav");

	}
	
	
	public void  paint(Graphics g) {
		image= createImage(getSize().width,getSize().height);
		buffer=image.getGraphics();
		isoBackground.paintIsoBackground(buffer);
		isometricMap.paintMap(buffer,getWidth(),getHeight());
		buffer.setColor(Color.WHITE);
		weather.paintWeather(buffer);
		yelling.paintYelling(buffer);
		miniMap.paintMiniMap (buffer,isometricMap.getRowAvatar(),isometricMap.getLineAvatar());
		g.drawImage(image,0,0,this);
    
       
		
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
