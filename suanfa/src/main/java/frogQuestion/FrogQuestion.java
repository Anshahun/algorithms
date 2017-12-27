package frogQuestion;

import java.util.ArrayList;
import java.util.List;

public class FrogQuestion {
	private static List<Point> list;
	private static int row;
	private static int column;
	
	public static void main(String[] args) {
		row = 6;
		column = 7;
		list = new ArrayList<Point>();
		list.add(new Point(2,1));//0
		list.add(new Point(6,6));//0
		list.add(new Point(4,2));//2
		list.add(new Point(2,5));//3
		list.add(new Point(2,6));//4/
		list.add(new Point(2,7));//5/
		list.add(new Point(3,4));//6//7
		list.add(new Point(6,1));
		list.add(new Point(6,2));
		list.add(new Point(2,3));
		list.add(new Point(6,3));
		list.add(new Point(6,4));
		list.add(new Point(6,5));
		list.add(new Point(6,7));
		System.out.println(list.size());
		process();		
	}
	
	public static void process(){
		int max = 2;
		int maxStep = 2;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.size(); j++) {
				if(j==i)
					continue;
				System.out.println(j+"=============="+i);
				if(j==12&&i==1){
					System.out.println(1);
				}
				Point p1 = list.get(i);
				Point p2 = list.get(j);
				int x1 = p2.x-p1.x;
				int y1 = p2.y-p1.y;
				Point previous1 = new Point(p1.x-x1,p1.y-y1);
				if(previous1.x<0||previous1.y<0){
					continue;
				}
				if(p1.x+(max-1)*x1>row||p1.y+(max-1)*y1>column){
					continue;
				}
				Point nextPoint = new Point(p2.x+x1,p2.y+y1);
				int step = searchPath(p2,nextPoint,x1,y1);
				if(step>max){
					max = step;
				}
			}
		}
		System.out.println("max="+max);
	}

	private static int searchPath(Point p2,Point nextPoint,int x1,int y1) {
		int step = 2;
		// TODO Auto-generated method stub
		while(list.contains(nextPoint)){
			step++;
			nextPoint = new Point(nextPoint.x+x1,nextPoint.y+y1);
		}
		return step;
	}
}

class Point{
	int x;
	int y;
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}	
	
	
}