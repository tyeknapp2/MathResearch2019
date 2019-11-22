
package MathResearch2019.Tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import MathResearch2019.Errors.*;
import MathResearch2019.Games.*;

public class TicTacToeNxNTest {

  @Test
  public void testBoardSize() {
    assertThrows(InvalidBoardString.class, () -> {
      new TicTacToeNxN(1);
    }, "Must have a board size >= 3");
    assertThrows(InvalidBoardString.class, () -> {
      new TicTacToeNxN("eeeXOXeeee");
    });
  }

  @Test
  public void testCheckVictoryAndStalemate() {
    try {
      Game test3x3 = new TicTacToeNxN();
      assertTrue(!test3x3.seeStalemateStatus() && !test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eOXeOXeOe");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("XOXOOXXXO");
      assertTrue(test3x3.seeStalemateStatus() && !test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("OeeeOeeeO");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("XeeeXeeeX");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eeOeOeOee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eeXeXeXee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("OOOeeeeee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("XXXeeeeee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eeeOOOeee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eeeXXXeee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eeeeeeOOO");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eeeeeeXXX");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("OeeOeeOee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("XeeXeeXee");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eOeeOeeOe");

      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eXeeXeeXe");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());

      test3x3 = new TicTacToeNxN("eeOeeOeeO");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("eeXeeXeeX");

      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
      test3x3 = new TicTacToeNxN("OOXOOXXXX");
      assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());

      Game test4x4 = new TicTacToeNxN(4);
      assertTrue(!test4x4.seeStalemateStatus() && !test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("OeeOeeeeeeeeOeeO");

      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("OOOOeeeeeeeeeeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeeeOOOOeeeeeeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeeeeeeeOOOOeeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeeeeeeeeeeeOOOO");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("OeeeOeeeOeeeOeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eOeeeOeeeOeeeOee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeOeeeOeeeOeeeOe");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeeOeeeOeeeOeeeO");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeOOeeOOeeeeeeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eOOeeOOeeeeeeeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("OOeeOOeeeeeeeeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeeeeeeeeeOOeeOO");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("eeeeeeOOeeOOeeee");
      assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
      test4x4 = new TicTacToeNxN("OXXOXOOXOXXOXOXO");
      assertTrue(test4x4.seeStalemateStatus() && !test4x4.seeVictoryStatus());
      
      Game test5x5 = new TicTacToeNxN(5);
      assertTrue(!test5x5.seeStalemateStatus() && !test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("OeeeOeeeeeeeeeeeeeeeOeeeO");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("OOOOOeeeeeeeeeeeeeeeeeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeeeeOOOOOeeeeeeeeeeeeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeeeeeeeeeeeeeeOOOOOeeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeeeeeeeeeeeeeeeeeeeOOOOO");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("OeeeeOeeeeOeeeeOeeeeOeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eOeeeeOeeeeOeeeeOeeeeOeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeeOeeeeOeeeeOeeeeOeeeeOe");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeeeOeeeeOeeeeOeeeeOeeeeO");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeOOeeeOOeeeeeeeeeeeeeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eOOeeeOOeeeeeeeeeeeeeeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("OOeeeOOeeeeeeeeeeeeeeeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeeeeeeeeeeeeeeeeeOOeeeOO");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("eeeeeeeeeeeeeOOeeeOOeeeee");
      assertTrue(!test5x5.seeStalemateStatus() && test5x5.seeVictoryStatus());
      test5x5 = new TicTacToeNxN("OOOXOOXOOXOXOXXXXXOOXOOXX");
      assertTrue(test5x5.seeStalemateStatus() && !test5x5.seeVictoryStatus());
    } catch (InvalidBoardString e) {
      e.printStackTrace();
      fail();
    }

  }

  @Test
  public void testPossibleMovesIntense() {
    try {
      Game testNxN = new TicTacToeNxN(4);
      assertTrue(testNxN.possibleMoves('O').size() == 16);
      assertTrue(testNxN.possibleMoves('X').size() == 16);
      testNxN = new TicTacToeNxN(5);
      assertTrue(testNxN.possibleMoves('O').size() == 25);
      assertTrue(testNxN.possibleMoves('X').size() == 25);
      testNxN = new TicTacToeNxN(6);
      assertTrue(testNxN.possibleMoves('O').size() == 36);
      assertTrue(testNxN.possibleMoves('X').size() == 36);
      testNxN = new TicTacToeNxN("XeeeOeeeXeeeOeee");
      assertTrue(testNxN.possibleMoves('O').size() == 12);
      assertTrue(testNxN.possibleMoves('X').size() == 12);
      testNxN = new TicTacToeNxN("OXXOXOOXOXXOXOXO");
      assertTrue(testNxN.possibleMoves('O').isEmpty());
      assertTrue(testNxN.possibleMoves('X').isEmpty());
      testNxN = new TicTacToeNxN("eeeeeeOOeeOOeeee");
      assertTrue(testNxN.possibleMoves('O').isEmpty());
      assertTrue(testNxN.possibleMoves('X').isEmpty());

      testNxN = new TicTacToeNxN();
      assertTrue(testNxN.possibleMoves('O').size() == 9);
      assertTrue(testNxN.possibleMoves('O').contains("Oeeeeeeee"));
      assertTrue(testNxN.possibleMoves('O').contains("eOeeeeeee"));
      assertTrue(testNxN.possibleMoves('O').contains("eeOeeeeee"));
      assertTrue(testNxN.possibleMoves('O').contains("eeeOeeeee"));
      assertTrue(testNxN.possibleMoves('O').contains("eeeeOeeee"));
      assertTrue(testNxN.possibleMoves('O').contains("eeeeeOeee"));
      assertTrue(testNxN.possibleMoves('O').contains("eeeeeeOee"));
      assertTrue(testNxN.possibleMoves('O').contains("eeeeeeeOe"));
      assertTrue(testNxN.possibleMoves('O').contains("eeeeeeeeO"));
      assertTrue(testNxN.possibleMoves('X').size() == 9);
      assertTrue(testNxN.possibleMoves('X').contains("Xeeeeeeee"));
      assertTrue(testNxN.possibleMoves('X').contains("eXeeeeeee"));
      assertTrue(testNxN.possibleMoves('X').contains("eeXeeeeee"));
      assertTrue(testNxN.possibleMoves('X').contains("eeeXeeeee"));
      assertTrue(testNxN.possibleMoves('X').contains("eeeeXeeee"));
      assertTrue(testNxN.possibleMoves('X').contains("eeeeeXeee"));
      assertTrue(testNxN.possibleMoves('X').contains("eeeeeeXee"));
      assertTrue(testNxN.possibleMoves('X').contains("eeeeeeeXe"));
      assertTrue(testNxN.possibleMoves('X').contains("eeeeeeeeX"));

      testNxN = new TicTacToeNxN("OXeXeOOXe");
      assertTrue(testNxN.possibleMoves('O').size() == 3);
      assertTrue(testNxN.possibleMoves('O').contains("OXOXeOOXe"));
      assertTrue(testNxN.possibleMoves('O').contains("OXeXOOOXe"));
      assertTrue(testNxN.possibleMoves('O').contains("OXeXeOOXO"));
    } catch (InvalidBoardString | TurnMismatchError e) {
      e.printStackTrace();
      fail();
    }
  }

  
  @ParameterizedTest(name = "{index} => board= {0} number= {1}")
  @CsvSource({ "eeeeee0Xe,7", "eOXXXXXOe,2", "XXXeOOOeO,2", "eeOeOeOXX,0", "OOXOOXXXe,1", "XeOOOXXeX,2", "eOeeXOXXX,3",
      "XeOeXXeOX,3", "XeOOOeeXO,3", "eeeOOOOeX,4", "eeXXXeOeO,4", "OOXOOOOXe,1", "OXeeeXXee,5", "XOeeOeOOe,0",
      "eeXeeeOOe,6", "eXOeeOXOO,0", "XXOXOXeXe,2", "OeOeXXOeX,3", "eXOOXXeeO,3", "eeXOeXeXX,4", "XXOOXOXeX,1",
      "XeOXeeXeO,4", "OeXXXeXeX,3", "eOeOeeeee,7", "XXOOeXXee,3", "OeOXOXeXX,2", "eeOeeXOXO,4", "eXXeeXXXe,4",
      "OeOOOeOXe,3", "OOeOOOeXO,2", "eeeXeOOOO,4", "eeXeXXeeO,5", "OOeOOOOOX,1", "OOeeOXOXX,2", "XXeXeeeXO,4",
      "XXOeOeOee,4", "XXeeXeeOO,4", "XOOOeXOOO,1", "XOeXOXeOO,2", "eOeOeOXOX,3", "OXXOOOeeO,2", "OXeeeXOXX,3",
      "OOeXeeOeO,4", "eOXOXOeXX,2", "OeeOeXOXe,4", "OeXOXOeXO,2", "eXOXOOOXO,1", "OeeOXeeXO,4", "eeOOXeOeO,4",
      "eOOOOOXee,3", "XOXXOXXeO,1", "XOeOXeXXe,3", "XOXeeeXee,5", "OOOXeOXXeOXXXOeX,3", "XeXOeOXOeOeXeeeX,7",
      "XeXeeOXeeeXeeOOO,8", "eXXXOOXeXOeXOOeO,4", "XOeOeXOOXOOXeXXX,3", "XXOOeXOeXXeOeXXe,5", "eOXXeOOOOOXeeeeX,6",
      "OeXXOeeOeeeOeOXX,7", "XeeOeeXOeeXOXOOX,6", "XeXOeeXOOeeOeeOX,7", "XXOOOOXeeXXeOeOX,4", "OOXeeXXeOeXXXOOO,4",
      "eXOOeXOXeeeeeXeX,8", "eeeOeOOXeXXXXOeO,6", "eXeXeXXXXXOOOeee,6", "eeOOOXOeeXeXXOeO,6", "OOOeXeeeOXOeeXOO,6",
      "eeXOOXeeeXeXOeeO,8", "OOXOOOeXXXeeXOXO,3", "OXOOXOOXeeOXOOOe,3", "XXXXXXXOXXOXXeee,3", "XeXOXXeeOeeXXXeX,6",
      "OXOXXXXXOeeOOXXO,2", "eeXeXXXeOOeOeOOX,6", "XOeeXXeXeeOXXOXO,5", "eXXXeXeeOXXeeXeX,7", "XXXOXOeOOeXOOOeO,3",
      "XOeXOOXXeOXOeXXX,3", "eOOOOXXXeOeOeeXe,6", "OXXOeXOXOXOOeXOe,3", "eXOOXOOXeXXeXOXX,3", "eOeXeOeXeeOXeXOO,7",
      "eeeOOeeXXXeeXeXe,9", "XOOeeeXXeXXeeXee,8", "XeOXXeeXXXeeXXXO,5", "OeXXXeOOOOOOOXXO,2", "OXOeXOOeOeXXXOOX,3",
      "OeeeXOeOXXOOeOeO,6", "eOeXeXOXeXXeOeOe,7", "OOOOXOOOOOeXeOXO,2", "OOXXXOOeeXeOOOeO,4", "XeOXeeeeXeOOeeXO,8",
      "eXeXOeXOOXOeXOOX,4", "XeOOOXeeOeOOXeeO,6", "eeXOeeOOXeOeXeOO,7", "XXOXOeOXeXXXXeeX,4", "OXXOeOXeXeeXeOXX,5",
      "XXOOOXXeOXXeOOeX,3", "XOOeXXXXXeXXXOXO,2", "XXXOeXeOOOXXXeXO,3", "XXOOeXXeeOXOOeXX,4", "eeOXXOeOXOOeXeee,7",
      "OeOXOeeXOXeeXOeO,6", "XXeOeXXOXOOOXeXX,3", "eOOOXXXOOeXeXXXO,3", "OOXOOOXeXeXXXXOO,2", "eeeeOXOXeeeeOeee,11",
      "eXXXeOeOXXeeOOOXeOXeeOXOX,8", "XeOOOOeXOOOXeOXXeeOOeOXXX,6", "eOXeOOeOeOXXOeeeOXXOOXXXX,7",
      "XOXeeXXeXOeeXeXXXXXeXOeOe,9", "OOeXOXXeOeXeeOXOeXXXXeOeO,8", "eOXOXOOeXXXXXOOOeXeXXOOeO,5",
      "OXeOOOXOXeXXOeXXeeXeeeXOX,8", "eXOeOXXOOeXeXXOeeXOeOeeXX,9", "eXOXOOXOeXXOXXXOeXXOXeXXX,4",
      "XXXeXeXXeeOXXeXOOOOOeXeeX,8", "XeXeOXXOXeXeXeOXeOeXOOOXe,8", "OXOOOXeOeOeXOOeOXXOXeXeee,8",
      "OeOOXeOeXOXOXXOXOXOXXXOOe,4", "eXXeXXOOXOeOXeeOeeXOeOXeO,9", "eXeeOXeOeOOOXXOXOOOXeXOeO,7",
      "OOXOeXeOXeXOOXXeOeOXXOOXX,5", "OeeXeXeXXXXOeXeOOeOOXXOOX,7", "XOeeXXOeeOOXXOOeeOXOeXOOO,7",
      "XXXXXXXXeOOOOOOOeOeOeeXXe,6", "OXOeOeeOeOXOeXeOXXeOOXOeO,8", "XeXOXXeOXXOXXXXeeXeXOeXXe,7",
      "eOeXeXeeOOXOeOOeOOXOOXOeO,8", "eXeXOXOXXOXXeXXeXOOeXOeOX,6", "XXeeOOXOeXeOOXOeOeeXOeOeX,9",
      "OeXXOeOOeOXOOOXXXOOeXXOXO,4", "OeeXeOXOXeXXOXXeeXeXXOOXX,7", "XXXeOeeeeOOXOOXXXOXeXOOXe,7",
      "XeXOXeeOOeOeOXeeXXXOOeXXe,9", "OXOOXXOOOeOeXeeOOeeeOOeOe,9", "XOeOeXOXOOOeXXXeeeXXeOOXO,7",
      "XeOeXXOeeXOOOeOXXXOeeOXOe,8", "XeXOOOXOeXOeeOOeXXOOOOOeX,6", "XXXXeeeeXOOXXXXOXeeeOXXOe,8",
      "eXOXXeOOOXOeXXXeXXXOXXOXX,4", "OeeeOXXXXeeXXOXOXOOOOOXee,7", "OeXOeeOeOOXOOOeXXOeeXXXXO,7",
      "XOeOeOXXeXeeOeOXOXXeOeeXX,9", "eXXXeOOeOOOeeOOeOOeXXOOee,9", "OeeOeOOeOOOXeOXXXXOOOeXeX,7",
      "XXXeeeXOOOOOOXOOXOOXXXXOO,3", "OOXOOOXXeOeXeXOOeOOXOOeXX,5", "XeOXOXXXeXOXOXOeOOOeXOeee,7",
      "OeOeeeeeOeOXeOeOOXXOeXOOO,10", "eeeeeeOeXeeeeeeeeeeeeeeee,23", "eeeXOeeXOeOeOeOeeOOXOXOOX,10",
      "OOeOeOeXOOOeXXXeeeXOeeOee,11", "OeeeeeOXXeOXXOeeOeeXOOXee,12", "XOeXXeOeeeXeeOeOOOeeOXXeO,11",
      "XeOeOeeeXXOeXXeeeXXOOOOXe,10", "XXXeeXOeXOeeOeXeOeeeXXeXO,11", "XeeOeeXeeXOeOOeXeXOOOOeOe,11",
      "XXOeeXeeeOOOeeOeOXXeeXXOe,11", "XeXOeXOOeXeXeeeeOOeOXXOeO,10", "XeOeeeeOeOXeXeXXeXeXOXOeX,11",
      "XeOOeeOOXXeeXOeeeOeXXeeOe,12", "eeXOeXeXXXXeeXeeeeeeeXXOX,13", "XXXOOOXOOXXOOOXOOOXOOeXXOeOOeeXXOXOX,4",
      "XXOXOXOOeeXXeXeOOXOeXXeeOXOXXOOXeXeO,9", "XOOeeOXeOeOeOOOOOOOXOeXeeOXOXOOXOXXe,9",
      "eXeeOeOXXOXXeXXOOOXeOeOeXeOXOOOXOXOX,9", "eeOXeOXOOeXXOeOeeOOXOOXOXOOXXOOXXeOX,8",
      "XOOOeOXeXXXeXOOXeeOXeeXOXXXXeXOXXOOe,9", "OOeeOXOXeXXOeOXOXOOXOOXOeXXOOXOOeXOe,7",
      "XXOXOeeXeOOeXXXXOXXeXOOXXXeOOOOXOXee,8", "XOXeeOXXXXXeOOXOOOXOOeXXXXeXeXOeXOOe,8",
      "OOXXOXOeXOOeXeXXOXXXXOeXeeXOXOOXOXOO,6", "XOXOOXeXOXXeXeOOOXOXXeXOXeXXXeeOOeXX,8",
      "OXXXeOOOeOeOXXOXOOXXXXXeOXeOOeOOeXee,9", "OeOOeeXXeeXeeeeeeeXXeeeXeXOXeeOOOXeO,19",
      "eOOOeXXXOXXeeOXeeeeeXOXXOXeOXeXOeOXO,12", "OOOOOeeXOeOeeXOeeeOeXeOeXeXOeeXOOeOe,16",
      "eXeXXeOXXOXXXeeOXXeeOOXeXeOeXeXeOeXO,13", "XXOXXOeeeeOeeOeOeeeXXOXOeXOOeeeXeOee,17",
      "XOOeOeeeeOOOeOeXeXOeXeeOeeXXeOXeXXeX,16", "OOXOOOXXXOeXeOOeeeXXOeeeOeXXOXOOeOeX,11",
      "eXOeeOXeeOXeXOOXeeOOeOXeOXeeXXXXXXOO,12", "XeOOeXOOXXeeOOXeeeXeOXeXeXOOOeOOXOOO,11",
      "XeXOeXeOeOOXeeOXOeXXXXOeOeOXOeOOXOXX,10", "OXXXeeXeXOOXOeeeXeeeeXOeXXXOOXeOOeeX,14",
      "eXeXXeXeeOeeeXOOeXeXXXOOXOOeeeOOOOeO,14", "OOeXXXXOOeeOXeOeXXXOXOeOOOOeeXXeeOXe,11",
      "eXOXeOeXXXXXeOXeeOeeeXOeOeOeeXOOOXeO,14", "OOOXOOeXXeOeOeXeXXeeOOeeXOOXOeeeOXee,14",
      "eXeeXXeOXOXXeeXXXOeOOeXeOeeOeXOOXXOX,12", "eOOeeeeOeOXXeeeOXXXeOXeeXXeXXOOeXOOe,15",
      "XXOeeeXeXXOeXeeOOOeeeXXXe,11", "OXeOeOOXeeXeOeOXXXOXXOOXeeeeOOXOeeXe,13",
      "XXeOOOXOXeXeOOOOeeOeXXeXeOXeOXOeXeOe,12", "OOOeOOXXeXXeeXOOXXeeeeXOOeOOOOOXXXOe,10",
      "eeOOeXOOXOXXXXOOeXXOOXOXXeOeeOeXeXXe,10", "eeXOeXeXXOeeeeOeeXXXXeOOO,11",
      "OeeeOeOOeeXXeeXOXXeXOOXeeXXOeXOXXeOe,14", "XOeeeeXOeeOOOXeeeOXeOeXXOeeXOOXOXXeX,14",
      "XXeOXeOXXOXeeOXOOOOeOXeeeXOXeXeOeOXe,12", "OeOeOeeXXeeOXeOeOeOXOOeXOeOeXeXeOeeO,16",
      "OOeeeeOXeXeXeeOOeXeXOOOOXeXeeOXXXOOX,13", "eOeeXOOeOeOOOXeeXOXOeXeXXeOXOOXeXXOe,12",
      "OeOeOOOeeXOOOeOOOeXeOeeeeOOXeOOOOOXX,12", "eeOeOOeeOeOOXOeXeXOeOOXeXOeOOXeeXXeO,14",
      "OOXXeXeXeXXOOeXXeOXeeeOOXeeOOOOOOXXe,11", "eXXeXOOOOXOXXeeeeeeOXOOXXOeeeXOOOXXX,11",
      "XXeXOeeXeeOXeeXXOOXXOXeOeXeOeOeOXOXe,13", "OOXeeeXeXeXOXXeeeOXeOOOXOXeeXXeeXeOX,14",
      "OOeeOOeXOeeXeOXOXXXeOXeOeOOOeOeOOXOO,11", "OeXeeeeOXXOXXOXOeeOOOeeXXXOXeeXOXXOX,11",
      "OeOXeOOOeeOeXXXXOeeeXOXXXOXeOXOOeeXO,11", "eOOXeXXOXOXeXeOeeXeXXeeeXeOXeXeOXeOe,15",
      "eOXXeeXOXXOOeeeXXXOeeXOeOeXOOeOeOXXO,12", "XOXOeeXXeXOOeeXeeeOOeeOXeOeOXXXOeeeO,15",
      "XXXOOOOeXeeeOXOXXeXOXXXOOeeOeOOOOeeO,10", "eXXeOOXOXeeXOXeeXXeeeOOXXeOXeeeOeOXO,14",
      "OOOOOeeOOeeOeOeOXeXOeOXOOeOOOOeeOOXO,11", "XeeOOeXeOOOeXOeXXOXXeOXeXeeOOXOOOXeX,11",
      "eeXeeeXXOXOOXXeXXXeeXeXOXeOXeeeOXOOO,13", "eeeeeeeeeeeeeeeeeeeXeeeeeeeeeeeeeeeO,34", })
  public void testPossibleMovesQuick(String str, int num) {
    Game tictactoe;
    try {
      tictactoe = new TicTacToeNxN(str);
      if (!tictactoe.seeVictoryStatus() && !tictactoe.seeStalemateStatus())
        assertTrue(tictactoe.possibleMoves(tictactoe.getPlayer1()).size() == num);
      else
        assertTrue(tictactoe.possibleMoves(tictactoe.getPlayer1()).size() == 0);

    } catch (InvalidBoardString | TurnMismatchError e) {
      e.printStackTrace();
      fail();
    }
  }

}