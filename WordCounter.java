import java.util.regex.*;
import java.util.Scanner;
import java.io.*;
public class WordCounter {
	public static int processText(StringBuffer text,String stopword) throws InvalidStopwordException{
		Pattern regex = Pattern.compile("\\b[a-zA-Z0-9']+");
		Matcher regexMatcher = regex.matcher(text);
		int count=0;
		while (regexMatcher.find()) {
		    	String word=regexMatcher.group();
			if(word.equals(stopword)){
				return(count);
			}
			count++;
		} 
		throw new InvalidStopwordException();
	}
	public static StringBuffer processFile(String path) throws FileNotFoundException, EmptyFileException{
		System.out.println("Processing file "+path);
		Scanner s = new Scanner(new File(path));
		if(!s.hasNext()){
			throw new EmptyFileException();
		}
		String str="";
		while(s.hasNextLine()){
			str+=s.nextLine()+" ";
		}
		StringBuffer buf=new StringBuffer(str);
		return(buf);
	}
	public static void main(String[] args){
		Scanner kb=new Scanner(System.in);
		int fileProgress=0;
		int choice;
		for(choice=-1;choice!=1&&choice!=2;choice=kb.nextInt()){
			System.out.println("Would you like to (1) process a file or (2) process text?");
		}
		if(choice==1){		
			while(true){
				try{
					System.out.println("Input the path");
					String path=args.length>fileProgress?args[fileProgress++]:kb.next();
					System.out.println("Input the stop Word");
					String stopWord=args.length>fileProgress?args[fileProgress++]:kb.next();
					System.out.println(processText(processFile(path),stopWord));
				}catch(Exception e){
					System.out.println("Exception found");
					continue;
				}
				break;
			}
		}
		if(choice==2){		
			while(true){
				try{
					System.out.println("Input the text");
					String text=args.length>fileProgress?args[fileProgress++]:kb.nextLine();
					System.out.println("Input the stop Word");
					String stopWord=args.length>fileProgress?args[fileProgress++]:kb.next();
					System.out.println(processText(new StringBuffer(text),stopWord));
				}catch(Exception e){
					System.out.println("Found exception");
					continue;
				}
				break;
			}
		}
	}
}

