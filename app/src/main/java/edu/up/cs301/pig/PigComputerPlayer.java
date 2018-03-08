package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {
    Random rand = new Random();
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(info instanceof PigGameState){
            PigGameState ComputerState = (PigGameState)info;
            if(ComputerState.playerID != this.playerNum){
                return;
            }
        }
        int i = rand.nextInt(2);
        if(i == 0){
            PigHoldAction HA = new PigHoldAction(this);
            game.sendAction(HA);
        }
        else{
            PigRollAction RA = new PigRollAction(this);
            game.sendAction(RA);
        }
    }//receiveInfo

}
