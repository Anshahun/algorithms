package rbTree;


public class RB_Tree {

	Node root;
	
	public void insert(int value){
		Node node = new Node(value);
		if(this.root==null)
			this.root = node;
		else{
			Node temp = this.root;
			Node parent = null;
			boolean isLeft = false;
			while(temp!=null){
				parent = temp;
				if(node.value<temp.value){
					isLeft = true;
					temp = temp.left;
				}
				else{
					isLeft = false;
					temp = temp.right;
				}
			}
			if(isLeft)
				parent.left = node;
			else
				parent.right = node;
			node.parent = parent;
		}
		node.color = true;
		rb_insert_fixup(node);
	}
	
	private void rb_insert_fixup(Node node) {
		while(Node.colorOf(node.parent)){
			if(node.parent==node.parent.parent.left){
				Node uncle = node.parent.parent.right;
				if(Node.colorOf(uncle)){
					node.parent.color = Node.BLACK;
					uncle.color = Node.BLACK;
					node.parent.parent.color = Node.RED;
					node = node.parent.parent;
				}else{
					if(node==node.parent.right){//这样做我理解为是要尽量保持红黑树的平衡性
						node = node.parent;
						left_rotate(node);
					}
					node.parent.color = Node.BLACK;
					node.parent.parent.color = Node.RED;
					right_rotate(node.parent.parent);
				}
			}else{
				Node uncle = node.parent.parent.left;
				if(Node.colorOf(uncle)){
					node.parent.color = Node.BLACK;
					uncle.color = Node.BLACK;
					node.parent.parent.color = Node.RED;
					node = node.parent.parent;
				}else{
					if(node==node.parent.left){//这样做我理解为是要尽量保持红黑树的平衡性
						node = node.parent;
						right_rotate(node);
					}
					node.parent.color = Node.BLACK;
					node.parent.parent.color = Node.RED;
					left_rotate(node.parent.parent);
				}
			}
		}
		if(node.parent==null){
			this.root = node;
			node.color = Node.BLACK;
		}
	}

	private void left_rotate(Node node){
		Node right = node.right;
		Node oldLeft = right.left;
		right.parent = node.parent;
		if(node.parent==null)
			this.root = node;
		else{
			if(node==node.parent.left)
				node.parent.left = right;
			else
				node.parent.right = right;
			right.left = node;
		}
		node.parent = right;
		node.right = oldLeft;
		if(oldLeft!=null){
			oldLeft.parent = node;
		}
	}
	
	private void right_rotate(Node node){
		Node left = node.left;
		if(node.parent==null){
			this.root = left;
		}else{
			if(node == node.parent.left){
				node.parent.left = left;
			}else{
				node.parent.right = left;			
			}
		}
		left.parent = node.parent;
		Node oldRight = left.right;
		left.right = node;
		node.parent = left;
		node.left = oldRight;
		if(oldRight!=null)
			oldRight.parent = node;
	}
	
	public void print(Node node){
		if(node!=null){
			System.out.println(node);
			print(node.left);			
			print(node.right);			
		}
	}
	
	public Node successor(Node node){
		Node temp = node.right;
		Node pNode = null;
		while(temp!=null){
			pNode = temp;
			temp = temp.left;
		}
		return pNode;
	}
	
	public Node presuccessor(Node node){
		Node temp = node.left;
		Node pNode = null;
		while(temp!=null){
			pNode = temp;
			temp = temp.right;
		}
		return pNode;
	}
	
	public Node find(int value){
		Node temp = this.root;
		while(temp!=null){
			if(value<temp.value)
				temp = temp.left;
			else if(value<temp.value)
				temp = temp.right;
			else
				return temp;
		}
		return null;	
	}
	
	public void delete(Node node){
		Node delNode = null;
		Node afterNode = null;
		if(node.left==null&&node.right==null)
			delNode = node;
		else
			delNode = presuccessor(node);
		System.out.println(delNode+"=======");
		afterNode = delNode.left==null ? delNode.right:delNode.left;
		if(afterNode!=null){
			afterNode.parent = delNode.parent;						
			if(delNode.parent==null)
				this.root = afterNode;
			else if(delNode == delNode.parent.left)
				delNode.parent.left = afterNode;
			else
				delNode.parent.right = afterNode;
			node.value = delNode.value;
			if(delNode.color==Node.BLACK){
				rb_delete_fixup(afterNode);
			}		
		}else{
			if(delNode.color==Node.BLACK)
				rb_delete_fixup(delNode);
			node.value = delNode.value;
			if(delNode.parent == null)
				this.root = null;
			else if(delNode == delNode.parent.left)
				delNode.parent.left = null;
			else
				delNode.parent.right = null;			
		}
	}
	
	private void rb_delete_fixup(Node node){
		while(!Node.colorOf(node)&&node!=this.root){
			if(node==node.parent.left){
				Node brother = node.parent.right;
				if(Node.colorOf(brother)){
					brother.color = Node.BLACK;
					node.parent.color = Node.RED;
					left_rotate(node);
				}else{
					if(!Node.colorOf(brother.left)&&!Node.colorOf(brother.right)){
						brother.color = Node.RED;
						node = node.parent;
					}else if(Node.colorOf(brother.left)&&!Node.colorOf(brother.right)){
						brother.left.color = Node.BLACK;
						brother.color = Node.RED;
						right_rotate(brother);
					}else if(Node.colorOf(brother.right)){
						brother.color = node.parent.color;
						node.parent.color = Node.BLACK;
						brother.right.color = Node.BLACK;
						left_rotate(node.parent);
						node = this.root;
					}
				}
			}
			else{
				Node brother = node.parent.left;
				if(Node.colorOf(brother)){
					brother.color = Node.BLACK;
					node.parent.color = Node.RED;
					right_rotate(node);
				}else{
					if(!Node.colorOf(brother.left)&&!Node.colorOf(brother.right)){
						brother.color = Node.RED;
						node = node.parent;
					}else if(Node.colorOf(brother.right)&&!Node.colorOf(brother.left)){
						brother.right.color = Node.BLACK;
						brother.color = Node.RED;
						left_rotate(brother);
					}else if(Node.colorOf(brother.left)){
						brother.color = node.parent.color;
						node.parent.color = Node.BLACK;
						brother.left.color = Node.BLACK;
						right_rotate(node.parent);
						return;	
					}							
				}
			}					
		}	
		node.color=Node.BLACK;
	}

	public static void main(String[] args) {
		RB_Tree rbt = new RB_Tree();
		rbt.insert(10);
		rbt.insert(5);
		rbt.insert(25);
		rbt.insert(3);
		rbt.insert(7);
		rbt.insert(15);
		rbt.insert(30);
		rbt.insert(1);
		rbt.insert(4);
		rbt.insert(2);
		rbt.print(rbt.root);
		System.out.println("==========");
		//System.out.println(rbt.root);
		Node node = rbt.find(5);
		rbt.delete(node);
		rbt.print(rbt.root);
	}
		
}
