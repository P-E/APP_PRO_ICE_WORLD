import iceworld.given.ICEWorldImmigration;

import java.awt.*;

import javax.swing.JApplet;


public class Yelling {

    private int MAX_X = Toolkit.getDefaultToolkit().getScreenSize().width;
    private int MAX_Y = Toolkit.getDefaultToolkit().getScreenSize().height;
    private String message ;
    private int lengthMessage;
    private FontMetrics fm;
    private boolean display;
    private boolean doneSend = false;

    public Yelling (String message) {
        this.message = message ;
        display = true;

        doneSend = true;

        (new DisplayBubble ()).start();

    }

    public void paintYelling (Graphics g) {
        if (display){
            g.setFont(new Font("Arial",Font.CENTER_BASELINE,80));
            fm=g.getFontMetrics(g.getFont());
            lengthMessage = fm.stringWidth(message);
            g.setColor(Color.BLACK);
            g.drawString(message, (MAX_X - lengthMessage)/2, MAX_Y/3);
            System.out.println(message);
        }
    }

    public boolean getYelling(){
        return doneSend;
    }

    public String getMessage(){
        return message;
    }

    public void switchDoneSend(){
        doneSend = false;
    }

    class DisplayBubble extends Thread {
        public void run (){
            try {
                sleep (10000);
            } catch (InterruptedException e) {}
            display = false;
        }
    }

}
