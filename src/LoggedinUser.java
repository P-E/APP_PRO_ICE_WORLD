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

    public void setIcetizen(Icetizen me){
        this.me = me;
    }

    public Icetizen getIcetizen(){
        return me;
    }

    public ICEWorldImmigration getImmigration(){
        return immigration;
    }

    public String getUsername (){
        return this.username;
    }
    public String getPassword (){
        return this.password;
    }
    public void setUsername(String givenUsername){
        username = givenUsername;
    }
    public void setPassword(String givenPassword){
        password = givenPassword;
    }

    public void loggedin(){
        me.setPassword(password);
        me.setUsername(username);
        me.setListeningPort(userConnectPort);
        me.setIcePortID(userIDPort);
        immigration = new ICEWorldImmigration(me);
        immigration.login(me.getPassword());
    }

    public void walking(int x,int y){
        immigration.walk(x,y);
    }
}
