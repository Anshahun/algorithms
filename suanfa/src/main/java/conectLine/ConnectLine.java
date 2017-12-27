package conectLine;

import java.util.ArrayList;
import java.util.List;

public class ConnectLine {	
	
	//int direct = 0;
	int minLength = Integer.MAX_VALUE;//最大步长
	//int currentLength;//最大步长
	static final int LEFT = 1;
	static final int RIGHT = 2;
	static final int UP = 3;
	static final int DOWN = 4;
	static Table table;
	
	public void find(Cell c1,Cell c2,int direct,int currentLength,List<Cell> path){
		path.add(c1);
		List<Cell> temp = new ArrayList<Cell>(); 
		Cell cellTemp = new Cell(c1.x,c1.y);
		temp.addAll(path);
		if(toLeft(c1,c2)!=null&&!path.contains(toLeft(c1,c2))){
			if(direct!=LEFT){
				currentLength++;
			}
			if(currentLength<minLength){
				direct = LEFT;	
				cellTemp = toLeft(c1,c2);
				if(cellTemp.equals(c2)){
					minLength = currentLength;
					//return;
				}else{
					find(cellTemp, c2, direct,currentLength,temp);	
					currentLength--;
					if(c1.equals(new Cell(1,3))){
						System.out.println("=");
					}
				}										
			}
		}

		if(toRight(c1,c2)!=null&&!path.contains(toRight(c1,c2))){
			if(direct!=RIGHT){
				currentLength++;
			}
			if(currentLength<minLength){
				direct = RIGHT;	
				cellTemp = toRight(c1,c2);
				if(cellTemp.equals(c2)){
					minLength = currentLength;
					//return;
				}else{
					find(cellTemp, c2, direct,currentLength,temp);		
					currentLength--;
				}			
			}
		}
		if(toUp(c1,c2)!=null&&!path.contains(toUp(c1,c2))){
			if(direct!= UP){
				currentLength++;
			}
			if(currentLength<minLength){
				direct = UP;	
				cellTemp = toUp(c1,c2);
				if(cellTemp.equals(c2)){
					minLength = currentLength;
					//return;
				}else{
					find(cellTemp, c2, direct,currentLength,temp);
					currentLength--;
				}			
			}
		}
		if(toDown(c1,c2)!=null&&!path.contains(toDown(c1,c2))){
			if(direct!= DOWN){
				currentLength++;
			}
			if(currentLength<minLength){
				direct = DOWN;	
				cellTemp = toDown(c1,c2);
				if(cellTemp.equals(c2)){
					minLength = currentLength;
					//return;
				}else{
					find(cellTemp, c2, direct,currentLength,temp);
					currentLength--;
					if(c1.equals(new Cell(1,3))){
						System.out.println("=");
					}
				}			
			}
		}
	}
	

	public Cell toLeft(Cell c1,Cell c2){
		if(c1.x-1<0)
			return null;
		else{
			if(table.arr[c1.y][c1.x-1]!=null&&!table.arr[c1.y][c1.x-1].equals(c2))
				return null;
			else
				return new Cell(c1.x-1,c1.y);
		}				
	}
	
	public Cell toRight(Cell c1,Cell c2){
		if(c1.x+1>table.width-1)
			return null;
		else{
			if(table.arr[c1.y][c1.x+1]!=null&&!table.arr[c1.y][c1.x+1].equals(c2))
				return null;
			else
				return new Cell(c1.x+1,c1.y);
		}				
	}
	
	public Cell toUp(Cell c1,Cell c2){
		if(c1.y-1<0)
			return null;
		else{
			if(table.arr[c1.y-1][c1.x]!=null&&!table.arr[c1.y-1][c1.x].equals(c2))
				return null;
			else
				return new Cell(c1.x,c1.y-1);
		}				
	}
	
	public Cell toDown(Cell c1,Cell c2){
		if(c1.y+1>table.length-1)
			return null;
		else{
			if(table.arr[c1.y+1][c1.x]!=null&&!table.arr[c1.y+1][c1.x].equals(c2))
				return null;
			else
				return new Cell(c1.x,c1.y+1);
		}				
	}
	
	public static void main(String[] args) {
		table = new Table(6, 7);
		table.setCell(new Cell(1,1));
		table.setCell(new Cell(2,1));
		table.setCell(new Cell(3,1));
		table.setCell(new Cell(4,1));
		table.setCell(new Cell(5,1));
		table.setCell(new Cell(1,2));
		table.setCell(new Cell(5,2));
		table.setCell(new Cell(1,3));
		table.setCell(new Cell(2,3));
		table.setCell(new Cell(3,3));
		table.setCell(new Cell(5,3));
		table.setCell(new Cell(2,4));
		table.setCell(new Cell(3,4));
		table.setCell(new Cell(4,4));
		System.out.println(table.arr.length);
		for (int i = 0; i < table.arr.length; i++) {
			for (int j = 0; j < table.arr[i].length; j++) {
				if(table.arr[i][j]!=null){
					System.out.print("*");
				}else{
					System.out.print(" ");					
				}
			}
			System.out.println();
		}
		ConnectLine c = new ConnectLine();
		c.find(new Cell(1,3), new Cell(4,4), 0, 0,new ArrayList<Cell>());
		System.out.println(c.minLength);
	}
}
