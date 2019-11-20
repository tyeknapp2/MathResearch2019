/**
 * 
 */
package MathResearch2019.Tests;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import MathResearch2019.Games.*;
import MathResearch2019.Errors.*;

/**
 * @deprecated
 * @author TyeKnappenberger
 *
 */
public class TicTacToe3x3Test2 {
	
	@Test
	public void testCheckVictoryAndStalemate() {
		/**
		 * Tests the checkVictory and checkStalemateStatus
		 */
		Game test3x3 = new TicTacToe3x3();
		assertTrue(!test3x3.seeStalemateStatus() && !test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eOXeOXeOe");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("XOXOOXXXO");
		assertTrue(test3x3.seeStalemateStatus() && !test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("OeeeOeeeO");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("XeeeXeeeX");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeOeOeOee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeXeXeXee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("OOOeeeeee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("XXXeeeeee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeeOOOeee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeeXXXeee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeeeeeOOO");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeeeeeXXX");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("OeeOeeOee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("XeeXeeXee");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eOeeOeeOe");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eXeeXeeXe");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeOeeOeeO");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("eeXeeXeeX");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		test3x3 = new TicTacToe3x3("OOXOOXXXX");
		assertTrue(!test3x3.seeStalemateStatus() && test3x3.seeVictoryStatus());
		/**
		 * @returns null
		 *
		 */
	}

	@Test
	public void testPossibleMoves() {
		Game test3x3 = new TicTacToe3x3();
		try {
			assertTrue(test3x3.possibleMoves('O').size() == 9);
			assertTrue(test3x3.possibleMoves('O').contains("Oeeeeeeee"));
			assertTrue(test3x3.possibleMoves('O').contains("eOeeeeeee"));
			assertTrue(test3x3.possibleMoves('O').contains("eeOeeeeee"));
			assertTrue(test3x3.possibleMoves('O').contains("eeeOeeeee"));
			assertTrue(test3x3.possibleMoves('O').contains("eeeeOeeee"));
			assertTrue(test3x3.possibleMoves('O').contains("eeeeeOeee"));
			assertTrue(test3x3.possibleMoves('O').contains("eeeeeeOee"));
			assertTrue(test3x3.possibleMoves('O').contains("eeeeeeeOe"));
			assertTrue(test3x3.possibleMoves('O').contains("eeeeeeeeO"));
			assertTrue(test3x3.possibleMoves('X').size() == 9);
			assertTrue(test3x3.possibleMoves('X').contains("Xeeeeeeee"));
			assertTrue(test3x3.possibleMoves('X').contains("eXeeeeeee"));
			assertTrue(test3x3.possibleMoves('X').contains("eeXeeeeee"));
			assertTrue(test3x3.possibleMoves('X').contains("eeeXeeeee"));
			assertTrue(test3x3.possibleMoves('X').contains("eeeeXeeee"));
			assertTrue(test3x3.possibleMoves('X').contains("eeeeeXeee"));
			assertTrue(test3x3.possibleMoves('X').contains("eeeeeeXee"));
			assertTrue(test3x3.possibleMoves('X').contains("eeeeeeeXe"));
			assertTrue(test3x3.possibleMoves('X').contains("eeeeeeeeX"));
			test3x3 = new TicTacToe3x3("OOXOOXXXX");
			assertTrue(test3x3.possibleMoves('X').isEmpty());
			test3x3 = new TicTacToe3x3("XOXOOXXXO");
			assertTrue(test3x3.possibleMoves('X').isEmpty());
			test3x3 = new TicTacToe3x3("OXeXeOOXe");
			assertTrue(test3x3.possibleMoves('O').size() == 3);
			assertTrue(test3x3.possibleMoves('O').contains("OXOXeOOXe"));
			assertTrue(test3x3.possibleMoves('O').contains("OXeXOOOXe"));
			assertTrue(test3x3.possibleMoves('O').contains("OXeXeOOXO"));
		} catch (TurnMismatchError e) {
			e.printStackTrace();
		}
	}
}
