package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

public class ChessKings3x3 implements Game {

  private String board;

  public static final char PLAYER_1 = 'W';

  public static final char PLAYER_2 = 'B';

  private boolean p1Gone;
  private boolean p2Gone;

  public ChessKings3x3() {
    board = "WeeeeeeeB";
    p1Gone = false;
    p2Gone = false;
  }

  public ChessKings3x3(String b) {
    board = b;
    p1Gone = false;
    p2Gone = false;
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
    return board;
  }

  @Override
  public ArrayList<String> possibleMoves(char turn) {
    ArrayList<String> possMoves = new ArrayList<String>();
    int x = board.indexOf(turn);
    String s;
    if (x == 0) {
      s = "e" + turn + board.substring(2);
      if (validMove(s, turn))
        possMoves.add(s);
      s = board.substring(0, 3).replace(turn, 'e') + turn + board.substring(4);
      if (validMove(s, turn))
        possMoves.add(s);
    } else if (x == 1) {
      for (int i = 0; i < 6; i++) {
        if (!(i == 1)) {
          s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');

          if (validMove(s, turn))
            possMoves.add(s);
        }
      }

    } else if (x == 2) {
      for (int i = 1; i < 6; i++) {
        if (i == 2 || i == 3) {
          continue;
        }
        s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
        if (validMove(s, turn))
          possMoves.add(s);
      }

    } else if (x == 3) {
      for (int i = 0; i < 8; i++) {
        if (i == 2 || i == 5 || i == 3) {
          continue;
        }
        s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
        if (validMove(s, turn))
          possMoves.add(s);
      }

    } else if (x == 5) {
      for (int i = 1; i < 9; i++) {
        if (i == 3 || i == 6 || i == 5) {
          continue;
        }
        s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
        if (validMove(s, turn))
          possMoves.add(s);
      }
    } else if (x == 6) {
      for (int i = 3; i < 8; i++) {
        if (i == 5 || i == 6) {
          continue;
        }
        s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
        if (validMove(s, turn))
          possMoves.add(s);
      }
    } else if (x == 7) {
      for (int i = 3; i < 9; i++) {
        if (i == 7) {
          continue;
        }
        s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
        if (validMove(s, turn))
          possMoves.add(s);
      }
    } else if (x == 8) {
      for (int i = 4; i < 8; i++) {
        if (i == 6) {
          continue;
        }
        s = board.substring(0, i).replace(turn, 'e') + turn + board.substring(i + 1).replace(turn, 'e');
        if (validMove(s, turn))
          possMoves.add(s);
      }
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
    char[][] e = new char[3][3];
    int x = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        e[i][j] = board.charAt(x++);
      }
    }
    return "\n" + e[0][0] + " " + e[0][1] + " " + e[0][2] + "\n" + e[1][0] + " " + e[1][1] + " " + e[1][2] + "\n"
        + e[2][0] + " " + e[2][1] + " " + e[2][2] + "\n";
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
    if (turn == PLAYER_1) {
      p1Gone = true;
    } else if (turn == PLAYER_2) {
      p2Gone = true;
    }
    return;
  }

  @Override
  public boolean getTurnTruth(char turn) {
    if (turn == PLAYER_1) {
      return p1Gone;
    } else if (turn == PLAYER_2) {
      return p2Gone;
    }
    return true;
  }

  @Override
  public JsonObject toJSON() {
    // TODO Auto-generated method stub
    return null;
  }

}