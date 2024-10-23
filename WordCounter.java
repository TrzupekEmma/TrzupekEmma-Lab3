public class WordCounter {
	public int processText(StringBuffer text,String stopword) throws InvalidStopwordException{
		Pattern regex = Pattern.compile("\\b[a-zA-Z0-9']+");
		Matcher regexMatcher = regex.matcher(text);
		count=0;
		while (regexMatcher.find()) {
		    	String word=regexMatcher.group();
			if(word==stopword){
				return(count);
			}
			count++;
			System.out.println("I just found the word: " + word);
		} 
		throw new InvalidStopwordException();
	}
	public StringBuffer processFile(String path) throws EmptyFileException{
		
		StringBuffer buf=stringBuffer(String str);
	}
}

