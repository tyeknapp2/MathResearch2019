package MathResearch2019.Tests;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import MathResearch2019.Errors.*;
import MathResearch2019.Games.Game;
import MathResearch2019.Games.ChessKings3x3Plus;

/**
 * @author TyeKnappenberger
 *
 */
public class ChessKings3x3PlusTest {

  @Test
  public void testConstructors() {
    assertTrue((new ChessKings3x3Plus()).getBoard().equals("WeeeeeeeBW"));
    try {
      assertTrue((new ChessKings3x3Plus("eWeeeeeeBB")).getBoard().equals("eWeeeeeeBB"));
    } catch (InvalidBoardString e) {
      fail();
      e.printStackTrace();
    }
    assertThrows(InvalidBoardString.class, () -> {
      new ChessKings3x3Plus("eWeeeeeeB");
    });
  }

  @Test
  public void testToString() {
    String s = "W\'s turn to move:\nW e e\ne e e\ne e B\n";
    assertTrue(s.equals((new ChessKings3x3Plus()).toString()));
  }

  @Test
  public void testPossibleMovesIntense() {
    Game chess = new ChessKings3x3Plus();
    try {
      assertTrue(chess.possibleMoves(chess.getPlayer1()).size() == 2);
      assertTrue(chess.possibleMoves(chess.getPlayer1()).contains(new ChessKings3x3Plus("eWeeeeeeBB")));
      assertTrue(chess.possibleMoves(chess.getPlayer1()).contains(new ChessKings3x3Plus("eeeWeeeeBB")));
      chess = new ChessKings3x3Plus("WeeeeeeeBB");
      assertTrue(chess.possibleMoves(chess.getPlayer2()).size() == 2);
      assertTrue(chess.possibleMoves(chess.getPlayer2()).contains(new ChessKings3x3Plus("WeeeeBeeeW")));
      assertTrue(chess.possibleMoves(chess.getPlayer2()).contains(new ChessKings3x3Plus("WeeeeeeBeW")));
      chess = new ChessKings3x3Plus("eWeeeeeeBB");
      assertTrue(chess.possibleMoves(chess.getPlayer2()).size() == 1);
      assertTrue(chess.possibleMoves(chess.getPlayer2()).contains(new ChessKings3x3Plus("eWeeeeeBeW")));
      chess = new ChessKings3x3Plus("eWeeeeeBeW");
      assertTrue(chess.possibleMoves(chess.getPlayer1()).size() == 2);
      assertTrue(chess.possibleMoves(chess.getPlayer1()).contains(new ChessKings3x3Plus("WeeeeeeBeB")));
      assertTrue(chess.possibleMoves(chess.getPlayer1()).contains(new ChessKings3x3Plus("eeWeeeeBeB")));
      chess = new ChessKings3x3Plus("WeeeeeeBeB");
      assertTrue(chess.possibleMoves(chess.getPlayer2()).size() == 3);
      assertTrue(chess.possibleMoves(chess.getPlayer2()).contains(new ChessKings3x3Plus("WeeeeeeeBW")));
      assertTrue(chess.possibleMoves(chess.getPlayer2()).contains(new ChessKings3x3Plus("WeeeeeBeeW")));
      assertTrue(chess.possibleMoves(chess.getPlayer2()).contains(new ChessKings3x3Plus("WeeeeBeeeW")));
    } catch (InvalidBoardString | TurnMismatchError e) {

      e.printStackTrace();
      fail();
    }
    assertThrows(TurnMismatchError.class, () -> {
      (new ChessKings3x3Plus()).possibleMoves('B');
    });
  }

  @ParameterizedTest(name = "{index} => board= {0} number= {1}")
  @CsvSource({ "eeBWeeeeeB,1", "WeeeeeBeeB,1", "eBeeeeeeWW,1", "eeBWeeeeeB,1", "eeBWeeeeeW,3", "eeeWeBeeeB,2",
      "eeeWeBeeeW,2", "eeeBeWeeeB,2", "eeeBeWeeeW,2", "eeWeeeBeeB,2", "eeWeeeeBeB,3" })
  public void testPossibleMovesQuick(String str, int num) {
    Game chess;
    try {
      chess = new ChessKings3x3Plus(str);
      if (str.charAt(9) == chess.getPlayer2())
        assertTrue(chess.possibleMoves(chess.getPlayer2()).size() == num);
      else
        assertTrue(chess.possibleMoves(chess.getPlayer1()).size() == num);
    } catch (InvalidBoardString | TurnMismatchError e) {
      e.printStackTrace();
      fail();
    }
  }
}