package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import MathResearch2019.Errors.TurnMismatchError;

/**
 * Connect4
 */
public class Connect4 implements Game {

  private boolean isCyclic;

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
    return false;
  }

  @Override
  public boolean checkStalemateStatus() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean seeStalemateStatus() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean seeVictoryStatus() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getBoard() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<Game> possibleMoves(char turn) throws TurnMismatchError {
    ArrayList<Game> Arraylist = new ArrayList<Game>();
    return null;
  }

  @Override
  public char getPlayer1() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public char getPlayer2() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public void setTurnTruth(char turn) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean getTurnTruth(char turn) {
    // TODO Auto-generated method stub
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