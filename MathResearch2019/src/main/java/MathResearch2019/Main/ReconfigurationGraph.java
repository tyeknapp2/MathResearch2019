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
  private int totalBoards = 0;

  public ReconfigurationGraph(Game game, char player, int turn) {
    boardToNumber = new HashMap<String, Integer>();
    adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    numberToGame = new HashMap<Integer, Game>();
    numberToBoard = new HashMap<Integer, String>();
    totalBoards = 0;

    createAdjacencyList(game, player, turn);

  }

  public ReconfigurationGraph(Game game, char player) {
    boardToNumber = new HashMap<String, Integer>();
    adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    numberToGame = new HashMap<Integer, Game>();
    numberToBoard = new HashMap<Integer, String>();
    totalBoards = 0;

    createAdjacencyList(game, player, 1);
  }

  public ReconfigurationGraph(Game game) {

    boardToNumber = new HashMap<String, Integer>();
    adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
    numberToGame = new HashMap<Integer, Game>();
    numberToBoard = new HashMap<Integer, String>();
    totalBoards = 0;

    createAdjacencyList(game, game.getPlayer1(), 1);

  }

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
            // if (game instanceof TicTacToe3x3)
            // adjacencyList.get(temp).add(createAdjacencyList(new TicTacToe3x3(b),
            // (turn == 1 ? game.getPlayer2() : game.getPlayer1()), (turn == 1 ? 2 : 1)));
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
            // if (game instanceof TicTacToe3x3)
            // adjacencyList.get(temp).add(createAdjacencyList(new TicTacToe3x3(b),
            // (turn == 1 ? game.getPlayer2() : game.getPlayer1()), (turn == 1 ? 2 : 1)));
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
  }

  public int getTotalBoards() {
    return totalBoards;
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