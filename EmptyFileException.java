class EmptyFileException extends IOException {
	public EmptyFileException (String message){
		super(message);
	}
	public EmptyFileException() {}
	public IOException(String message, Throwable cause){
		super(message,cause)
	}
	public IOException(Throwable cause){
		super(cause)
	}
 }
