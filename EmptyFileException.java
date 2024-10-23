class EmptyFileException extends IOException {
	public EmptyFileException (String input){
		super(input);
	}
	public EmptyFileException() {}
	IOException(String message, Throwable cause){}
 }
