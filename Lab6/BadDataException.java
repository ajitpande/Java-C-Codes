//USCNetID: ajitpand
//Lab 9
//CS455 Fall 2019

import java.io.IOException;

/**
   This class reports bad input data.
*/
public class BadDataException extends IOException
{
   public BadDataException() {}
   public BadDataException(String message)
   {
      super(message);
   }
}
