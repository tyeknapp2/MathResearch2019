package MathResearch2019.Tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import MathResearch2019.Games.TicTacToeNxN;

/**
 * ContainsTest
 */
public class ContainsTest {
  @Tag("Ignore")
  @Test
  public void testContains() {
    ArrayList<TicTacToeNxN> y = new ArrayList<TicTacToeNxN>();
    y.add(new TicTacToeNxN());
    assertTrue(y.contains(new TicTacToeNxN()));
    HashMap<TicTacToeNxN, String> hash = new HashMap<TicTacToeNxN, String>();
    TicTacToeNxN foo = new TicTacToeNxN();
    TicTacToeNxN bar = new TicTacToeNxN();
    hash.put(foo, "Hello There");
    hash.putIfAbsent(bar, "General Kenobi");
    TicTacToeNxN goo = new TicTacToeNxN();
    assertTrue(hash.get(goo).equals("Hello There"));
  }
}