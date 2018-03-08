package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

/**
 * Created by morham20 on 3/1/2018.
 */

public class PigGameState extends GameState {
    int playerID;
    int player0Score;
    int player1Score;
    int runningTotal;
    int dieValue;

    public PigGameState(){
        player0Score = 0;
        playerID = 0;
        player1Score = 0;
        runningTotal = 0;
        dieValue = 0;
    }
    public PigGameState(PigGameState State){
        playerID = State.playerID;
        player1Score = State.player1Score;
        player0Score = State.player0Score;
        runningTotal = State.runningTotal;
        dieValue = State.dieValue;
    }
    public int getPlayerID(){
        return playerID;
    }
    public int getplayer1Score(){
        return player1Score;
    }
    public int getPlayer0Score(){
        return player0Score;
    }
    public int getRunningTotal(){
        return runningTotal;
    }
    public int getDieValue(){
        return dieValue;
    }

    public void setPlayerID(int pID){
        playerID = pID;
    }
    public void setplayer1Score(int p1S){
        player1Score = p1S;
    }
    public void setplayer0Score(int p0S){
        player0Score = p0S;
    }
    public void setRunningTotal(int rT){
        runningTotal = rT;
    }
    public void setDieValue(int dV){
        dieValue = dV;
    }

}
