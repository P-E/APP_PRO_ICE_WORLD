import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 14/4/2556
 * Time: 14:06 น.
 * To change this template use File | Settings | File Templates.
 */
public class mainMap extends JFrame{
    public static void main(String[] args){
        Paint paint = new Paint();
        JFrame mainFrame = new JFrame();
        mainFrame.getContentPane().add(paint);

        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    }
}
