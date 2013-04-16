import iceworld.given.ICEWorldImmigration;

/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 16/4/2556
 * Time: 12:39 น.
 * To change this template use File | Settings | File Templates.
 */
public class LoggedinUser {
    String username;
    String password;
    final int userIDPort = 252;
    final int userConnectPort = 10777;
    ICEWorldImmigration immigration;
    Icetizen me = new Icetizen();


    public String getUsername (){
        return this.username;
    }
    public String getPassword (){
        return this.password;
    }
    public void setUsername(String givenUsername){
        username = givenUsername;
        //System.out.println(username);
    }
    public void setPassword(String givenPassword){
        password = givenPassword;
        //System.out.println(password);
    }

    public void loggedin(){
        //System.out.println(password);
        me.setPassword(password);
        me.setUsername(username);
        me.setListeningPort(userConnectPort);
        me.setIcePortID(userIDPort);
        //System.out.println(me.getPassword());
        immigration = new ICEWorldImmigration(me);
        immigration.login(me.getPassword());
        immigration.walk(50,50);
        System.out.println("Login!");
    }

    public void walking(int x,int y){
        immigration.walk(x,y);
        //System.out.println("walk");
    }
    public void talking(String msg){
        immigration.talk(msg);
    }
    public void yelling(String msg){
        immigration.yell(msg);
    }
}
