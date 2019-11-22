/**
 * 
 */
package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

/**
 * Three by three Tic-Tac-Toe.
 * 
 * @author TyeKnappenberger
 * @deprecated Replaced by {@link TicTacToeNxN}
 */
public class TicTacToe3x3 implements Game {

  private String board;

  private boolean victoryStatus;

  private boolean stalemateStatus;

  public final char PLAYER_1 = 'O';

  public final char PLAYER_2 = 'X';

  // produces an empty board board
  public TicTacToe3x3() {
    board = "eeeeeeeee";
    victoryStatus = false;
    stalemateStatus = false;
  }

  public TicTacToe3x3(String newBoard) {
    board = newBoard;
    this.checkVictory();
  }

  /*
   * returns an ArrayList of strings that can be used to make boards for the next
   * turn Throws an error if the character is not an X or O
   */
  @Override
  public ArrayList<String> possibleMoves(char turn) {
    ArrayList<String> moves = new ArrayList<String>();
    if (!stalemateStatus && !victoryStatus)
      for (int i = 0; i < 9; i++) {
        if (board.charAt(i) == 'e') {
          if (i < 8)
            moves.add(board.substring(0, i) + turn + board.substring(i + 1));
          else
            moves.add(board.substring(0, i) + turn);
        }
      }
    return moves;
  }

  /*
   * checks whether a game has been won by either player if neither player has won
   * then a check for a stalemate is initiated
   */
  @Override
  public boolean checkVictory() {
    stalemateStatus = false;
    // horizontal checks
    if (board.charAt(0) == board.charAt(1) && board.charAt(0) == board.charAt(2) && board.charAt(0) != 'e') {
      victoryStatus = true;
      return true;
    } else if (board.charAt(3) == board.charAt(4) && board.charAt(3) == board.charAt(5) && board.charAt(3) != 'e') {
      victoryStatus = true;
      return true;
    } else if (board.charAt(6) == board.charAt(7) && board.charAt(6) == board.charAt(8) && board.charAt(6) != 'e') {
      victoryStatus = true;
      return true;
    }
    // vertical checks
    else if (board.charAt(0) == board.charAt(3) && board.charAt(0) == board.charAt(6) && board.charAt(0) != 'e') {
      victoryStatus = true;
      return true;
    } else if (board.charAt(1) == board.charAt(4) && board.charAt(1) == board.charAt(7) && board.charAt(1) != 'e') {
      victoryStatus = true;
      return true;
    } else if (board.charAt(2) == board.charAt(5) && board.charAt(8) == board.charAt(2) && board.charAt(2) != 'e') {
      victoryStatus = true;
      return true;
    }
    // diagonal checks
    else if (board.charAt(0) == board.charAt(4) && board.charAt(0) == board.charAt(8) && board.charAt(0) != 'e') {
      victoryStatus = true;
      return true;
    } else if (board.charAt(2) == board.charAt(4) && board.charAt(2) == board.charAt(6) && board.charAt(2) != 'e') {
      victoryStatus = true;
      return true;
    }
    // no victor
    else {
      victoryStatus = false;
      stalemateStatus = checkStalemateStatus();
      return false;
    }
  }

  /*
   * A sub-method of checkVictoryStatus that checks and updates the stalemate
   * status of a game if a game does not yet have a winner it is possible the game
   * is in a stalemate and no one won it does not check for impossibility of a
   * winner so a game in which a winner cannot be attained will proceed till all
   * nine squares are full
   */
  @Override
  public boolean checkStalemateStatus() {
    if (board.contains("e"))
      return false;
    return true;
  }

  // returns whether or not the board is full and no player is the victor
  @Override
  public boolean seeStalemateStatus() {
    return stalemateStatus;
  }

  // returns the victory status of the board in question
  @Override
  public boolean seeVictoryStatus() {
    return victoryStatus;
  }

  // returns the raw board string used for behind the scenes code
  @Override
  public String getBoard() {
    return board;
  }

  // Turns a TicTacToe3X3 object into a readable format
  @Override
  public String toString() {
    /*
     * This long return statement formats the TicTacToe board so it looks a standard
     * one might draw on a piece of paper it checks each character to ensure that
     * any e's are turned into empty spaces in order to increase readability it
     * would turn XOeOOeeeX into X | O | --------- O | O | --------- | | X
     * 
     */
    return ((this.board.charAt(0) != 'e') ? this.board.charAt(0) : " ") + " | "
        + ((this.board.charAt(1) != 'e') ? this.board.charAt(1) : " ") + " | "
        + ((this.board.charAt(2) != 'e') ? this.board.charAt(2) : " ") + "\n" + "---------\n"
        + ((this.board.charAt(3) != 'e') ? this.board.charAt(3) : " ") + " | "
        + ((this.board.charAt(4) != 'e') ? this.board.charAt(4) : " ") + " | "
        + ((this.board.charAt(5) != 'e') ? this.board.charAt(5) : " ") + "\n" + "---------\n"
        + ((this.board.charAt(6) != 'e') ? this.board.charAt(6) : " ") + " | "
        + ((this.board.charAt(7) != 'e') ? this.board.charAt(7) : " ") + " | "
        + ((this.board.charAt(8) != 'e') ? this.board.charAt(8) : " ");
    // return this.board+"\n"+victoryStatus+"\n"+stalemateStatus+"";
  }

  @Override
  public char getPlayer1() {
    return PLAYER_1;
  }

  @Override
  public char getPlayer2() {
    return PLAYER_2;
  }

  @Override
  public void setTurnTruth(char turn) {

  }

  @Override
  public boolean getTurnTruth(char turn) {

    return true;
  }

  @Override
  public JsonObject toJSON() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TicTacToe3x3 && this.board.equals(((TicTacToe3x3) obj).getBoard());
  }
}
