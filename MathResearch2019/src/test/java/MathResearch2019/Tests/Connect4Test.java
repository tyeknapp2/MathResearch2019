package MathResearch2019.Tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import MathResearch2019.Errors.InvalidBoardString;
import MathResearch2019.Errors.TurnMismatchError;
import MathResearch2019.Games.Connect4;

/**
 * Connect4Test
 */
public class Connect4Test {

  @Test
  public void testBoardSize() {
    assertThrows(InvalidBoardString.class, () -> {
      new Connect4(3, 3);
    });
    assertThrows(InvalidBoardString.class, () -> {
      new Connect4(3, 3, true);
    });
    assertThrows(InvalidBoardString.class, () -> {
      new Connect4("eeeeeeee");
    });
    assertThrows(InvalidBoardString.class, () -> {
      new Connect4("eeeeeeee", true);
    });
  }

  @Test
  public void testPossMoves() {
    Connect4 connect4 = new Connect4("eeeeeeeeeeee");
    try {
      connect4.possibleMoves('R').contains(new Connect4("eeeeeeeeeeeR"));
      connect4.possibleMoves('R').contains(new Connect4("eeeeeeeeeeRe"));
      connect4.possibleMoves('R').contains(new Connect4("eeeeeeeeeRee"));
      connect4.possibleMoves('R').contains(new Connect4("eeeeeeeeReee"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeeeeeeeeB"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeeeeeeeBe"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeeeeeeBee"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeeeeeBeee"));
    } catch (TurnMismatchError e) {
      e.printStackTrace();
    }
    connect4 = new Connect4("eeeeeeeeRBeR");
    try {
      connect4.possibleMoves('R').contains(new Connect4("eeeeeeeRRBeR"));
      connect4.possibleMoves('R').contains(new Connect4("eeeeeeeeRBRR"));
      connect4.possibleMoves('R').contains(new Connect4("eeeeeReeRBeR"));
      connect4.possibleMoves('R').contains(new Connect4("eeeeReeeRBeR"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeeeeBRBeR"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeeeeeRBBR"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeeBeeRBeR"));
      connect4.possibleMoves('B').contains(new Connect4("eeeeBeeeRBeR"));
    } catch (TurnMismatchError e) {
      e.printStackTrace();
    }
  }

}