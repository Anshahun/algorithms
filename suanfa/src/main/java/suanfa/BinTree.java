package suanfa;

import javax.lang.model.type.PrimitiveType;

import stack.Stack;

public class BinTree {

	public Node root;
	
	public void insert(Node node){
		if(this.root==null)
			root = node;
		else{
			Node temp = root;
			Node pNode = null;
			while(temp!=null){
				pNode = temp;
				if(node.value>temp.value){
					temp = temp.right;
				}else{
					temp = temp.left;
				}
			}
			if(node.value>pNode.value){
				pNode.right = node;
			}else{
				pNode.left = node;
			}
			node.parent = pNode;
		}
	}
	
	public void print(Node node){
		if(node!=null){
			System.out.println(node.value);
			print(node.left);
			print(node.right);
		}
	}
	
	public Node find(int value){
		Node temp = root;
		while(temp.value!=value){
			if(value>temp.value)
				temp = temp.right;
			else
				temp = temp.left;
			if(temp==null)
				return null;
		}
		return temp;
	}
	
	public void delete(int value){
		Node node = find(value);
		boolean isLeft = false;
		boolean isRight = false;
		boolean isRoot = false;
		if(this.root.value==node.value)
			isRoot = true;
		else if(node.value == node.parent.left.value)
			isLeft = true;
		else if(node.value == node.parent.right.value)
			isRight = true;
		Node deleteNode = node;
		if(node.left!=null&&node.right!=null){
			Node extend = findExtend(node);
			System.out.println("后集结点"+extend.value);
			if(extend.right!=null)
				extend.right.parent = extend.parent;
			extend.parent.left = extend.right;
			if(isRoot)
				this.root = extend;
			else if(isLeft){
				node.parent.left = extend;
			}else{
				node.parent.right = extend;
			}
			extend.left = node.left;
			extend.right = node.right;
		}else if(node.right!=null){
			node.right.parent = node.parent;
			if(isRoot)
				this.root = node.right;
			else if(isLeft)
				node.parent.left = node.right;
			else
				node.parent.right = node.right;
		}else if(node.left!=null){
			node.left.parent = node.parent;
			if(isRoot)
				this.root = node.left;
			else if(isLeft)
				node.parent.left = node.left;
			else
				node.parent.right = node.left;
		}else{
			if(isRoot)
				this.root = null;
			else if(isLeft)
				node.parent.left = null;
			else
				node.parent.right = null;
		}
	}
	
	public Node findExtend(Node node){
		Node extend = null;
		if(node.right!=null){
			Node temp = node.right;
			while(temp!=null){
				extend = temp;
				temp = temp.left;
			}
		}
		return extend;
	}
	
	public void noRecursionPrint(Node node){
		Stack<Node> s = new Stack<Node>();
		while(node!=null||!s.isEmpty()){
			if(node!=null){
				s.push(node);
				node = node.left;				
			}else{
				Node pop = s.pop();
				System.out.println(pop);
				node = pop.right;
			}
		}
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(10);
		Node n2 = new Node(5);
		Node n3 = new Node(4);
		Node n4 = new Node(6);
	//	Node n5 = new Node(5);
		Node n6 = new Node(8);
		Node n7 = new Node(7);
		BinTree bt = new BinTree();
		bt.insert(n1);
		bt.insert(n2);
		bt.insert(n3);
		bt.insert(n4);
		//bt.insert(n5);
		bt.insert(n6);
		bt.insert(n7);
		//bt.insert(n8);
		bt.print(bt.root);
		System.out.println("==================");
		bt.noRecursionPrint(bt.root);
	}
	
	
	public void print2(Node node){
		Stack s = new Stack();
		while(node!=null){
			if(node.left!=null)
				s.push(node);
				System.out.println(s.pop());
		}
	}

	@Override
	public String toString() {
		return "BinTree [root=" + root + "]";
	}
	
	
}
