
public class BST_Test {

	public static void main(String [] args){

		Node n = lowestCommonAncestor(generateNode(), new Node(20), new Node(80));
		System.out.println("the common ancestor of BST is "+(n== null?"not available":n.val));
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
