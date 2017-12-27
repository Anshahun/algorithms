package stack;

public class Stack<T> {
	
	T[] arr = (T[]) new Object[10];
	int size = 0;
	
	public void push(T t){
		//int length = arr.length;
		arr[size++] = t;
	}
	
	public T pop(){
		T temp =  arr[--size];
		return temp;
	}
	
	public void print(){
		for (Object object : arr) {
			System.out.println(object);
		}
	}
	
	public boolean isEmpty(){
		return this.size==0;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		stack.push(6);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());			
		}
	}
}
