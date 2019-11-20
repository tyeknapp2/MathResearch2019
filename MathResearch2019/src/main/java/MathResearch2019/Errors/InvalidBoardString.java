package MathResearch2019.Errors;

/**
 * @author TyeKnappenberger
 *
 */
public class InvalidBoardString extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * To be thrown when the board string would be invalid.
   * 
   * @param msg
   */
  public InvalidBoardString(String msg) {
    super(msg);
  }
}