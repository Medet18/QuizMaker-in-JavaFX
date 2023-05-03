package Hello;


import java.io.*;
public class InvalidQuizFormatException extends Exception{
	public InvalidQuizFormatException(String message)
	{
		super(message);
	}
}