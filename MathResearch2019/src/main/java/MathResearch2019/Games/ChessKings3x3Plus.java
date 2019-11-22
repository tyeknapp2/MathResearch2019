package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import MathResearch2019.Errors.*;

/**
 * 
 * Follows the
 * 
 * @author TyeKnappenberger
 *
 * @see ChessKings3x3
 */
public class ChessKings3x3Plus implements Game {

  private String board;
  private char toMove;
  public static final char PLAYER_1 = 'W';
  public static final char PLAYER_2 = 'B';

  /**
   * 
   */
  public ChessKings3x3Plus() {
    board = "WeeeeeeeB";
    toMove = 'W';
    /*
     * p1Gone = false; p2Gone = false;
     */
  }

  public ChessKings3x3Plus(String b) throws InvalidBoardString {
    if (b.length() != 10) {
      throw new InvalidBoardString(b
          + " is not a valid length. Proper board format is the first nine characters represent the board, the last character represents the piece to move in the next reconfiguration.");
    }
    board = b.substring(0, 9);
    toMove = b.charAt(9);

  }

  @Override
  public boolean checkVictory() {
    // No possible victory
    return false;
  }

  @Override
  public boolean checkStalemateStatus() {
    // No possible stalemate
    return false;
  }

  @Override
  public boolean seeStalemateStatus() {
    // No possible stalemate
    return false;
  }

  @Override
  public boolean seeVictoryStatus() {
    // No possible victory
    return false;
  }

  @Override
  public String getBoard() {
    return board + toMove;
  }

  @Override
  public ArrayList<Game> possibleMoves(char turn) throws TurnMismatchError {
    if (turn != toMove)
      throw new TurnMismatchError("Parameter turn: " + turn + " does not equal toMove: " + toMove);
    ArrayList<Game> possMoves = new ArrayList<Game>();
    int x = board.indexOf(turn);
    String s;
    try {
      if (x == 0) {
        s = "e" + turn + board.substring(2);
        if (validMove(s, turn))
          possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
        s = board.substring(0, 3).replace(turn, 'e') + turn + board.substring(4);
        if (validMove(s, turn))
          possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
      } else if (x == 1) {
        for (int i = 0; i < 6; i++) {
          if (!(i == 1)) {
            s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');

            if (validMove(s, turn))
              possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
          }
        }

      } else if (x == 2) {
        for (int i = 1; i < 6; i++) {
          if (i == 2 || i == 3) {
            continue;
          }
          s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
          if (validMove(s, turn))
            possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
        }

      } else if (x == 3) {
        for (int i = 0; i < 8; i++) {
          if (i == 2 || i == 5 || i == 3) {
            continue;
          }
          s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
          if (validMove(s, turn))
            possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
        }

      } else if (x == 5) {
        for (int i = 1; i < 9; i++) {
          if (i == 3 || i == 6 || i == 5) {
            continue;
          }
          s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
          if (validMove(s, turn))
            possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
        }
      } else if (x == 6) {
        for (int i = 3; i < 8; i++) {
          if (i == 5 || i == 6) {
            continue;
          }
          s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
          if (validMove(s, turn))
            possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
        }
      } else if (x == 7) {
        for (int i = 3; i < 9; i++) {
          if (i == 7) {
            continue;
          }
          s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
          if (validMove(s, turn))
            possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
        }
      } else if (x == 8) {
        for (int i = 4; i < 8; i++) {
          if (i == 6) {
            continue;
          }
          s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
          if (validMove(s, turn))
            possMoves.add(new ChessKings3x3Plus(s + (toMove == PLAYER_1 ? PLAYER_2 : PLAYER_1)));
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return possMoves;
  }

  private boolean validMove(String s, char turn) {
    int x = s.indexOf(turn);
    if (x == 4)
      return false;
    if (x != 2 && x != 5 && x + 1 < 9 && s.charAt(x + 1) != 'e')
      return false;
    if (x != 6 && x != 3 && x - 1 >= 0 && s.charAt(x - 1) != 'e')
      return false;
    if (x + 3 < 9 && s.charAt(x + 3) != 'e')
      return false;
    if (x - 3 >= 0 && s.charAt(x - 3) != 'e')
      return false;
    if (x != 0 && x != 3 && x != 6 && x + 2 < 9 && s.charAt(x + 2) != 'e')
      return false;
    if (x != 8 && x != 5 && x != 2 && x - 2 >= 0 && s.charAt(x - 2) != 'e')
      return false;
    if (x != 2 && x + 4 < 9 && s.charAt(x + 4) != 'e')
      return false;
    if (x != 6 && x - 4 >= 0 && s.charAt(x - 4) != 'e')
      return false;

    return true;
  }

  @Override
  public String toString() {

    int l = -1;
    return "" + toMove + "\'s turn to move:\n" + board.charAt(++l) + " " + board.charAt(++l) + " " + board.charAt(++l)
        + "\n" + board.charAt(++l) + " " + board.charAt(++l) + " " + board.charAt(++l) + "\n" + board.charAt(++l) + " "
        + board.charAt(++l) + " " + board.charAt(++l) + "\n";
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
    return obj instanceof ChessKings3x3Plus && this.getBoard().equals(((ChessKings3x3Plus) obj).getBoard());
  }

  @Override
  public int hashCode() {
    return this.getBoard().hashCode();
  }

}