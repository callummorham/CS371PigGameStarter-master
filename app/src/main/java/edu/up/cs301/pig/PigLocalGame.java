package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;
import java.util.concurrent.ConcurrentNavigableMap;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    Random rand = new Random();

    PigGameState CurrentState = new PigGameState();
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        CurrentState = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        //TODO  You will implement this method
        if(playerIdx == CurrentState.playerID){
            return true;
        }
        return false;
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        //TODO  You will implement this method
         if(action instanceof PigRollAction){

             CurrentState.setDieValue(rand.nextInt(6));
             if(CurrentState.getDieValue() != 0){
                 CurrentState.setRunningTotal(CurrentState.getRunningTotal() + CurrentState.getDieValue()+1);
             }
             else{
                 CurrentState.setRunningTotal(0);
                 if(CurrentState.getPlayerID()==0){
                     CurrentState.setPlayerID(1);
                 }
                 else{
                     CurrentState.setPlayerID(0);
                 }
             }
             return true;
         }
         else if(action instanceof PigHoldAction){
             if(CurrentState.playerID == 0){
                 CurrentState.setplayer0Score( CurrentState.getRunningTotal()+ CurrentState.getPlayer0Score());
                 CurrentState.setRunningTotal(0);
                 CurrentState.setPlayerID(1);
             }
             else{
                 CurrentState.setplayer1Score( CurrentState.getRunningTotal()+ CurrentState.getplayer1Score());
                 CurrentState.setRunningTotal(0);
                 CurrentState.setPlayerID(0);
             }
             return true;
         }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        //TODO  You will implement this method
        PigGameState Current = new PigGameState(CurrentState);
        p.sendInfo(Current);

    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(CurrentState.player1Score >= 50){
            return "Player "+CurrentState.playerID+" Wins"+CurrentState.player1Score;
        }
        else if(CurrentState.player0Score >= 50){
            return "Player "+CurrentState.playerID+" Wins"+CurrentState.player0Score;
        }
        return null;
    }

}// class PigLocalGame
