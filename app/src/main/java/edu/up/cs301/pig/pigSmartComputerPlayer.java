package edu.up.cs301.pig;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

/**
 * Created by morham20 on 3/7/2018.
 */

public class pigSmartComputerPlayer extends GameComputerPlayer {

    public pigSmartComputerPlayer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        PigGameState SmartComputerState = (PigGameState)info;
        if(info instanceof PigGameState){
            if(SmartComputerState.playerID != this.playerNum){
                return;
            }
        }
        if(SmartComputerState.runningTotal < 10 &&
                SmartComputerState.getplayer1Score() < SmartComputerState.getPlayer0Score()){
            sleep(300);
            PigRollAction RA = new PigRollAction(this);
            game.sendAction(RA);
        }
        else if(SmartComputerState.getplayer1Score() >= SmartComputerState.getPlayer0Score() && SmartComputerState.runningTotal < 10){
            sleep(300);
            PigRollAction RA = new PigRollAction(this);
            game.sendAction(RA);
        }
        else if((SmartComputerState.getplayer1Score()+SmartComputerState.runningTotal) - SmartComputerState.getPlayer0Score()
                < -15){
            sleep(300);
            PigRollAction RA = new PigRollAction(this);
            game.sendAction(RA);
        }
        else{
            sleep(300);
            PigHoldAction HA = new PigHoldAction(this);
            game.sendAction(HA);
        }
    }//receiveInfo
}

