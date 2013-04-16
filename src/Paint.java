
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


    public void setLoggedinUser(LoggedinUser loggedinUser) {
        me = loggedinUser;

    }


	public Paint (LoggedinUser loggedinUser) {
        this.setLayout(new BorderLayout());
        setLoggedinUser(loggedinUser);
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);


		isoBackground = new IsoBackground ();
		miniMap = new MiniMap ();
		isometricMap = new IsometricMap ();

//        JMenuBar menuBar = new JMenuBar();
//        JMenu TextSending = new JMenu("Send Text");
//        JMenuItem talkMenu = new JMenuItem("Talk");
//        JMenuItem yellMenu = new JMenuItem("Yell");
//        TextSending.add(talkMenu);
//        TextSending.add(yellMenu);
//        menuBar.add(TextSending);
//        this.setJMenuBar(menuBar);

//        JPanel talkPanel = new JPanel();
//        JLabel talkSign = new JLabel("Talk");
//        JTextField talkMsg = new JTextField(10);
//        JButton submitTalkButton = new JButton("Submit Talk");
//        talkPanel.add(talkSign);
//        talkPanel.add(talkMsg);
//        talkPanel.add(submitTalkButton);
//        talkPanel.setBackground(Color.WHITE);
//        talkPanel.setVisible(true);
//        this.add(talkPanel,BorderLayout.SOUTH);

        weather = new Weather ();
		talking = new Talking ("pout pout pout", TALK_VISIBLE_DURATION);
		yelling = new Yelling ("Cry Cry Cry");
		addMouseListener(isometricMap);
		addMouseMotionListener(isometricMap);
		addMouseWheelListener(isometricMap);
		//setBackground(new Color(0,162,232));
		changeCursor("sword.gif");
		new Animator ();
		this.pack();
        me.loggedin();


		//new Music ("music.wav");

	}
	
	
	public void  paint(Graphics g) {
		image= createImage(getSize().width,getSize().height);
		buffer=image.getGraphics();
		isoBackground.paintIsoBackground(buffer);
		isometricMap.paintMap(buffer,getWidth(),getHeight());
		buffer.setColor(Color.WHITE);
		weather.paintWeather(buffer);
//		yelling.paintYelling(buffer);
		miniMap.paintMiniMap (buffer,isometricMap.getRowAvatar(),isometricMap.getLineAvatar());
		g.drawImage(image,0,0,this);
		sendDataToServer ();
       
		
	}
	
	public void sendDataToServer () {
        //System.out.println("send data to server");
        //System.out.println(isometricMap.getCliqued());
		if (isometricMap.getCliqued()){
            //System.out.println("walk");
			me.walking(isometricMap.getLineCliqued(), isometricMap.getRowCliqued());
            isometricMap.switchDoneSend();
		}
        if (talking.getTalk()){
            //System.out.println("talk");
            me.talking(talking.getMessage());
            talking.switchDoneSend();
        }
        if (yelling.getYelling()){
            me.yelling(yelling.getMessage());
            yelling.switchDoneSend();
        }
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
