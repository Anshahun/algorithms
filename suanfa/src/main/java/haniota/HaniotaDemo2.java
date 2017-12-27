package haniota;

import stack.Stack;

public class HaniotaDemo2 {
		
	public void process(int n,Pillar src,Pillar temp,Pillar dest){
		Stack<Group> stack = new Stack<Group>();
		Group group1 = new Group(n, src, temp, dest);
		stack.push(group1);
		while(n>0||!stack.isEmpty()){
			if(n>1){
				n = n-1;
				if(n>0){
					Pillar m = temp;
					temp = dest;
					dest = m;
					Group group = new Group(n, src, temp, dest);
					stack.push(group);			
				}
			}else{
				Group group = stack.pop();
				group.src.num--;
				group.dest.num++;
				System.out.println(group);
				n = group.n - 1;
				if(n>0){
					Pillar m = group.src;
					src = group.temp;
					temp = m;
					stack.push(new Group(n, src, temp, group.dest));
				}
			}
		}
	}
	
	public void process2(int n,Pillar src,Pillar temp,Pillar dest){
		System.out.println(1);
		Stack<Group> stack = new Stack<Group>();
		Group group1 = new Group(n, src, temp, dest);
		stack.push(group1);
		while(!stack.isEmpty()){
			if(n>1){
				n = n-1;
				Pillar m = temp;
				temp = dest;
				dest = m;
				Group group = new Group(n, src, temp, dest);
				stack.push(group);			
			}else{
				Group group = stack.pop();
				group.src.num--;
				group.dest.num++;
				System.out.println(group);
				n = group.n - 1;
				if(n>0){
					Pillar m = group.src;
					src = group.temp;
					temp = m;
					stack.push(new Group(n, src, temp, group.dest));
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		HaniotaDemo2 hd = new HaniotaDemo2(); 
		Pillar a = new Pillar("A", 3);
		Pillar b = new Pillar("B", 0);
		Pillar c = new Pillar("C", 0);
		System.out.println("==========");
		hd.process2(3,a,b,c);
	}
	
	class Group{
		int n;
		Pillar src;
		Pillar temp;
		Pillar dest;
		
		public Group(int n, Pillar src, Pillar temp, Pillar dest) {
			super();
			this.n = n;
			this.src = src;
			this.temp = temp;
			this.dest = dest;
		}
		public int getN() {
			return n;
		}
		public void setN(int n) {
			this.n = n;
		}
		public Pillar getSrc() {
			return src;
		}
		public void setSrc(Pillar src) {
			this.src = src;
		}
		public Pillar getTemp() {
			return temp;
		}
		public void setTemp(Pillar temp) {
			this.temp = temp;
		}
		public Pillar getDest() {
			return dest;
		}
		public void setDest(Pillar dest) {
			this.dest = dest;
		}
		@Override
		public String toString() {
			return "Group [n=" + n + ", src=" + src + ", temp=" + temp
					+ ", dest=" + dest + "]";
		}
		
	}

}
