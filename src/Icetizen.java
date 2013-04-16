import iceworld.given.IcetizenLook;
import iceworld.given.MyIcetizen;


public class Icetizen implements MyIcetizen{

	private String username;
	private int portID,listeningPort;
	private IcetizenLook icetizenLook;
    private String password;
    private int x,y;

	public int getIcePortID() {
		return portID;
	}

	public IcetizenLook getIcetizenLook() {
		return icetizenLook;
	}

	public int getListeningPort() {
		return listeningPort;
	}

	public String getUsername() {
		return username;
	}

	public void setIcePortID(int portID) {
		this.portID = portID;
	}

	public void setIcetizenLook(IcetizenLook icetizenLook) {
		this.icetizenLook=icetizenLook;
	}

	public void setListeningPort(int listeningPort) {
		this.listeningPort=listeningPort ;
	}

	public void setUsername(String username) {
		this.username = username;	
	}
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
