public class WordCounter {
	public void processText(StringBuffer text,String stopword) throws InvalidStopwordException{
		Pattern regex = Pattern.compile("\\b[a-zA-Z0-9']+");
		Matcher regexMatcher = regex.matcher(text);
		while (regexMatcher.find()) {
		    System.out.println("I just found the word: " + regexMatcher.group());
		} 
	}
}

