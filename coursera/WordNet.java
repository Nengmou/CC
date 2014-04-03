import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Scanner;

public class WordNet {	
	private HashMap<String, Integer> map;
	private HashMap<Integer, Bag<Integer>> bags;
	private HashMap<String, Boolean> marks;
	
	// constructor takes the name of the two input files
	public WordNet(String synsets, String hypernyms) throws FileNotFoundException{
		map = new HashMap<String, Integer>();
		File file = new File(synsets);
		//Scanner scan = new Scanner(file);
		try(Scanner scan = new Scanner(file)){
			while(scan.hasNextLine()){
				String[] fields = scan.nextLine().split(",");
				map.put(fields[1], Integer.parseInt(fields[0]));
			}
		}

		file = new File(hypernyms);
		bags = new HashMap<Integer, Bag<Integer>>();
		try(Scanner scan = new Scanner(file)){
			while(scan.hasNextLine()){
				Bag<Integer> bag = new Bag<Integer>();
				String[] fields = scan.nextLine().split(",");
				for(int i = 1; i < fields.length; i++){
					bag.add(Integer.parseInt(fields[i]));
				}
				bags.put(Integer.parseInt(fields[0]), bag);
			}			
		}
		
		marks = new HashMap<String, Boolean>();
	}
	
	// the set of nouns (no duplicates), returned as an Iterable
	public Iterable<String> nouns(){		
		return map.keySet();
	}
	
	// is the word a WordNet noun?
	public boolean isNoun(String word){
		return map.containsKey(word);
	}
	
	private void resetMarks(){
		for(String key : map.keySet()) marks.put(key, false);
	}
	
	private int distanceFromTo(String nounA, String nounB){
		Integer intA = map.get(nounA);
		Integer intB = map.get(nounB);
		Integer distance = 0;
		resetMarks();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(intA);
		marks.put(nounA, true);
		
		while(!queue.isEmpty()){
			queue.remove();
			for(Integer adjacent : bags.get(intA)){
				if(intB == adjacent) break;
				queue.add(adjacent);
			}
			distance++;
		}
		return distance;
	}

	// distance between nounA and nounB (defined below)
	public int distance(String nounA, String nounB){
		if(!isNoun(nounA) || !isNoun(nounB)) throw new IllegalArgumentException("noun not in synmap");
		return distanceFromTo(nounA, nounB);
	}

	public static void main(String[] args) throws FileNotFoundException{
		WordNet wordnet = new WordNet("C:/Users/nwang/Desktop/synsets.txt", "C:/Users/nwang/Desktop/hypernyms.txt");
		System.out.println(wordnet.isNoun("antihistamine"));
	}
}
