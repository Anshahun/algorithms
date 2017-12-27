package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo {
	static int addnum = 3;
	//static TreeSet set = new TreeSet();
	static List<Integer> arr = new ArrayList<Integer>();
	
	public Plant process(String str){
		int bestnum = Integer.MAX_VALUE;
		Plant p = new Plant(-1,-1,-1, bestnum);
		for (int i = 0; i < str.length(); i++) {
			String s1 = str.substring(0, i);
			String s2 = str.substring(i, str.length());
			Integer i1 = 0;
			Integer i2 = 0;
			if(!s1.equals(""))
				i1 = new Integer(s1);
			if(!s2.equals(""))
				i2 = new Integer(s2);
			int i3 = i1+i2;
			if(i3<p.num){
				p.i1 = i1;
				p.i2 = i2;
				p.index = i;
				p.num = i3;
			}
		}
		arr.add(p.i1);
		arr.add(p.i2);
		Collections.sort(arr);
		return p;
	}
	
	public static void main(String[] args) {
		String str = "12345";
		Demo demo = new Demo();
		List<Plant> list =  new ArrayList<Plant>();
		Plant plant = demo.process(str);
		list.add(plant);
		for (int i = 1; i < addnum; i++) {
			Plant best = new Plant(-1,-1,-1, Integer.MAX_VALUE);
			int k = arr.get(arr.size()-1);
			arr.remove((Object)k);
			Plant process = demo.process(k+"");
			if(process.num<best.num){
				best = process;
			}
			list.add(best);
		}
		System.out.println(list);
		System.out.println(arr);
		int result = 0;
		for (int i : arr) {
			result+=i;
		}
		System.out.println(result);
	}

}

class Plant{
	int i1;
	int i2;
	int index;
	int num;
	

	public Plant(int i1, int i2, int index, int num) {
		super();
		this.i1 = i1;
		this.i2 = i2;
		this.index = index;
		this.num = num;
	}


	@Override
	public String toString() {
		return "Plant [i1=" + i1 + ", i2=" + i2 + ", index=" + index + ", num="
				+ num + "]";
	}


	
}
