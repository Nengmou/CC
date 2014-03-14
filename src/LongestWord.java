import java.io.*;
import java.util.*;

public class LongestWord {
	public static void main(String [] args)throws IOException {
		
		//put your file path here
		String file_path = "C:/Users/yixiang/Desktop/Aspera/wordsforproblem.txt";	
		
	    List<String> temps = new LinkedList<String>();
	    Scanner scan = new Scanner(new File(file_path));
	    while (scan.hasNext()) {
	      temps.add(scan.next());
	    }
	    scan.close();

	    String[] strs = temps.toArray(new String[temps.size()]);
	    
	    findLongestWord(strs);
	    findLongestWord2(strs);
	}
	
	//sol1:
    public static void findLongestWord(String[] strs){
        Set<String> dict = new HashSet<String>();
        for(String s: strs) dict.add(s);
        Comparator<String> mycomp = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length()<b.length()) return 1;
                else if(a.length() == b.length()) return 0;
                else return -1;
            }
        };
        Arrays.sort(strs, mycomp);
        int count = 0;
        for(String s: strs){
            dict.remove(s);
            if(dfs(dict,s)){
            	if(count++ < 2) System.out.println("Longest # " + count +": " + s);
            }
            dict.add(s);
        }
        System.out.println("Total count: " + count);
    }
    public static boolean dfs(Set<String> dict, String target){
        if(dict.contains(target)) return true;
        for(int i = 1;i<target.length();i++){
        	if(dict.contains(target.substring(0,i)) && dfs(dict,target.substring(i))) return true;
        }
        return false;
    }
    
  //sol2:
    public static void findLongestWord2(String[] strs){
        //longest to shortest
        Comparator<String> mycomp = new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length()<b.length()) return 1;
                else if(a.length() == b.length()) return 0;
                else return -1;
            }
        };
        Set<String> set = new HashSet<String>();
        for(String s: strs)
            set.add(s);
        Arrays.sort(strs, mycomp);
        int count = 0;
        for(int i =0; i< strs.length;i++){
            if(canSplit(strs[i], true, set)){
            	if(count++ < 2) System.out.println("Longest # " + count +": " + strs[i]);
            }
        }
        System.out.println("Total count: " + count);
        
    }
    public static boolean canSplit(String s, Boolean isOriginal, Set<String> set){
        if(set.contains(s)&& !isOriginal) return true;
        for(int i =0;i<s.length();i++){
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(set.contains(left)  && canSplit(right, false, set))
                return true;
        }
        return false;
    }
	
}
