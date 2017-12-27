package other;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Demo1 {
	
	public static void main(String[] args) {
		String str = "aassaca";
		char[] ca = str.toCharArray();
		char key = 'a';
		TreeMap<String, Object> treeMap = new TreeMap<String,Object>();
		HashMap<String, Object> hashMap = new HashMap<String,Object>();
		TreeSet<Object> treeSet = new TreeSet<Object>();
		System.out.println(treeSet.add("cc"));
		System.out.println(treeSet.add("cc"));
		System.out.println(treeSet.add(null));
		Iterator<Object> it = treeSet.iterator();
		while(it.hasNext()){
			Object next = it.next();
			System.out.println(next);
		}
	}

}
