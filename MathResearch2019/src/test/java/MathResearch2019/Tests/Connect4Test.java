package MathResearch2019.Tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import MathResearch2019.Errors.InvalidBoardString;
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

}