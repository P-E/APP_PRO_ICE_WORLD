import java.awt.*;
import java.io.IOException;


import javax.swing.*;



public class Paint extends JFrame {
    //public int currentLine, currentRow;
	private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int TALK_VISIBLE_DURATION = 2000;
	private Image image;
	private Graphics buffer;
	private IsoBackground isoBackground;
	private Weather weather;
	private Talking talking;
	private Yelling yelling;
	private IsometricMap isometricMap;
	private MiniMap miniMap;
    private FetchStateTest stateTest;
    public static LoggedinUser me = new LoggedinUser();
    private String talkMsg, yellMsg;
    public static Messenger mymessenger = new Messenger();
    public static Object weatherState,weatherOldState;
    private int countTime=0;

    public void setLoggedinUser(LoggedinUser loggedinUser) {
        me = loggedinUser;

    }


	public Paint (LoggedinUser loggedinUser) throws IOException {
        this.setLayout(new BorderLayout());
        setLoggedinUser(loggedinUser);

        this.setSize(1280, 720);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

		isoBackground = new IsoBackground ();
		miniMap = new MiniMap ();
		isometricMap = new IsometricMap ();

        TalkingWindow talkingWindow = new TalkingWindow();
        talkingWindow.setSize(600,110);

        talkingWindow.setVisible(true);



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


        weather = new Weather (weatherState);
		talking = new Talking ("", TALK_VISIBLE_DURATION);
		yelling = new Yelling ("");

		addMouseListener(isometricMap);
		addMouseMotionListener(isometricMap);
		addMouseWheelListener(isometricMap);
		addKeyListener(isometricMap);
		//setBackground(new Color(0,162,232));
		changeCursor("sword.gif");
		new Animator ();
		this.pack();
        me.loggedin();
        stateTest = new FetchStateTest();

		//new Music ("music.wav");

	}
	
	public static void logout(){
        me.immigration.logout();
        System.exit(0);
    }


    public void  paint(Graphics g){

        //System.out.println(weatherState);
        try {

            stateTest = new FetchStateTest();

        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }



        image= createImage(getSize().width,getSize().height);
		buffer=image.getGraphics();
		isoBackground.paintIsoBackground(buffer);
		isometricMap.paintMap(buffer,getWidth(),getHeight());
		talking.paintTalking(buffer, isometricMap.getCharPosition(),isometricMap.getZoomLevel());
		buffer.setColor(Color.WHITE);
		weather.paintWeather(buffer);
		yelling.paintYelling(buffer);
		miniMap.paintMiniMap (buffer,isometricMap.getRowAvatar(),isometricMap.getLineAvatar());
		g.drawImage(image,0,0,this);

        try {
            recieveMassage();
        } catch (IOException e) {
        }
        sendDataToServer ();

       
		
	}



    private void recieveMassage() throws IOException {
        if(mymessenger.isTalkSend){
            talking = new Talking(mymessenger.getTalkMsg(),TALK_VISIBLE_DURATION);
            mymessenger.setTalkMsg("");
            mymessenger.switchTalkSend();
        }
        if(mymessenger.isYellSend){
            yelling = new Yelling(mymessenger.getYellMsg());
            mymessenger.setYellMsg("");
            mymessenger.switchYellSend();
        }
        if(stateTest.getWeather()){

            weatherState = stateTest.getWeatherCondition();
            weather = new Weather(weatherState);
            mymessenger.switchWeatherSend();
            stateTest.switchDoneSend();

//            System.out.println("Weather Change");
//            System.out.println(stateTest.getWeather());
        }
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
            if(talking.getMessage()!=""){
                me.talking(talking.getMessage());
            }
            talking.switchDoneSend();
        }
        if (yelling.getYelling()){
            if(yelling.getMessage()!=""){
                me.yelling(yelling.getMessage());
            }
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
				thread.sleep(500);
			}catch (InterruptedException e) {}
			
			repaint ();
			}
		}
	}

}
