import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 14/4/2556
 * Time: 14:06 น.
 * To change this template use File | Settings | File Templates.
 */
public class mainMap{
    public static LoggedinUser me = new LoggedinUser();
    public static void main(String[] args){
        me.loggedin();
//        Paint paint = new Paint();
//        paint.setVisible(true);
//        paint.setSize(1000,500);


    }


    public void setLoggedinUser(LoggedinUser loggedinUser) {
        me = loggedinUser;
    }

    public LoggedinUser getLoggedinUser(){
        return me;
    }
}
