package rbTree;

public class Node {
	
	public static final boolean RED = true;
	public static final boolean BLACK = false;
	
	Node parent;
	Node left;
	Node right;
	boolean color;//true为红，false为黑色
	int value;
	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Node(int value) {
		super();
		this.value = value;
	}

	public Node(Node parent, Node left, Node right, boolean color, int value) {
		super();
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.color = color;
		this.value = value;
	}
	
	public static boolean colorOf(Node node){
		return node == null ? BLACK:node.color;
	}

	@Override
	public String toString() {
		return "Node [color=" + color + ", value=" + value + "]";
	}
	
	
}
