package grid;

import java.util.ArrayList;

public class GridDemo {
	static ArrayList<Integer> ll = new ArrayList<Integer>();
	static int size = 4;
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		ll.add(0);
		ll.add(0);
		ll.add(0);
		ll.add(0);
		process(list);
	}

	private static void process(ArrayList<Integer> list) {
		if(list.size()==0){
			//System.out.println();
			return;
		}
		for(int i=0;i<list.size();i++){
			int index = size-list.size();
			if(index>1){
				boolean flag = true;
				boolean before = ll.get(index-1)>ll.get(index-2);
				boolean after = ll.get(index-1)>list.get(i);
				if(before!=after){
					continue;
				}
			}
			ll.set(index,list.get(i));
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			copy(list2,list);
			list2.remove(list.get(i));
			if(list2.size()>0)
				process(list2);
			else
				System.out.println(ll);
		}
	}

	private static void copy(ArrayList<Integer> list2, ArrayList<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			list2.add(list.get(i));
		}
	}

}
