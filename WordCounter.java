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
		Scanner s = new Scanner(new File(path));
		if(!s.hasNext){
			throw new EmptyFileException();
		}
		String str="";
		while(s.hasNextLine){
			str+=s.nextLine()+" ";
		}
		StringBuffer buf=stringBuffer(str);
	}
	public static void main(){
		Scanner kb=new Scanner(system.in);
		for(int choice=-1;choice!=1&&choice!=2;choice=kb.nextInt()){
			print("Would you like to (1) process a file or (2) process text?\n");
		}
		if(choice==1){		
			while(true){
				try{
					print("Input the path\n");
					String path=kb.next();
					String stopWord=kb.next();
					while(kb.hasNext()){kb.next()}
					processFile(processFile(path),stopWord);
				}catch(Exception e){
					continue;
				}
				break;
			}
		}
		if(choice==2){		
			while(true){
				try{
					print("Input the text\n");
					String text=kb.next();
					String stopWord=kb.next();
					processFile(text,stopWord);
				}catch(Exception e){
					continue;
				}
				break;
			}
		}
	}
}

