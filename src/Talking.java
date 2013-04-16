import iceworld.given.ICEWorldImmigration;

import java.awt.*;

import javax.swing.JApplet;


public class Talking {
    private boolean doneSend = false;
    private int TALK_VISIBLE_DURATION ;
    private String message ;
    private FontMetrics fm;
    private int lengthBubble, bubbleX,bubbleY,lengthMessage;
    private int CHAR_WIDTH, CHAR_HEIGHT ;
    private boolean display;
    Icetizen ice = new Icetizen ();
    ICEWorldImmigration immig = new ICEWorldImmigration (ice);


        public Talking (String message,int TALK_VISIBLE_DURATION) {
            this.message = message ;
            this.TALK_VISIBLE_DURATION = TALK_VISIBLE_DURATION;
            display = true;
            CHAR_WIDTH = 30;
            CHAR_HEIGHT = 30;
            lengthBubble= 100;

            doneSend = true;

            (new DisplayBubble ()).start();
            //immig.loginAlien();
            //immig.talk(message);
        }

        public void paintTalking (Graphics g, int charPositionX, int charPositionY) {
            if (display){
                g.setFont(new Font("TimesRoman",Font.CENTER_BASELINE,20));
                fm=g.getFontMetrics(g.getFont());
                lengthMessage = fm.stringWidth(message);
                if (lengthMessage>100) {
                    lengthBubble= lengthMessage+20;
                }
                bubbleX = charPositionX - lengthBubble/2;
                bubbleY = charPositionY - 80 ;

                g.setColor(Color.BLACK);
                g.fillOval(bubbleX+30/2, bubbleY+2,lengthBubble,40 );
                g.fillPolygon(new int [] {charPositionX+CHAR_WIDTH+2,charPositionX+CHAR_WIDTH+17,charPositionX+CHAR_WIDTH/2+2}, new int []{(charPositionY-50),(charPositionY-50),charPositionY-3*(CHAR_HEIGHT/4)}, 3);
                g.setColor(Color.WHITE);
                g.fillPolygon(new int [] {charPositionX+CHAR_WIDTH,charPositionX+CHAR_WIDTH+15,charPositionX+CHAR_WIDTH/2}, new int []{(charPositionY-50),(charPositionY-50),charPositionY-3*(CHAR_HEIGHT/4)}, 3);
                g.fillOval(bubbleX+30/2, bubbleY,lengthBubble,40 );
                g.setColor(Color.BLACK);
                g.drawString(message, bubbleX+30/2+(lengthBubble-lengthMessage)/2, bubbleY+23);
            }


        }

        public boolean getTalk(){
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
                sleep (TALK_VISIBLE_DURATION);
            } catch (InterruptedException e) {}

        }
    }

}
