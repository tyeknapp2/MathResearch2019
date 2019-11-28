package MathResearch2019.Main;

import java.util.ArrayList;
import java.util.HashMap;

import MathResearch2019.Errors.*;
import MathResearch2019.Games.*;

/**
 * @author TyeKnappenberger
 *
 */
public class ReconfigurationGraph {

  
  
  private HashMap<Game, ArrayList<Game>> gameToGame;
  private int totalBoards = 0;


  public ReconfigurationGraph(Game game) {

    gameToGame = new HashMap<Game, ArrayList<Game>>();
    totalBoards = 0;

    createAdjacencyList(game, game.getPlayer1());

  }

 
  private void createAdjacencyList(Game jGame, char turn) {
    totalBoards += (gameToGame.putIfAbsent(jGame, new ArrayList<Game>()) == null) ? 1 : 0;
    if (!jGame.seeVictoryStatus() && !jGame.checkStalemateStatus()) {
      ArrayList<Game> h = gameToGame.get(jGame);
      try {
        if (h.size() == 0) {
          jGame.setTurnTruth(turn);
          h.add(jGame);
          for (Game game : jGame.possibleMoves(turn)) {
            h.add(game);
            createAdjacencyList(game, turn == jGame.getPlayer1() ? jGame.getPlayer2() : jGame.getPlayer1());
          }
        } else if (!h.get(0).getTurnTruth(turn)) {
          h.get(0).setTurnTruth(turn);
          for (Game game : jGame.possibleMoves(turn)) {
            h.add(game);
            createAdjacencyList(game, turn == jGame.getPlayer1() ? jGame.getPlayer2() : jGame.getPlayer1());
          }
        }
      } catch (TurnMismatchError e) {
        e.printStackTrace();
      }
    }
  }

  public int getTotalBoards() {
    return totalBoards;
  }

  public boolean contains(Game s) {
    return gameToGame.containsKey(s);
  }

  
}