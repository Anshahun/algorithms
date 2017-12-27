package suanfa;

public class Node {
	
	public Node parent;
	public Node left;
	public Node right;
	public int value;
	public Node(int value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
	
}
