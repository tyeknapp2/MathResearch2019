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

  private HashMap<String, Integer> boardToNumber;
  private HashMap<Integer, ArrayList<Integer>> adjacencyList;
  private HashMap<Integer, Game> numberToGame;
  private HashMap<Integer, String> numberToBoard;
  
  
  private HashMap<Game, ArrayList<Game>> gameToGame;
  private int totalBoards = 0;

  /**
   * 
   * @param game
   * @param player
   * @param turn
   * @deprecated
   *//*
  public ReconfigurationGraph(Game game, char player, int turn) {
    boardToNumber = new HashMap<String, Integer>();
    adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    numberToGame = new HashMap<Integer, Game>();
    numberToBoard = new HashMap<Integer, String>();
    totalBoards = 0;

    createAdjacencyList(game, player, turn);

  }
*//**
 * 
 * @param game
 * @param player
 * @deprecated
 *//*
  public ReconfigurationGraph(Game game, char player) {
    boardToNumber = new HashMap<String, Integer>();
    adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    numberToGame = new HashMap<Integer, Game>();
    numberToBoard = new HashMap<Integer, String>();
    totalBoards = 0;

    createAdjacencyList(game, player, 1);
  }
*/

  public ReconfigurationGraph(Game game) {

    boardToNumber = new HashMap<String, Integer>();
    adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    numberToGame = new HashMap<Integer, Game>();
    numberToBoard = new HashMap<Integer, String>();
    gameToGame = new HashMap<Game, ArrayList<Game>>();
    totalBoards = 0;

    createAdjacencyList(game, game.getPlayer1());

  }

  /**
   * 
   * @param game
   * @param player
   * @param turn
   * @return
   * @deprecated
   *//*
  private int createAdjacencyList(Game game, char player, int turn) {
    if (!boardToNumber.containsKey(game.getBoard())) {
      int temp = totalBoards;
      boardToNumber.put(game.getBoard(), totalBoards);
      adjacencyList.put(totalBoards, new ArrayList<Integer>());
      numberToGame.put(totalBoards, game);
      numberToBoard.put(totalBoards++, game.getBoard());

      if (!game.checkStalemateStatus() && !game.checkVictory()) {
        numberToGame.get(temp).setTurnTruth(player);
        try {
          for (String b : game.possibleMoves(player)) {
            if (game instanceof ChessKings3x3) {
              adjacencyList.get(temp).add(createAdjacencyList(new ChessKings3x3(b),
                  (turn == 1 ? game.getPlayer2() : game.getPlayer1()), (turn == 1 ? 2 : 1)));
            } else if (game instanceof TicTacToeNxN) {
              try {
                adjacencyList.get(temp).add(createAdjacencyList(new TicTacToeNxN(b),
                    (turn == 1 ? game.getPlayer2() : game.getPlayer1()), (turn == 1 ? 2 : 1)));
              } catch (InvalidBoardString e) {
                e.printStackTrace();
              }
            }
          }
        } catch (TurnMismatchError e) {
          e.printStackTrace();
        }
      }
    } else if (!numberToGame.get(boardToNumber.get(game.getBoard())).getTurnTruth(player)) {
      int temp = boardToNumber.get(game.getBoard());

      if (!game.checkStalemateStatus() && !game.checkVictory()) {
        numberToGame.get(temp).setTurnTruth(player);
        try {
          for (String b : game.possibleMoves(player)) {
            if (game instanceof ChessKings3x3) {
              adjacencyList.get(temp).add(createAdjacencyList(new ChessKings3x3(b),
                  (turn == 1 ? game.getPlayer2() : game.getPlayer1()), (turn == 1 ? 2 : 1)));

            } else if (game instanceof TicTacToeNxN) {
              try {
                adjacencyList.get(temp).add(createAdjacencyList(new TicTacToeNxN(b),
                    (turn == 1 ? game.getPlayer2() : game.getPlayer1()), (turn == 1 ? 2 : 1)));
              } catch (InvalidBoardString e) {
                e.printStackTrace();
              }
            }
          }
        } catch (TurnMismatchError e) {
          e.printStackTrace();
        }
      }

    }

    return boardToNumber.get(game.getBoard());
  }*/

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

  public boolean contains(String s) {
    return boardToNumber.containsKey(s);
  }

  public void printAllBoards() {
    int x = 0;
    for (int i : adjacencyList.keySet()) {
      if (adjacencyList.get(i).isEmpty()) {
        System.out.println("" + numberToGame.get(i) + "\n");
        x++;
      }
    }
    System.out.print(x);
  }

  public void printAdjacencyList() {
    for (int i : adjacencyList.keySet()) {
      System.out.println("" + i + ": " + adjacencyList.get(i));
    }
  }
}