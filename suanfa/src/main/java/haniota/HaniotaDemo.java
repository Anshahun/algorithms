package haniota;

import java.util.TreeSet;

public class HaniotaDemo {
	
	public static final String A = "a";
	public static final String B = "b";
	public static final String C = "c";
	
	
	public void process(int n,Pillar src,Pillar temp,Pillar dest){
		if(n==1){
			src.num--;
			dest.num++;
			TreeSet ts = new TreeSet<Pillar>();
			ts.add(src);
			ts.add(temp);
			ts.add(dest);
			System.out.println(n+"++++++++"+ts);
		}else{
			process(n-1,src,dest,temp);
			src.num--;
			dest.num++;
			TreeSet ts = new TreeSet<Pillar>();
			ts.add(src);
			ts.add(temp);
			ts.add(dest);
			System.out.println(n+"====="+ts);
			//process(n,src,temp,dest);
			process(n-1,temp,src,dest);			
		}
	}	
	
	public static void main(String[] args) {
		HaniotaDemo hd = new HaniotaDemo(); 
		Pillar a = new Pillar("A", 3);
		Pillar b = new Pillar("B", 0);
		Pillar c = new Pillar("C", 0);
		hd.process(3,a,b,c);
	}

}
