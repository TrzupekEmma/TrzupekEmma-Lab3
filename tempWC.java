import java.util.regex.*;
import java.util.Scanner;
import java.io.*;
public class WordCounter {
	public static int processText(StringBuffer text,String stopword) throws TooSmallText, InvalidStopwordException{
		Pattern regex = Pattern.compile("\\b[a-zA-Z0-9']+");
		Matcher regexMatcher = regex.matcher(text);
		int count=1;
		while (regexMatcher.find()) {
		    	String word=regexMatcher.group();
			if(word.equals(stopword)){
				if(count<5){
					throw new TooSmallText("Only found "+(count+1)+" words.");
				}
				return(count);
			}
			count++;
		}
		if(count<6){
			throw new TooSmallText("Only found "+(count-1)+" words.");
		}
		if(stopword==null){
			return(count-1);
		} 
		throw new InvalidStopwordException("Couldn't find stopword: "+stopword);
	}
	public static StringBuffer processFile(String path) throws EmptyFileException{ 
		String cPath=path;
		Scanner kb=new Scanner(System.in);
		Scanner s;
		while(true){
			try{
				s=new Scanner(new File(cPath));
			}catch(Exception e){
				System.out.println("Input the path");
				cPath=kb.next();
				continue;
			}
			break;
		}if(!s.hasNext()){
			System.out.println("Empty exception\n");
			throw new EmptyFileException(path+" was empty");
		}
		String str="";
		if(s.hasNextLine()){
			str+=s.nextLine();
			while(s.hasNextLine()){
				str+=" "+s.nextLine();
			}
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
					String path=args.length<fileProgress?args[fileProgress++]:kb.next();
					System.out.println("Input the stop Word");
					String stopWord=args.length<fileProgress?args[fileProgress++]:kb.next();
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
					String text=args.length<fileProgress?args[fileProgress++]:kb.nextLine();
					System.out.println("Input the stop Word");
					String stopWord=args.length<fileProgress?args[fileProgress++]:kb.next();
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

