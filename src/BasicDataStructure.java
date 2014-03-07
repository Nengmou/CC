import java.util.*;

public class BasicDataStructure {
	public static void main(String [ ] args){
		
		int[] a = new int[3];
		int[] b = {1, 3, 5};
		System.out.println("output of int[] a");
		for(int i : a){
			System.out.println(i);
		}
		System.out.println("output of int[] b");
		for(int i : b){
			System.out.println(i);
		}

		ArrayList<String> al = new ArrayList<String>();
		al.add("Hi");
		al.add("Nemo");
		System.out.println("output of ArrayList<String>");
		for(String s : al){
			System.out.println(s);
		}
		
		LinkedList<Double> ll = new LinkedList<Double>();
		ll.add(5.5);
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.pop();
		
		Queue<String> myQueue = new LinkedList<String>();
		Queue<Integer> myNumbers = new LinkedList<Integer>();
		myQueue.add("Hello");
		myQueue.add("World");
		myNumbers.add(1);
		myNumbers.add(2);		
		
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("Nemo Wang",9527);
		ht.put("Susan", 7084);
		System.out.println("output of Hashtable<String, Integer>");
		System.out.println("hashtable value of Susan is: "+ht.get("Susan"));
		
	}
	
}

