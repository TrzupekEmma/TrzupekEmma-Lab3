import java.io.*;
public class EmptyFileException extends IOException {
	public EmptyFileException (String message){
		super(message);
	}
	public EmptyFileException() {}
	public EmptyFileException(String message, Throwable cause){
		super(message,cause);
	}
	public EmptyFileException(Throwable cause){
		super(cause);
	}
 }
