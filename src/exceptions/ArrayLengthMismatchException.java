package exceptions;

/**
 * When one array is set to another but their lengths differ
 * @author Deaglan Jack
 */
public class ArrayLengthMismatchException extends Exception
  {
    public ArrayLengthMismatchException(String message)
      {
        super(message);
      }
  }
