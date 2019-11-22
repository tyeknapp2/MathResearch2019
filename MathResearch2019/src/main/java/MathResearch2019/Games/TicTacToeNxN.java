/**
 * 
 */
package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import MathResearch2019.Errors.InvalidBoardString;

/**
 * @author TyeKnappenberger
 *
 */
public class TicTacToeNxN implements Game {

  private String board;

  private boolean victoryStatus;

  private boolean stalemateStatus;

  public final char PLAYER_1 = 'O';

  public final char PLAYER_2 = 'X';

  private int boardSize;

  public TicTacToeNxN() {
    /**
     * Instantiates a blank 3x3 board
     */
    board = "eeeeeeeee";
    boardSize = 3;
    victoryStatus = false;
    stalemateStatus = false;
  }

  public TicTacToeNxN(int n) throws InvalidBoardString {
    if (n < 3)
      throw new InvalidBoardString("Must have a board size >= 3");
    /**
     * Instantiates a blank nxn
     */
    board = "";
    for (int i = 0; i < n * n; i++)
      board += "e";
    boardSize = n;
    victoryStatus = false;
    stalemateStatus = false;

  }

  public TicTacToeNxN(String s) throws InvalidBoardString {
    board = s;
    boardSize = (int) Math.sqrt((double) s.length());
    if (s.length() < 9 || s.length() % boardSize != 0)
      throw new InvalidBoardString(s + " is " + s.length()
          + " long. It is a not a valid length... Ensure the string length has an integer square root");
    checkVictory();
  }

  /**
   * For all board sizes, it checks the standard victory conditions: the
   * diagonals, horizontals and verticals
   * 
   * If the board size is greater than 3 then it checks the super Tic-Tac-Toe
   * conditions getting all four corners or four in a square.
   * 
   * If no victory condition is met, it checks for a stalemate.
   * 
   * Finally, it sets this board's victoryStatus.
   * 
   * @return boolean victoryStatus
   */
  @Override
  public boolean checkVictory() {

    stalemateStatus = false;

    char[][] arrBoard = convertBoardStringToBoardArr();

    // \ diagonal check
    for (int i = 1; i <= boardSize; i++) {
      if (i == boardSize) {
        victoryStatus = true;
        return true;
      }
      if (arrBoard[0][0] == 'e' || arrBoard[0][0] != arrBoard[i][i])
        break;
    }
    // / diagonal check
    for (int i = 1; i <= boardSize; i++) {
      if (i == boardSize) {
        victoryStatus = true;
        return true;
      }
      if (arrBoard[0][boardSize - 1] == 'e' || arrBoard[0][boardSize - 1] != arrBoard[i][boardSize - 1 - i])
        break;
    }

    // horizontal checks
    for (int i = 0; i < boardSize; i++) {
      char c = arrBoard[i][0];
      if (c != 'e')
        for (int j = 1; j <= boardSize; j++) {
          if (j == boardSize) {
            victoryStatus = true;
            return true;
          } else if (arrBoard[i][j] != c) {
            break;
          }
        }
    }
    // vertical checks
    for (int i = 0; i < boardSize; i++) {
      char c = arrBoard[0][i];
      if (c != 'e')
        for (int j = 1; j <= boardSize; j++) {
          if (j == boardSize) {
            victoryStatus = true;
            return true;
          } else if (arrBoard[j][i] != c) {
            break;
          }
        }
    }

    /**
     * 
     */
    if (boardSize > 3) {
      // corners check
      if (arrBoard[0][0] != 'e' && arrBoard[0][0] == arrBoard[0][boardSize - 1]
          && arrBoard[0][0] == arrBoard[boardSize - 1][0] && arrBoard[0][0] == arrBoard[boardSize - 1][boardSize - 1]) {
        victoryStatus = true;
        return true;
      }

      // square checks

      for (int i = 0; i < boardSize - 1; i++) {
        for (int j = 0; j < boardSize - 1; j++) {
          if (arrBoard[i][j] != 'e' && arrBoard[i][j] == arrBoard[i + 1][j] && arrBoard[i][j] == arrBoard[i][j + 1]
              && arrBoard[i][j] == arrBoard[i + 1][j + 1]) {
            victoryStatus = true;
            return true;
          }
        }
      }
    }
    /**
     * If no victory condition is met, it checks for a stalemate.
     */
    checkStalemateStatus();
    /**
     * Finally, it sets this board's victoryStatus.
     * 
     * @return victoryStatus
     */
    return false;
  }

  private char[][] convertBoardStringToBoardArr() {
    char[][] arrBoard = new char[boardSize][boardSize];
    int index = 0;
    for (int i = 0; i < boardSize; i++)
      for (int j = 0; j < boardSize; j++)
        arrBoard[i][j] = board.charAt(index++);
    return arrBoard;
  }

  @Override
  public boolean checkStalemateStatus() {
    // checks to see
    if (board.contains("e"))
      return false;

    stalemateStatus = true;
    return true;
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
  public ArrayList<Game> possibleMoves(char turn) {
    ArrayList<Game> moves = new ArrayList<Game>();
    if (!stalemateStatus && !victoryStatus)
      for (int i = 0; i < board.length(); i++) {
        if (board.charAt(i) == 'e') {
          try {
            if (i < board.length() - 1)
              moves.add(new TicTacToeNxN(board.substring(0, i) + turn + board.substring(i + 1)));
            else
              moves.add(new TicTacToeNxN(board.substring(0, i) + turn));
          } catch (Exception e) {
            e.printStackTrace();
          }
        }

      }

    return moves;
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
    /**
     * This method does not apply to the game of TicTacToe
     * 
     * @return null
     */

  }

  @Override
  public boolean getTurnTruth(char turn) {
    /**
     * @return true
     */
    return true;
  }

  public int getBoardSize() {
    return boardSize;
  }

  @Override
  public JsonObject toJSON() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TicTacToeNxN && this.board.equals(((TicTacToeNxN) obj).getBoard());
  }

  @Override
  public int hashCode() {
    return this.board.hashCode();
  }

}
