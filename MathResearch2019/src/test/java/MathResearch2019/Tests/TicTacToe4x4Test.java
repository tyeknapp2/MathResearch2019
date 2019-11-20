/**
 * 
 */
package MathResearch2019.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import MathResearch2019.Errors.*;
import MathResearch2019.Games.*;

/**
 * @deprecated
 * @author TyeKnappenberger
 *
 */
class TicTacToe4x4Test {

	@Tag("ignore")
	@Test
	void testCheckVictoryAndStalemate() {
		Game test4x4 = new TicTacToe4x4();
		assertTrue(!test4x4.seeStalemateStatus() && !test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("OeeOeeeeeeeeOeeO");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("OOOOeeeeeeeeeeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeeeOOOOeeeeeeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeeeeeeeOOOOeeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeeeeeeeeeeeOOOO");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("OeeeOeeeOeeeOeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eOeeeOeeeOeeeOee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeOeeeOeeeOeeeOe");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeeOeeeOeeeOeeeO");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeOOeeOOeeeeeeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eOOeeOOeeeeeeeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("OOeeOOeeeeeeeeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeeeeeeeeeOOeeOO");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("eeeeeeOOeeOOeeee");
		assertTrue(!test4x4.seeStalemateStatus() && test4x4.seeVictoryStatus());
		test4x4 = new TicTacToe4x4("OXXOXOOXOXXOXOXO");
		assertTrue(test4x4.seeStalemateStatus() && !test4x4.seeVictoryStatus());
	}

	@Tag("ignore")
	@Test
	void testPossibleMoves() {
		Game test4x4 = new TicTacToe4x4();
		try {
			assertTrue(test4x4.possibleMoves('O').size() == 16);
			assertTrue(test4x4.possibleMoves('X').size() == 16);
			test4x4 = new TicTacToe4x4("XeeeOeeeXeeeOeee");
			assertTrue(test4x4.possibleMoves('O').size() == 12);
			assertTrue(test4x4.possibleMoves('X').size() == 12);
			test4x4 = new TicTacToe4x4("OXXOXOOXOXXOXOXO");
			assertTrue(test4x4.possibleMoves('O').isEmpty());
			assertTrue(test4x4.possibleMoves('X').isEmpty());
			test4x4 = new TicTacToe4x4("eeeeeeOOeeOOeeee");
			assertTrue(test4x4.possibleMoves('O').isEmpty());
			assertTrue(test4x4.possibleMoves('X').isEmpty());
		} catch (TurnMismatchError e) {
			e.printStackTrace();
		}
	}
}
