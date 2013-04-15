import iceworld.given.*;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;



public class Login extends JFrame {
	
	private int x = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int y = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	
	private JPanel mainPanel;
	private ExitDialog exit;
	private AboutDialog aboutDialog;
	private JMenuBar menuBar;
	private JMenu  help,menu;
	private JMenuItem about,helpItem,exitItem;
	private JLabel ICELabel;
    private JButton guestLogIn;
    private JButton logIn;
    private JPasswordField password;
    private JTextField username;
    private JLabel info;
    private JButton no;
    private JButton yes;
    
    private SplashScreen open;
    private LinkedList<UserID> users = new LinkedList<UserID>();

		
	
	
	public Login (String string) {
		super(string);
		//users.add(new UserID ("toto","toto"));
		
		setGUI();
		setListener();
		
	}
	
    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mockup("ICE World").setVisible(true);
            }
        });
    }*/

	public static void main(String[] args) {
		
		new Login ("ICE World");

	}
	
	public void setGUI () {
		
		mainPanel = new JPanel();
		exit = new ExitDialog();
		aboutDialog = new AboutDialog();
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		help = new JMenu ("Help");
		about = new JMenuItem("About ICE-World");
		helpItem = new JMenuItem ("Help Contents");
		exitItem = new JMenuItem ("Exit");
		ICELabel = new JLabel();
        guestLogIn = new JButton();
        logIn = new JButton();
        username = new JTextField();
        password = new JPasswordField();     
        info = new JLabel ();
        
        
        
        new SplashScreen ();
        
        //Set the location of the frame on the screen
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setPreferredSize(new Dimension(600,400));
        //this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width-this.getPreferredSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-this.getPreferredSize().height)/2);
        this.setVisible(true);

        menuBar.setBorder(null);
        helpItem.setAccelerator(KeyStroke.getKeyStroke("F1"));;

        username.setFont(new Font("Calibri", 2, 11));
        username.setForeground(new Color(153, 153, 153));
        username.setText("Username");
        username.setBorder(null);
        
        password.setEchoChar((char) 0);
        password.setFont(new Font("Calibri", 2, 11));
        password.setForeground(new Color(153, 153, 153));
        password.setText("Password");
        password.setBorder(null);
        
        guestLogIn.setBackground(new Color(255, 255, 255));
        guestLogIn.setFont(new Font("Trebuchet MS", 1, 11));
        guestLogIn.setText("GUEST");
        guestLogIn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        guestLogIn.setMaximumSize(new Dimension(110, 20));
        guestLogIn.setMinimumSize(new Dimension(110, 20));
        guestLogIn.setPreferredSize(new Dimension(110, 20));

        logIn.setBackground(new Color(255, 255, 255));
        logIn.setFont(new Font("Trebuchet MS", 1, 11));
        logIn.setText("LOG-IN");
        logIn.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        logIn.setMaximumSize(new Dimension(110, 20));
        logIn.setMinimumSize(new Dimension(110, 20));
        logIn.setPreferredSize(new Dimension(110, 20));
        
        ICELabel.setFont(new Font("Trebuchet MS", 1, 50));
        ICELabel.setForeground(new Color(0, 0, 51));
        ICELabel.setText("ICE WORLD");
        
        info.setFont(new Font("Calibri", 2, 14));
        info.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(mainPanel);
        mainPanel.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(170, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(info, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(ICELabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(username)
                        .addComponent(password, GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(logIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(guestLogIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addComponent(ICELabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(info, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(username, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(password, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(guestLogIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(logIn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        
        menu.add(exitItem);
        menuBar.add(menu);
        help.add(helpItem);
        help.addSeparator();
        help.add(about);
        menuBar.add(help);
        
        mainPanel.setOpaque(false);
        menuBar.setOpaque(false);
        setContentPane(new DrawImage("images/drawing.jpg"));
        this.setLayout(new BorderLayout ());
        this.add(mainPanel, BorderLayout.CENTER);
        this.add(menuBar, BorderLayout.NORTH);
        this.pack();
        this.setSize(780, 520);
        this.setLocation((x-this.getWidth())/2, (y-this.getHeight())/2);
    }
 
	class DrawImage extends JPanel { 
		private Image image; 

		public DrawImage(String s) { 
			image = getToolkit().getImage(s); 
		} 

		public void paintComponent(Graphics g) { 
			super.paintComponent(g); 
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this); 
		} 
	} 
	
	public void setListener () {
		addWindowListener(new Handler ());
		username.addMouseListener(new Handler());
		username.addFocusListener(new Handler());
		password.addMouseListener(new Handler ());
		password.addFocusListener(new Handler());
		logIn.addActionListener(new Handler());
		guestLogIn.addActionListener(new Handler());
		exitItem.addActionListener(new Handler());
		about.addActionListener(new Handler());
	
	}
	
	class Handler implements MouseListener, WindowListener, FocusListener, ActionListener {
		
		public void mousePressed (MouseEvent e) {
			JTextField temp = (JTextField)e.getComponent();
			info.setText(null);
	        if (temp.getFont().isItalic()== true) {
	            temp.setText("");
	            temp.setFont(new Font("Calibri", 0, 11));
	            temp.setForeground(Color.BLACK);
	            if (temp == password){
	            	password.setEchoChar((char) '*');
	            }
	        }
	        
		}
		
		public void windowOpening (WindowEvent e){}
		
		public void windowClosing (WindowEvent e){
			//JFrame currentFrame = (JFrame)e.getSource()
			exit.setVisible(true);
		}
		
		public void focusLost (FocusEvent e){
			JTextField temp = (JTextField)e.getComponent();
			if (temp.getText().trim().isEmpty()) {
				setTextField(temp);
			}
		}
		
		public void actionPerformed (ActionEvent e) {
			AbstractButton temp = (AbstractButton)e.getSource();
			
			if (temp == logIn ) {
				UserID currentUser = getUserID(username.getText());
                System.out.println(username.getText());
                String usernameFromField = username.getText();
                System.out.println(password.getText());
                String passwordFromField = password.getText();
				if (!"".equals(username.getText())){

					if (currentUser.getNumberTries()!=3) {
                        //if(currentUser.getPassword().equals(password.getText())){

                            Icetizen me  = new Icetizen();
                            me.setUsername(usernameFromField);

                            me.setIcePortID(252);
                            me.setListeningPort(10777);
                            IcetizenLook look = new IcetizenLook();
                            look.gidB = "B001";
                            look.gidS = "S001";
                            look.gidH = "H001";
                            look.gidW = "W001";
                            me.setIcetizenLook(look);

                        ICEWorldImmigration immigration = new ICEWorldImmigration(me);
                        boolean loginSuccess = immigration.login(passwordFromField);
                        System.out.println(loginSuccess);
                        if(loginSuccess){
                            info.setForeground(Color.BLACK);
                            info.setText("Logged-in as ICE-TIZEN");
//                            immigration.walk(10,90);
//                            immigration.walk(90,10);
//                            currentUser.setNumberTries(0);
//                            users.add(currentUser);
                            setVisible(false);
                            Paint mainFrame = new Paint();
                            mainFrame.setVisible(true);
                            mainFrame.setSize(new Dimension(1280,720));
                            mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);



                        }
						//}

						else{
							currentUser.setNumberTries(currentUser.getNumberTries()+1);
							System.out.println(currentUser.getNumberTries());
							info.setForeground(Color.RED);
							info.setText("Username or password incorrect");
							setTextField(username);
							setTextField(password);
							users.add(currentUser);
						}

                    }
					else{
						info.setForeground(Color.RED);
						info.setText("Retry in 5 minutes");
						setTextField(username);
						setTextField(password);
						currentUser.blockUser();
						users.add(currentUser);
					}

                }
				else {
					info.setForeground(Color.RED);
					info.setText("Username or password incorrect");
					setTextField(username);
					setTextField(password);
				}

            }
			
			if (temp == guestLogIn ){
				info.setForeground(Color.BLACK);
				info.setText("Logged-in as ALIEN");
			}
			
			if (temp == yes) {
				System.exit(0);
			}
			
			if (temp == no) {
				exit.setVisible(false);
			}
			
			if (temp== exitItem) {
				exit.setVisible(true);
			}
			
			if (temp == about) {
				aboutDialog.setVisible(true);
			}
		}
		
		

		public void setTextField (JTextField text) {
	        text.setFont(new Font("Calibri", 2, 11));
	        text.setForeground(new Color(153, 153, 153));
	        if (text == username){
	        	username.setText("Username");
	        }
	        else if (text == password){
	        	((JPasswordField)text).setEchoChar((char) 0);
		        text.setText("Password");
		    }
		}
		
		public void caretPositionChanged (InputMethodEvent e) {}
		
		public void mouseClicked (MouseEvent e) {}
		
		public void mouseEntered (MouseEvent e) {}
		
		public void mouseExited (MouseEvent e) {}
		
		public void mouseReleased (MouseEvent e) {}
		
		public void windowOpened (WindowEvent e){}
		
		public void windowClosed (WindowEvent e){}
		
		public void windowActivated (WindowEvent e){}
		
		public void windowDeactivated (WindowEvent e){}
		
		public void windowDeiconified (WindowEvent e){}
		
		public void windowIconified (WindowEvent e){}
		
		public void focusGained (FocusEvent e){}

		
	}
	
	class UserID {
		private String username ;
		private String password;
		private int numberTries ;
		
		public UserID (String username, String password){
			this.username = username;
			this.password = password;
			this.numberTries = 0;
		}
		
		public String getUsername (){
			return this.username;
		}
		
		public String getPassword (){
			return this.password;
		}
		
		public void setNumberTries (int numberTries) {
			this.numberTries = numberTries;
		}
		
		public int getNumberTries () {
			return this.numberTries;
		}
		
		public void blockUser () {
			(new Thread() { 
				public void run () {
					try {
						sleep(300000);
					}catch (InterruptedException e){}
					numberTries = 0;
				}				
			}
			).start();
		}
	}
	
	public UserID getUserID (String userName) {
		
		UserID user = new UserID("","");
		for (UserID u : users) {
			
			if (u.getUsername().equals(userName)) {
				user = u;
				users.remove(u);
			}
		}
		return user;
	}
	
	
	class ExitDialog extends JDialog {
		private JPanel dialogPanel;
		private JLabel quitLabel;
		
		
		public ExitDialog() {
			setDialogGUI();
			setDialogListener();
		}
			public void setDialogGUI() {
				dialogPanel = new JPanel();
				yes = new JButton();
				no = new JButton();
		    	quitLabel = new JLabel();
		    	
		    	
		        yes.setBackground(new Color(255, 255, 255));
		        yes.setFont(new Font("Trebuchet MS", 0, 12)); // NOI18N
		        yes.setText("Yes");
		        yes.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		        no.setBackground(new Color(255, 255, 255));
		        no.setFont(new Font("Trebuchet MS", 0, 12)); // NOI18N
		        no.setText("No");
		        no.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

		        quitLabel.setFont(new Font("Trebuchet MS", 0, 12)); // NOI18N
		        quitLabel.setText("Do you really want to quit ?");

		        GroupLayout layout = new GroupLayout(dialogPanel);
		        dialogPanel.setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap(88, Short.MAX_VALUE)
		                .addComponent(yes, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		                .addGap(45, 45, 45)
		                .addComponent(no, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
		                .addContainerGap(91, Short.MAX_VALUE))
		            .addGroup(layout.createSequentialGroup()
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		                .addComponent(quitLabel)
		                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		                .addContainerGap(42, Short.MAX_VALUE)
		                .addComponent(quitLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
		                .addGap(18, 18, 18)
		                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                    .addComponent(yes)
		                    .addComponent(no))
		                .addContainerGap(41, Short.MAX_VALUE))
		        );
		        
		        dialogPanel.setOpaque(false);
		        this.setContentPane(new DrawImage("images/dialogdraw.jpg"));
		        this.setLayout(new BorderLayout ());
		        this.add(dialogPanel);
		        this.pack();
		        this.setLocation((x-this.getWidth())/2, (y-this.getHeight())/2);
				this.setResizable(false);
				this.setModal(true);
				

		}
			
			public void setDialogListener () {
				yes.addActionListener(new Handler ());
				no.addActionListener(new Handler());
				}
	}
	
	class SplashScreen extends JDialog {
		private JPanel SplashScreenPanel;
		private JLabel iCESplashScreenLabel;
		private JLabel splashScreenLoadLable;
		
		public SplashScreen () {
			setSplashScreenGUI();
		}
		
		public void setSplashScreenGUI () {
			SplashScreenPanel = new JPanel ();
	        iCESplashScreenLabel = new JLabel();
	        splashScreenLoadLable = new JLabel();

	        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	        iCESplashScreenLabel.setFont(new Font("Trebuchet MS", 1, 50));
	        iCESplashScreenLabel.setForeground(new Color(0, 0, 51));
	        iCESplashScreenLabel.setText("ICE WORLD");

	        splashScreenLoadLable.setFont(new Font("Trebuchet MS", 2, 12));
	        splashScreenLoadLable.setHorizontalAlignment(SwingConstants.CENTER);
	        splashScreenLoadLable.setText("Loading...");

	        GroupLayout layout = new GroupLayout(SplashScreenPanel);
	        SplashScreenPanel.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(70, Short.MAX_VALUE)
	                .addComponent(iCESplashScreenLabel, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
	                .addContainerGap(70, Short.MAX_VALUE))
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(splashScreenLoadLable, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(45, Short.MAX_VALUE)
	                .addComponent(iCESplashScreenLabel, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
	                .addGap(18, 18, 18)
	                .addComponent(splashScreenLoadLable)
	                .addContainerGap(49, Short.MAX_VALUE))
	        );
	        
	        this.setUndecorated(true);
	        this.setVisible(true);
	        SplashScreenPanel.setOpaque(false);
	        this.setContentPane(new DrawImage("images/splashScreenWallPaper.jpg"));
	        this.add(SplashScreenPanel);
	        this.pack();
	        this.setLocation((x-this.getWidth())/2, (y-this.getHeight())/2);
	        try{Thread.sleep(5000);}catch(InterruptedException e){};
	        this.dispose();
	    }
		
	}
	
	class AboutDialog extends JDialog {
		private JPanel dialogPanel;
	    private JLabel studentLabel1;
	    private JLabel studentLabel2;
	    private JLabel studentLabel3;
	    private JLabel studentLabel4;
	    private DrawImage studentPic1;
	    private DrawImage studentPic2;
	    private DrawImage studentPic3;
	    private DrawImage studentPic4;
		
		
		public AboutDialog () {
			setAboutDialogGUI ();
		}
		
		public void setAboutDialogGUI () {
			dialogPanel = new JPanel ();
			studentPic1 = new DrawImage("images/student1.jpg");
	        studentPic2 = new DrawImage("images/student2.jpg");
	        studentPic3 = new DrawImage("images/student3.jpg");
	        studentPic4 = new DrawImage("images/student4.jpg");
	        studentLabel1 = new JLabel();
	        studentLabel2 = new JLabel();
	        studentLabel3 = new JLabel();
	        studentLabel4 = new JLabel();

	        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	        GroupLayout studentPic1Layout = new GroupLayout(studentPic1);
	        studentPic1.setLayout(studentPic1Layout);
	        studentPic1Layout.setHorizontalGroup(
	            studentPic1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        studentPic1Layout.setVerticalGroup(
	            studentPic1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        GroupLayout studentPic2Layout = new GroupLayout(studentPic2);
	        studentPic2.setLayout(studentPic2Layout);
	        studentPic2Layout.setHorizontalGroup(
	            studentPic2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        studentPic2Layout.setVerticalGroup(
	            studentPic2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        GroupLayout studentPic3Layout = new GroupLayout(studentPic3);
	        studentPic3.setLayout(studentPic3Layout);
	        studentPic3Layout.setHorizontalGroup(
	            studentPic3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        studentPic3Layout.setVerticalGroup(
	            studentPic3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        GroupLayout studentPic4Layout = new GroupLayout(studentPic4);
	        studentPic4.setLayout(studentPic4Layout);
	        studentPic4Layout.setHorizontalGroup(
	            studentPic4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );
	        studentPic4Layout.setVerticalGroup(
	            studentPic4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 100, Short.MAX_VALUE)
	        );

	        studentLabel1.setFont(new Font("Trebuchet MS", 0, 12));
	        studentLabel1.setForeground(Color.BLACK);
	        studentLabel1.setText("studentLabel1");

	        studentLabel2.setFont(new Font("Trebuchet MS", 0, 12));
	        studentLabel2.setForeground(Color.BLACK);
	        studentLabel2.setText("studentLabel2");

	        studentLabel3.setFont(new Font("Trebuchet MS", 0, 12));
	        studentLabel3.setForeground(Color.BLACK);
	        studentLabel3.setText("studentLabel3");

	        studentLabel4.setFont(new Font("Trebuchet MS", 0, 12));
	        studentLabel4.setForeground(Color.BLACK);
	        studentLabel4.setText("studentLabel4");

	        GroupLayout layout = new GroupLayout(dialogPanel);
	        dialogPanel.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(19, 19, 19)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(studentPic2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(studentLabel2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
	                        .addGap(0, 0, Short.MAX_VALUE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(studentPic1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addComponent(studentLabel1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
	                .addGap(18, 18, 18)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(studentPic4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(studentPic3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(studentLabel4, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(studentLabel3, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(16, Short.MAX_VALUE))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(66, 66, 66)
	                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(studentLabel3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	                        .addGap(65, 65, 65)
	                        .addComponent(studentLabel4, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(studentPic1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addGap(65, 65, 65)
	                        .addComponent(studentPic2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(layout.createSequentialGroup()
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(studentPic4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(studentLabel1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	                        .addGap(65, 65, 65)
	                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addComponent(studentPic3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(studentLabel2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
	                .addGap(66, 66, 66))
	        );
	        dialogPanel.setOpaque(false);
	        this.setUndecorated(true);
	        this.setContentPane(new DrawImage("images/tree.jpg"));
	        this.setLayout(new BorderLayout ());
	        this.add(dialogPanel,BorderLayout.CENTER);
	        pack();
	        
	        this.setResizable(false);
	        this.setModal(true);
	        this.setLocation((x-this.getWidth())/2, (y-this.getHeight())/2);
		}
	}

}
