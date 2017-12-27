package conectLine;

import java.util.Arrays;

public class Table {
	
	public int length;
	public int width;
	public Cell[][] arr;
	
	public Table(int length,int width) {
		this.length = length;
		this.width = width;
		this.arr = new Cell[length][width];
		/*for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[j].length; j++) {
				arr[i][j] = new Cell(j,i);
			}
		}*/
	}
	
	public void setCell(Cell cell){
		arr[cell.y][cell.x] = cell;
	}
	
	public static void main(String[] args) {
		int[] a1 = new int[10];
		a1[0] = 0;
		a1[1] = 1;
		a1[2] = 2;
		a1[3] = 3;
		int i = 10;
		System.out.println(Arrays.toString(a1));
		demo(a1,i);
		System.out.println(Arrays.toString(a1));
		System.out.println(a1[4]);
	}
	
	public static void demo(int[] a1,int i){
		a1[4] = 5;
		i = 20;
	}
}

class Cell{
	int x;
	int y;
	public Cell(int x, int y) {
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
		Cell other = (Cell) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cell [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
}