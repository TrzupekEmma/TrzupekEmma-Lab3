import java.util.regex.*;
import java.util.Scanner;
import java.io.*;
public class WordCounter {
	public static int processText(StringBuffer text,String stopword) throws TooSmallText, InvalidStopwordException{
		System.out.println("In processText");
		Pattern regex = Pattern.compile("\\b[a-zA-Z0-9']+");
		Matcher regexMatcher = regex.matcher(text);
		int count=1;
		while (regexMatcher.find()) {
		    	String word=regexMatcher.group();
			if(word.equals(stopword)){
				if(count<5){
					System.out.println("Throwing TooSmallText");
					throw new TooSmallText("Only found "+(count+1)+" words.");
				}
				return(count);
			}
			count++;
		}
		if(count<6){
			System.out.println("Throwing TooSmallText");
			throw new TooSmallText("Only found "+(count-1)+" words.");
		}
		if(stopword==null){
			return(count-1);
		} 
		System.out.println("Throwing stopWord not found");
		throw new InvalidStopwordException("Couldn't find stopword: "+stopword);
	}
	public static StringBuffer processFile(String path) throws EmptyFileException{ 
		System.out.println("in processFile ");
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
			System.out.println("throwing empty exception\n");
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
		System.out.println("Exiting processFile");
		return(buf);
	}
	public static void main(String[] args) throws Exception{
		System.out.println("in main\n");
		Scanner kb=new Scanner(System.in);
		int fileProgress=0;
		int choice;
		int count=0;
		System.out.println(args.length);
		for(int i=0;i<args.length;i++){System.out.println(args[i]);}
		for(choice=-1;choice!=1&&choice!=2;choice=kb.nextInt()){
			count++;
			if(count>100){throw(new Exception("Infinite Loop"));}
			System.out.println("main menu looped");
			System.out.println("Would you like to (1) process a file or (2) process text?");
		}
		if(choice==1){		
			while(true){
			count++;
				if(count>100){throw(new Exception("Infinite Loop"));}
				System.out.println("Choice 1 looped");
				try{
					count++;
					System.out.println("Input the path "+fileProgress+" "+args.length);
					String path;
					if(args.length>fileProgress){
						System.out.println("path is an argument");
						path=args[fileProgress++];
					}else{
						System.out.println("path is a keyboard input");
						path=kb.next();
					}
					
					System.out.println("Input the stop Word");
					String stopWord=(args.length>fileProgress)?args[fileProgress++]:kb.next();
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
				count++;
				if(count>100){throw(new Exception("Infinite Loop"));}
				try{
				System.out.println("choice 2 looped");
					System.out.println("Input the text");
					String text=(args.length>fileProgress)?args[fileProgress++]:kb.nextLine();
					System.out.println("Input the stop Word");
					String stopWord=(args.length>fileProgress)?args[fileProgress++]:kb.next();
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

