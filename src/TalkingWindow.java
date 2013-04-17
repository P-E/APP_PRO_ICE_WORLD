import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 17/4/2556
 * Time: 0:46 น.
 * To change this template use File | Settings | File Templates.
 */
public class TalkingWindow extends JFrame{
    JTextField talkMsg;
    JButton submitTalkButton;
    JTextField yellMsg;
    JButton submitYellButton;
    Talking talking;
    Yelling yelling;

    //Messenger messenger = new Messenger();
        public TalkingWindow(){
        	
        	this.setAlwaysOnTop(true);
        	//this.setUndecorated(true);
            this.setLayout(new BorderLayout());
           
            JPanel talkPanel = new JPanel();
            JLabel talkSign = new JLabel("Talk");
            talkMsg = new JTextField(10);
            submitTalkButton = new JButton("Submit Talk");
            talkPanel.add(talkSign);
            talkPanel.add(talkMsg);
            talkPanel.add(submitTalkButton);
            talkPanel.setBackground(Color.WHITE);
            this.add(talkPanel,BorderLayout.NORTH);

            JPanel yellPanel = new JPanel();
            JLabel yellSign = new JLabel("Yell");
            yellMsg = new JTextField(10);
            submitYellButton = new JButton("Submit Yell");
            talkPanel.add(yellSign);
            talkPanel.add(yellMsg);
            talkPanel.add(submitYellButton);
            talkPanel.setBackground(Color.WHITE);
            this.add(yellPanel,BorderLayout.SOUTH);

            JPanel logoutPanel = new JPanel();
            JButton logout = new JButton("Logout");
            JButton help = new JButton ("Help");
            logoutPanel.add(help);
            logoutPanel.add(logout);
            this.add(logoutPanel,BorderLayout.SOUTH);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            toFront();
            
          


            submitTalkButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(talkMsg.getText()!=null){
                        sendTalking(talkMsg.getText());

                    }
                    System.out.println(talkMsg.getText());
                }
            });

            submitYellButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (yellMsg!=null){
                        sendYelling(yellMsg.getText());

                    }
                    System.out.println("Yell");
                }
            });

            logout.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Paint.logout();
                }
            });
            
            help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new tabPane ();
                }
            });
        }

    private void sendTalking(String msg) {
        Paint.mymessenger.setTalkMsg(msg);
        Paint.mymessenger.isTalkSend = true;
        blank();

    }
    private void sendYelling(String msg) {
        Paint.mymessenger.setYellMsg(msg);
        Paint.mymessenger.isYellSend = true;
        blank();
    }


    public void blank(){
        talkMsg.setText("");
        yellMsg.setText("");
    }
}
