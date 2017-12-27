package dynamicProgramming;

import java.util.Random;

public class triangleQuestion {
	
	static Integer[][] triangle = new Integer[100][100];
	int max = 0;
	
	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.println(i+"==="+j);
				triangle[i][j] = random.nextInt(99);
			}
		}
		triangleQuestion tq = new triangleQuestion();
		tq.process(new Data(0,0),0);
		int process2 = tq.process2(new Data(0,0));
		System.out.println(process2);
		System.out.println(tq.max);
	}

	private void process(Data data,int cur) {
		int i = triangle[data.row][data.col];
		cur+=i;
		if(cur>max)
			max = cur;
		Data left = toLeft(data);
		if(left!=null){
			process(left, cur);
		}
		if(toRight(data)!=null){
			process(toRight(data), cur);
		}
	}
	
	private int process2(Data data) {
		int i = triangle[data.row][data.col];
		Data left = toLeft(data);
		int x = 0;
		int y = 0;
		if(left!=null){
			x =process2(left);
		}
		if(toRight(data)!=null){
			y =process2(toRight(data));
		}
		i+=y>x?y:x;
		return i;
	}
	
	public Data toLeft(Data data){
		if(data.row+1<triangle.length&&data.col<triangle[data.row+1].length&&triangle[data.row+1][data.col]!=null){
			return new Data(data.col,data.row+1);
		}
		return null;
	}
	
	public Data toRight(Data data){
		if(data.row+1<triangle.length&&data.col<triangle[data.row+1].length&&triangle[data.row+1][data.col+1]!=null){
			return new Data(data.col+1,data.row+1);
		}
		return null;
	}
}

class Data{
	int col;
	int row;
	public Data(int col, int row) {
		super();
		this.col = col;
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	@Override
	public String toString() {
		return "Data [col=" + col + ", row=" + row + "]";
	}
	
}
