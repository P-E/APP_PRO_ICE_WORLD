/**
 * Created with IntelliJ IDEA.
 * User: AVALON
 * Date: 17/4/2556
 * Time: 1:25 น.
 * To change this template use File | Settings | File Templates.
 */
public class Messenger {
    String talkMsg, yellMsg;
    Object weatherState;
    boolean isTalkSend = false;
    boolean isYellSend = false;
    boolean isWeatherSend = false;
    public String getTalkMsg(){
        return talkMsg;
    }

    public void setTalkMsg(String msg){
        talkMsg = msg;
    }

    public String getYellMsg(){
        return yellMsg;
    }

    public void setYellMsg(String msg){
        yellMsg = msg;
    }

    public void switchTalkSend(){
        isTalkSend = false;
    }

    public void switchYellSend(){
        isYellSend = false;
    }

    public void switchWeatherSend(){
        isWeatherSend = false;
    }
}
