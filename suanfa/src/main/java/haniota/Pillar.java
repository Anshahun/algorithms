package haniota;

import java.util.ArrayList;
import java.util.List;

public class Pillar implements Comparable<Pillar> {
	
	String name;
	int num;
	public Pillar(String name, int num) {
		super();
		this.name = name;
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Pillar [name=" + name + ", num=" + num + "]";
	}

	@Override
	public int compareTo(Pillar o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
	
	public static void main(String[] args) {
		List l1 = new ArrayList();
		l1.add(1);
		List l2 = l1;
		l1 = new ArrayList();
		System.out.println(l2);
		System.out.println(l1);
	}
}
