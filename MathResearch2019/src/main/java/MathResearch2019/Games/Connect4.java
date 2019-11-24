package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import MathResearch2019.Errors.TurnMismatchError;

/**
 * Connect4
 */
public class Connect4 implements Game {

  private String board;
  private boolean isCyclic;
  private final char PLAYER_2 = 'B';
  private final char PLAYER_1 = 'R';
  private boolean victoryStatus;
  private boolean stalemateStatus;

  public Connect4(int i, int j) {
  }

  public Connect4(int i, int j, boolean b) {
  }

  public Connect4(String string) {
  }

  public Connect4(String string, boolean b) {
  }

  @Override
  public boolean checkVictory() {
    // TODO Auto-generated method stub
    return victoryStatus;
  }

  @Override
  public boolean checkStalemateStatus() {
    stalemateStatus = board.contains("e");
    return stalemateStatus;
  }

  @Override
  public boolean seeStalemateStatus() {
    return stalemateStatus;
  }

  @Override
  public boolean seeVictoryStatus() {
    return victoryStatus;
  }

  @Override
  public String getBoard() {
    return board;
  }

  @Override
  public ArrayList<Game> possibleMoves(char turn) throws TurnMismatchError {
    ArrayList<Game> outArrayList = new ArrayList<Game>();
  }

  @Override
  public char getPlayer1() {
    return PLAYER_1;
  }

  @Override
  public char getPlayer2() {
    return PLAYER_2;
  }

  // not Used
  @Override
  public void setTurnTruth(char turn) {
    // TODO Auto-generated method stub

  }

  // Not used
  @Override
  public boolean getTurnTruth(char turn) {
    return false;
  }

  @Override
  public JsonObject toJSON() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int hashCode() {
    return this.getBoard().hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Connect4 && this.getBoard().equals(((Connect4) obj).getBoard())
        && ((Connect4) obj).getCyclic() == this.getCyclic();
  }

  private boolean getCyclic() {
    return isCyclic;
  }

}