
public class BST_Test {

	public static void main(String [] args){
		
		printBT(generateNode(), "pre-order");
		
		Node n = lowestCommonAncestor(generateNode(), new Node(20), new Node(80));
		System.out.println("the common ancestor of BST is "+(n== null?"not available":n.val));
		
		Boolean isBalanced = isBalanced(generateNode());
		System.out.println("isBalanced = " + isBalanced);
		
		boolean isBST = isBST(generateNode());
		System.out.println("isBST " + isBST);
		
	}
	
	//a random generated node
	public static Node generateNode(){
		Node root = new Node(55);
		root.left = new Node(30);
		root.right = new Node(70);
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		root.right.left = new Node(60);
		root.right.right = new Node(88);	
		return root;
	}
	
	//lowest Common Ancestor: works for BST only
	public static Node lowestCommonAncestor(Node root, Node a, Node b) {
	    if (root == null || a == null || b == null) {
	        return null;
	    }	    
	    if (Math.max(a.val, b.val) < root.val) { 
	        // both nodes are on the left
	        return lowestCommonAncestor(root.left, a, b);    
	    } else 
	    if (Math.min(a.val, b.val) > root.val) {
	        // both nodes are on the right
	        return lowestCommonAncestor(root.right, a, b);    
	    } else {
	        // the nodes are on separate branches
	        return root;
	    }
	}
	
	//check if a BT is balanced: cc4.1
	public static Boolean isBalanced(Node n){
		return getHeight(n) != -1;
	}	
	
	public static int getHeight(Node n){
		
		if(n == null) return 0;
		
		int hLeft = getHeight(n.left);
		if(hLeft == -1) return -1;
		
		int hRight = getHeight(n.right);
		if(hRight == -1) return -1;
		
		if(Math.abs(hLeft - hRight) > 1) return -1;
		
		return Math.max(hLeft, hRight) + 1;
	}
	
	//check if a BT is a BST: cc4.5
	public static boolean isBST(Node n){
		return checkBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean checkBST(Node n, int min, int max){
		if(n == null) return true;
		if(n.val < min || n.val > max) 
			return false;
		else 
			return checkBST(n.left, min, n.val) && checkBST(n.right, n.val, max);
	}
	
	
	//print a BT
	public static void printBT(Node n, String order){
		if(n == null) return;
		switch(order.toLowerCase()){
			case "pre-order":
				System.out.print(String.format("%1$"+5+ "s", n.val));
				printBT(n.left, order);
				printBT(n.right, order);
				System.out.println();
				break;
			case "in-order":
				printBT(n.left, order);
				System.out.print(String.format("%1$"+5+ "s", n.val));
				printBT(n.right, order);
				System.out.println();
				break;
			case "post-order":
				printBT(n.left, order);
				printBT(n.right, order);
				System.out.print(String.format("%1$"+5+ "s", n.val));
				System.out.println();
				break;
			default:
				System.out.println("wrong order parameter...");
				break;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
