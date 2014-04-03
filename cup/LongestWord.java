import java.io.*;
import java.util.*;

public class LongestWord {
	public static void main(String [] args) throws IOException {		
		//put your file path here
		String file_path = "C:/Users/nwang/Desktop/wordsforproblem.txt";			
	    List<String> list = new LinkedList<String>();	    
	    
	    //try-with-resources Statement will close scanner when finished
	    try(Scanner scanner = new Scanner(new File(file_path))){
		    while (scanner.hasNext()) {
		    	list.add(scanner.next());
		    }
    	}
	    
	    String[] strs = list.toArray(new String[list.size()]);	    
	    getLongestWord(strs);
	}
	
    public static void getLongestWord(String[] strs){
        Set<String> dict = new HashSet<String>();
        for(String s: strs) dict.add(s);
        Comparator<String> comparator = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length()<b.length()) return 1;
                else if(a.length() == b.length()) return 0;
                else return -1;
            }
        };
        Arrays.sort(strs, comparator);
        int count = 0;
        for(String s: strs){
            dict.remove(s);
            if(findTarget(dict,s)){
            	if(count++ < 2) System.out.println("Longest # " + count + ": " + s);
            }
            dict.add(s);
        }
        System.out.println("Total count: " + count);
    }
    public static boolean findTarget(Set<String> dict, String targetWord){
        if(dict.contains(targetWord)) return true;
        for(int i = 1;i<targetWord.length();i++){
        	if(dict.contains(targetWord.substring(0,i)) && findTarget(dict,targetWord.substring(i))) return true;
        }
        return false;
    }
    
	
}
