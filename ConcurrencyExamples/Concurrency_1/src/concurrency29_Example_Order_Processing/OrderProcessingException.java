package concurrency29_Example_Order_Processing;

/**
 * OrderProcessingException.
 */
public class OrderProcessingException extends Exception {

  /**
   * serialVersionUID
   */
  private static final long serialVersionUID = 1L;

  /**
   * OrderProcessingException Constructor.
   */
  public OrderProcessingException() {
  }

  /**
   * OrderProcessingException Constructor.
   */
  public OrderProcessingException(String message) {
    super(message);
  }

  /**
   * OrderProcessingException Constructor.
   */
  public OrderProcessingException(Throwable cause) {
    super(cause);
  }

  /**
   * OrderProcessingException Constructor.
   */
  public OrderProcessingException(String message, Throwable cause) {
    super(message, cause);
  }

}
