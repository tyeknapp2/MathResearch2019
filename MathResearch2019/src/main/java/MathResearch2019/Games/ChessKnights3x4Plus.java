package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import MathResearch2019.Errors.TurnMismatchError;

/**
 * @author TyeKnappenberger
 *
 * @see ChessKnights3x4
 */
public class ChessKnights3x4Plus implements Game {

  private boolean victoryStatus;
  private String board;
  private char toMove;
  public final char PLAYER_1 = 'W';
  public final char PLAYER_2 = 'B';

  /**
   * <p>
   * Checks and sets the victory status of the game. A game of knights is
   * considered won if one of either two knights have been eliminated.
   * 
   * 
   * @return victoryStatus
   */
  @Override
  public boolean checkVictory() {
    victoryStatus = !board.contains("W") || !board.contains("B");
    return victoryStatus;
  }

  /**
   * No Stalemates in Knights.
   * 
   * @return false
   */
  @Override
  public boolean checkStalemateStatus() {
    return false;
  }

  /**
   * No Stalemates in Knights.
   * 
   * @return false
   */
  @Override
  public boolean seeStalemateStatus() {
    return false;
  }

  /**
   * Gets the victory status of the game.
   * 
   * @return victoryStatus
   */
  @Override
  public boolean seeVictoryStatus() {
    return victoryStatus;
  }

  /**
   * Gets the board and appends the player's whose turn it is to the end.
   * 
   * @return board + toMove
   */
  @Override
  public String getBoard() {
    return board + toMove;
  }

  /**
   * <p>
   * Returns a list of boards based on moving the piece specified in the
   * parameter. It moves that color knight to every possible position it could be
   * in for the next turn and outputs the string used to instantiate the next
   * turn.
   * 
   * @param turn The piece that you wish to move. Must match <code>toMove</code>.
   * @throws TurnMismatchError If <code>turn</code> does not match
   *                           <code>toMove</code> then it throws this error
   * @return An <code>ArrayList</code> of <code>Strings</code> used to instantiate
   *         new <code>ChessKnights3x4Plus</code> that represent the next turns
   *         after moving the knight of the color specified by <code>turn</code>.
   */
  @Override
  public ArrayList<String> possibleMoves(char turn) throws TurnMismatchError {
    ArrayList<String> possMoves = new ArrayList<String>();
    if (!victoryStatus) {
      char nextToMove = toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1;
      int index = board.indexOf(turn);
      int row = getRow(index);
      int col = getCol(index);

      String s = board.substring(0, index) + 'e' + board.substring(index + 1);
      if (row + 2 < 3 && col + 1 < 4) {
        String g = s.substring(0, indexFromRowAndColumn(row + 2, col + 1)) + nextToMove
            + s.substring(indexFromRowAndColumn(row + 2, col + 1) + 1);
        possMoves.add(g);
      }
      if (row + 2 < 3 && col - 1 >= 0) {
        String g = s.substring(0, indexFromRowAndColumn(row + 2, col - 1)) + nextToMove
            + s.substring(indexFromRowAndColumn(row + 2, col - 1) + 1);
        possMoves.add(g);
      }
      if (row - 2 >= 0 && col + 1 < 4) {
        String g = s.substring(0, indexFromRowAndColumn(row - 2, col + 1)) + nextToMove
            + s.substring(indexFromRowAndColumn(row - 2, col + 1) + 1);
        possMoves.add(g);
      }
      if (row - 2 >= 0 && col - 1 >= 0) {
        String g = s.substring(0, indexFromRowAndColumn(row - 2, col - 1)) + nextToMove
            + s.substring(indexFromRowAndColumn(row - 2, col - 1) + 1);
        possMoves.add(g);
      }
      if (row + 1 < 3 && col + 2 < 4) {
        String g = s.substring(0, indexFromRowAndColumn(row + 1, col + 1)) + nextToMove
            + s.substring(indexFromRowAndColumn(row + 1, col + 1) + 1);
        possMoves.add(g);
      }
      if (row + 1 < 3 && col - 2 >= 0) {
        String g = s.substring(0, indexFromRowAndColumn(row + 1, col - 2)) + nextToMove
            + s.substring(indexFromRowAndColumn(row + 1, col - 2) + 1);
        possMoves.add(g);
      }
      if (row - 1 >= 0 && col + 2 < 4) {
        String g = s.substring(0, indexFromRowAndColumn(row - 1, col + 2)) + nextToMove
            + s.substring(indexFromRowAndColumn(row - 1, col + 2) + 1);
        possMoves.add(g);
      }
      if (row - 1 >= 0 && col - 2 >= 0) {
        String g = s.substring(0, indexFromRowAndColumn(row - 1, col - 2)) + nextToMove
            + s.substring(indexFromRowAndColumn(row - 1, col - 2) + 1);
        possMoves.add(g);
      }
    }
    return possMoves;
  }

  /**
   * @param indexInString index of the piece to move in the <code>board</code>
   *                      <code>String</code>.
   * @return
   */
  private int getRow(int indexInString) {
    return indexInString / 4;
  }

  private int getCol(int indexInString) {
    return indexInString % 4;
  }

  /**
   * Takes an X and Y coordinate and turns it into an index in the board string.
   * 
   * @param row X coordinate on the board
   * @param col Y coordinate on the board
   * @return index in <code>board</code>
   */
  private int indexFromRowAndColumn(int row, int col) {
    return 4 * row + col;
  }

  /**
   * Returns the char representation of the first player.
   * 
   * @return PLAYER_1 W for white
   */
  @Override
  public char getPlayer1() {
    return PLAYER_1;
  }

  /**
   * Returns the char representation of the second player.
   * 
   * @return PLAYER_2 B for black
   */
  @Override
  public char getPlayer2() {
    return PLAYER_2;
  }

  /**
   * Not applicable to this game.
   */
  @Override
  public void setTurnTruth(char turn) {
  }

  /**
   * Not applicable to this game
   * 
   * @return true
   */
  @Override
  public boolean getTurnTruth(char turn) {
    return true;
  }

  @Override
  public JsonObject toJSON() {
    // TODO Auto-generated method stub
    return null;
  }

}