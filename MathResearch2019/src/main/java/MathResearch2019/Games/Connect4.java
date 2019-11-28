package MathResearch2019.Games;

import java.util.ArrayList;

import com.google.gson.JsonObject;

import MathResearch2019.Errors.InvalidBoardString;
import MathResearch2019.Errors.TurnMismatchError;

import java.util.regex.*;

/**
 * Connect4
 */
public class Connect4 implements Game {

  private String board;
  private boolean isCyclic;
  private final char PLAYER_2 = 'B';
  private final char PLAYER_1 = 'R';
  private byte rows;
  private byte cols;
  private boolean victoryStatus;
  private boolean stalemateStatus;

  public Connect4() {
    byte i = 4;
    byte j = 4;
    rows = i;
    cols = j;
    for (int g = 0; g < i; g++) {
      for (int h = 0; h < j; h++)
        board += "e";
    }
    isCyclic = false;
    victoryStatus = false;
    stalemateStatus = false;
  }

  public Connect4(byte i, byte j) throws InvalidBoardString {
    if (i < 4 && j < 4)
      throw new InvalidBoardString("Board too small");

    for (int g = 0; g < i; g++) {
      for (int h = 0; h < j; h++)
        board += "e";
    }
    rows = i;
    cols = j;
    isCyclic = false;
    victoryStatus = false;
    stalemateStatus = false;
  }

  public Connect4(byte i, byte j, boolean b) throws InvalidBoardString {
    if (i < 4 && j < 4)
      throw new InvalidBoardString("Board too small");
    for (int g = 0; g < i; g++) {
      for (int h = 0; h < j; h++)
        board += "e";
    }
    rows = i;
    cols = j;
    isCyclic = b;
    victoryStatus = false;
    stalemateStatus = false;
  }

  public Connect4(String string, byte r, byte c) throws InvalidBoardString {
    if (string.length() != (int) r * (int) c) {
      throw new InvalidBoardString("Input String and size don't match");
    }
    board = string;
    rows = r;
    cols = c;
    isCyclic=false;
    checkVictory();
  }

  public Connect4(String string, byte r, byte c, boolean b) {
  }

  @Override
  public boolean checkVictory() {
    // TODO Auto-generated method stub
    return victoryStatus;
  }

  @Override
  public boolean checkStalemateStatus() {
    stalemateStatus = !board.contains("e");
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

  // For c4Test possMoves and testVictory/stalemate
  public static void printC4Boards(int numBoards) {
    for (int i = 0; i < numBoards; i++) {
      ArrayList<Character> col1Stack = new ArrayList<Character>(), col2Stack = new ArrayList<Character>(),
          col3Stack = new ArrayList<Character>(), col4Stack = new ArrayList<Character>(),
          col5Stack = new ArrayList<Character>(), col6Stack = new ArrayList<Character>(),
          col7Stack = new ArrayList<Character>();
      boolean col1 = true, col2 = true, col3 = true, col4 = true, col5 = true, col6 = true, col7 = true,
          victory = false;
      double col1d = Math.random() * .4 + .6, col2d = Math.random() * .4 + .6, col3d = Math.random() * .4 + .6,
          col4d = Math.random() * .4 + .6, col5d = Math.random() * .4 + .6, col6d = Math.random() * .4 + .6,
          col7d = Math.random() * .4 + .6;
      int rCount = (6 * 7) / 2, bCount = (6 * 7) / 2, numMoves = 0;
      for (int j = 0; j < 6; j++) {
        numMoves = 0;
        if (!victory) {
          String row = "";
          if (col1 && !victory) {
            col1Stack.add((bCount > 0)
                ? ((rCount > 0) ? ((Math.random() < (double) rCount / (double) (rCount + bCount)) ? 'R' : 'B') : 'B')
                : 'R');
            rCount += (col1Stack.get(j) == 'R') ? -1 : 0;
            bCount += (col1Stack.get(j) == 'B') ? -1 : 0;
            row += "" + col1Stack.get(j);
            if (j >= 3) {
              victory = col1Stack.get(j) == col1Stack.get(j - 1) && col1Stack.get(j) == col1Stack.get(j - 2)
                  && col1Stack.get(j) == col1Stack.get(j - 3);
              victory = victory || col1Stack.get(j) == col2Stack.get(j - 1) && col1Stack.get(j) == col3Stack.get(j - 2)
                  && col1Stack.get(j) == col4Stack.get(j - 3);
            }
            col1 = !(Math.random() > col1d);
          } else {
            col1Stack.add('e');
            numMoves++;
            row += "" + col1Stack.get(j);
          }
          victory = victory || row.contains("RRRR") || row.contains("BBBB");
          if (col2 && !victory) {
            col2Stack.add((bCount > 0)
                ? ((rCount > 0) ? ((Math.random() < (double) rCount / (double) (rCount + bCount)) ? 'R' : 'B') : 'B')
                : 'R');
            rCount += (col2Stack.get(j) == 'R') ? -1 : 0;
            bCount += (col2Stack.get(j) == 'B') ? -1 : 0;
            row += "" + col2Stack.get(j);
            if (j >= 3) {
              victory = col2Stack.get(j) == col2Stack.get(j - 1) && col2Stack.get(j) == col2Stack.get(j - 2)
                  && col2Stack.get(j) == col2Stack.get(j - 3);
              victory = victory || col2Stack.get(j) == col3Stack.get(j - 1) && col2Stack.get(j) == col4Stack.get(j - 2)
                  && col2Stack.get(j) == col5Stack.get(j - 3);
            }
            col2 = !(Math.random() > col2d);
          } else {
            col2Stack.add('e');
            numMoves++;
            row += "" + col2Stack.get(j);
          }
          victory = victory || row.contains("RRRR") || row.contains("BBBB");
          if (col3 && !victory) {
            col3Stack.add((bCount > 0)
                ? ((rCount > 0) ? ((Math.random() < (double) rCount / (double) (rCount + bCount)) ? 'R' : 'B') : 'B')
                : 'R');
            rCount += (col3Stack.get(j) == 'R') ? -1 : 0;
            bCount += (col3Stack.get(j) == 'B') ? -1 : 0;
            row += "" + col3Stack.get(j);
            if (j >= 3) {
              victory = col3Stack.get(j) == col3Stack.get(j - 1) && col3Stack.get(j) == col3Stack.get(j - 2)
                  && col3Stack.get(j) == col3Stack.get(j - 3);
              victory = victory || col3Stack.get(j) == col4Stack.get(j - 1) && col3Stack.get(j) == col5Stack.get(j - 2)
                  && col3Stack.get(j) == col6Stack.get(j - 3);
            }
            col3 = !(Math.random() > col3d);
          } else {
            col3Stack.add('e');
            numMoves++;
            row += "" + col3Stack.get(j);
          }
          victory = victory || row.contains("RRRR") || row.contains("BBBB");
          if (col4 && !victory) {
            col4Stack.add((bCount > 0)
                ? ((rCount > 0) ? ((Math.random() < (double) rCount / (double) (rCount + bCount)) ? 'R' : 'B') : 'B')
                : 'R');
            rCount += (col4Stack.get(j) == 'R') ? -1 : 0;
            bCount += (col4Stack.get(j) == 'B') ? -1 : 0;
            row += "" + col4Stack.get(j);
            if (j >= 3) {
              victory = col4Stack.get(j) == col4Stack.get(j - 1) && col4Stack.get(j) == col4Stack.get(j - 2)
                  && col4Stack.get(j) == col4Stack.get(j - 3);
              victory = victory || col4Stack.get(j) == col5Stack.get(j - 1) && col4Stack.get(j) == col6Stack.get(j - 2)
                  && col4Stack.get(j) == col7Stack.get(j - 3);
              victory = victory || col4Stack.get(j) == col3Stack.get(j - 1) && col4Stack.get(j) == col2Stack.get(j - 2)
                  && col4Stack.get(j) == col1Stack.get(j - 3);
            }
            col4 = !(Math.random() > col4d);
          } else {
            col4Stack.add('e');
            numMoves++;
            row += "" + col4Stack.get(j);
          }
          victory = victory || row.contains("RRRR") || row.contains("BBBB");
          if (col5 && !victory) {
            col5Stack.add((bCount > 0)
                ? ((rCount > 0) ? ((Math.random() < (double) rCount / (double) (rCount + bCount)) ? 'R' : 'B') : 'B')
                : 'R');
            rCount += (col5Stack.get(j) == 'R') ? -1 : 0;
            bCount += (col5Stack.get(j) == 'B') ? -1 : 0;
            row += "" + col5Stack.get(j);
            if (j >= 3) {
              victory = col5Stack.get(j) == col5Stack.get(j - 1) && col5Stack.get(j) == col5Stack.get(j - 2)
                  && col5Stack.get(j) == col5Stack.get(j - 3);
              victory = victory || col5Stack.get(j) == col4Stack.get(j - 1) && col5Stack.get(j) == col3Stack.get(j - 2)
                  && col5Stack.get(j) == col2Stack.get(j - 3);
            }
            col5 = !(Math.random() > col5d);
          } else {
            col5Stack.add('e');
            numMoves++;
            row += "" + col5Stack.get(j);
          }
          victory = victory || row.contains("RRRR") || row.contains("BBBB");
          if (col6 && !victory) {
            col6Stack.add((bCount > 0)
                ? ((rCount > 0) ? ((Math.random() < (double) rCount / (double) (rCount + bCount)) ? 'R' : 'B') : 'B')
                : 'R');
            rCount += (col6Stack.get(j) == 'R') ? -1 : 0;
            bCount += (col6Stack.get(j) == 'B') ? -1 : 0;
            row += "" + col6Stack.get(j);
            if (j >= 3) {
              victory = col6Stack.get(j) == col6Stack.get(j - 1) && col6Stack.get(j) == col6Stack.get(j - 2)
                  && col6Stack.get(j) == col6Stack.get(j - 3);
              victory = victory || col6Stack.get(j) == col5Stack.get(j - 1) && col6Stack.get(j) == col4Stack.get(j - 2)
                  && col6Stack.get(j) == col3Stack.get(j - 3);
            }
            col6 = !(Math.random() > col6d);
          } else {
            col6Stack.add('e');
            numMoves++;
            row += "" + col6Stack.get(j);
          }
          victory = victory || row.contains("RRRR") || row.contains("BBBB");
          if (col7 && !victory) {
            col7Stack.add((bCount > 0)
                ? ((rCount > 0) ? ((Math.random() < (double) rCount / (double) (rCount + bCount)) ? 'R' : 'B') : 'B')
                : 'R');
            rCount += (col7Stack.get(j) == 'R') ? -1 : 0;
            bCount += (col7Stack.get(j) == 'B') ? -1 : 0;
            row += "" + col7Stack.get(j);
            if (j >= 3) {
              victory = col7Stack.get(j) == col7Stack.get(j - 1) && col7Stack.get(j) == col7Stack.get(j - 2)
                  && col7Stack.get(j) == col7Stack.get(j - 3);
              victory = victory || col7Stack.get(j) == col6Stack.get(j - 1) && col7Stack.get(j) == col5Stack.get(j - 2)
                  && col7Stack.get(j) == col4Stack.get(j - 3);
            }
            col7 = !(Math.random() > col7d);
          } else {
            col7Stack.add('e');
            numMoves++;
            row += "" + col7Stack.get(j);
          }
          victory = victory || row.contains("RRRR") || row.contains("BBBB");
        } else {
          numMoves = 0;
          col1Stack.add('e');
          col2Stack.add('e');
          col3Stack.add('e');
          col4Stack.add('e');
          col5Stack.add('e');
          col6Stack.add('e');
          col7Stack.add('e');
        }

      }

      if (Math.abs(rCount - bCount) <= 1) {
        String board = "";
        for (int j = 5; j >= 0; j--) {
          board += col1Stack.get(j) + "" + col2Stack.get(j) + col3Stack.get(j) + col4Stack.get(j) + col5Stack.get(j)
              + col6Stack.get(j) + col7Stack.get(j);
        }
        System.out.println("\"" + board + ",6,7," + ((victory) ? 0 : numMoves) + "\",");
      } else {
        i--;
      }
    }

  }

}