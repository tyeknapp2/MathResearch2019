package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

/**
 *
 * @author TyeKnappenberger
 *
 * @deprecated Replaced by {@link TicTacToeNxN}
 */
public class TicTacToe4x4 implements Game {

  private String board;

  private boolean victoryStatus;

  private boolean stalemateStatus;

  public final char PLAYER_1 = 'O';

  public final char PLAYER_2 = 'X';

  public TicTacToe4x4() {
    board = "eeeeeeeeeeeeeeee";
    victoryStatus = false;
    stalemateStatus = false;
  }

  public TicTacToe4x4(String newBoard) {
    board = newBoard;
    this.checkVictory();
  }

  @Override
  public boolean checkVictory() {
    stalemateStatus = false;
    char[][] arrBoard = new char[4][4];
    int index = 0;
    for (int i = 0; i < 4; i++)
      for (int j = 0; j < 4; j++)
        arrBoard[i][j] = board.charAt(index++);

    index = 0;

    // corners check
    if (arrBoard[0][0] != 'e' && arrBoard[0][0] == arrBoard[0][3] && arrBoard[0][0] == arrBoard[3][0]
        && arrBoard[0][0] == arrBoard[3][3]) {
      victoryStatus = true;
      return true;
    }
    // diagonal checks
    if (arrBoard[0][0] != 'e' && arrBoard[0][0] == arrBoard[1][1] && arrBoard[0][0] == arrBoard[2][2]
        && arrBoard[0][0] == arrBoard[3][3]) {
      victoryStatus = true;
      return true;
    }
    if (arrBoard[0][3] != 'e' && arrBoard[0][3] == arrBoard[1][2] && arrBoard[0][3] == arrBoard[2][1]
        && arrBoard[0][3] == arrBoard[3][0]) {
      victoryStatus = true;
      return true;
    }
    // horizontal checks
    for (int i = 0; i < 4; i++) {
      char c = arrBoard[i][0];
      if (c != 'e')
        for (int j = 1; j <= 4; j++) {
          if (j == 4) {
            victoryStatus = true;
            return true;
          } else if (arrBoard[i][j] != c) {
            break;
          }
        }
    }
    // vertical checks
    for (int i = 0; i < 4; i++) {
      char c = arrBoard[0][i];
      if (c != 'e')
        for (int j = 1; j <= 4; j++) {
          if (j == 4) {
            victoryStatus = true;
            return true;
          } else if (arrBoard[j][i] != c) {
            break;
          }
        }
    }
    // square checks
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (arrBoard[i][j] != 'e' && arrBoard[i][j] == arrBoard[i + 1][j] && arrBoard[i][j] == arrBoard[i][j + 1]
            && arrBoard[i][j] == arrBoard[i + 1][j + 1]) {
          victoryStatus = true;
          return true;
        }
      }
    }
    checkStalemateStatus();
    return false;
  }

  @Override
  public boolean checkStalemateStatus() {
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
      for (int i = 0; i < 16; i++) {
        if (board.charAt(i) == 'e') {
          if (i < 15)
            moves.add(new TicTacToe4x4(board.substring(0, i) + turn + board.substring(i + 1)));
          else
            moves.add(new TicTacToe4x4(board.substring(0, i) + turn));
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

  /*
   * method does not apply to TicTacToe since TicTacToe has linear game
   * progression
   */
  @Override
  public void setTurnTruth(char turn) {

  }

  /*
   * method does not apply to TicTacToe since TicTacToe has linear game
   * progression
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

  @Override
  public boolean equals(Object obj) {
    return obj instanceof TicTacToe4x4 && this.board.equals(((TicTacToe4x4) obj).getBoard());
  }
}
