package dynamicProgramming;

import java.util.Arrays;


public class Ski {
	static int length = 3;
	static int width = 3;
	static int ground[][] = new int[length][width];
	static int maxnum[][] = new int[length][width];
	int max = 0;
	
	public void process(){
		for (int i = 0; i < ground.length; i++) {
			for (int j = 0; j < ground[i].length; j++) {
				findPath(i,j,1);
				maxnum[i][j] = max;
				max = 0;
			}
		}
	}
	
	private void findPath(int i, int j,int num) {
		//System.out.println(i+":"+j+"==="+num);
		if(num>max)
			max = num;
		int current = ground[i][j];
		if(i-1>=0&&ground[i-1][j]<current){//top
			if(maxnum[i-1][j]!=0){
				int temp = num;
				temp += maxnum[i-1][j];
				if(temp>max)
					max = temp;
			}else{
				findPath(i-1, j,num+1);
			}
		}
		if(i+1<length&&ground[i+1][j]<current){//bottom
			if(maxnum[i+1][j]!=0){
				int temp = num;
				temp += maxnum[i+1][j];
				if(temp>max)
					max = temp;
			}else{
				findPath(i+1, j,num+1);
			}
		}
		if(j-1>=0&&ground[i][j-1]<current){//left
			if(maxnum[i][j-1]!=0){
				int temp = num;
				temp += maxnum[i][j-1];
				if(temp>max)
					max = temp;
			}else{
				findPath(i,j-1,num+1);
			}
		}
		if(j+1<width&&ground[i][j+1]<current){//right
			if(maxnum[i][j+1]!=0){
				int temp = num;
				temp += maxnum[i][j+1];
				if(temp>max)
					max = temp;
			}else{
				findPath(i,j+1,num+1);
			}
		}		
	}

	private int findPath2(int i, int j) {
		int max1 = 1;
		int max2 = 1;
		int max3 = 1;
		int max4 = 1;
		int current = ground[i][j];
		if(i-1>=0&&ground[i-1][j]<current){//top
			if(maxnum[i-1][j]!=0){
				int temp = 1;
				temp += maxnum[i-1][j];
				if(temp>max)
					max = temp;
			}else{
				max1 += findPath2(i-1, j);
			}
		}
		if(i+1<length&&ground[i+1][j]<current){//bottom
			if(maxnum[i+1][j]!=0){
				int temp = 1;
				temp += maxnum[i+1][j];
				if(temp>max)
					max = temp;
			}else{
				max2 += findPath2(i+1, j);
			}
		}
		if(j-1>=0&&ground[i][j-1]<current){//left
			if(maxnum[i][j-1]!=0){
				int temp = 1;
				temp += maxnum[i][j-1];
				if(temp>max)
					max = temp;
			}else{
				max3 += findPath2(i,j-1);
			}
		}
		if(j+1<width&&ground[i][j+1]<current){//right
			if(maxnum[i][j+1]!=0){
				int temp = 1;
				temp += maxnum[i][j+1];
				if(temp>max)
					max = temp;
			}else{
				max4 += findPath2(i,j+1);
			}
		}
		int[] arr = {max1,max2,max3,max4};
		Arrays.sort(arr);
		return arr[3];		
	}
	
	public static void main(String[] args) {
		/*ground[0][0] = 1;
		ground[0][1] = 2;
		ground[0][2] = 3;
		ground[0][3] = 4;
		ground[0][4] = 5;
		ground[1][0] = 16;
		ground[1][1] = 17;
		ground[1][2] = 18;
		ground[1][3] = 19;
		ground[1][4] = 6;
		ground[2][0] = 15;
		ground[2][1] = 24;
		ground[2][2] = 25;
		ground[2][3] = 20;
		ground[2][4] = 7;
		ground[3][0] = 14;
		ground[3][1] = 23;
		ground[3][2] = 22;
		ground[3][3] = 21;
		ground[3][4] = 8;
		ground[4][0] = 13;
		ground[4][1] = 12;
		ground[4][2] = 11;
		ground[4][3] = 10;
		ground[4][4] = 9;*/
		
		
		ground[0][0] = 9;
		ground[0][1] = 6;
		ground[0][2] = 15;
		ground[1][0] = 17;
		ground[1][1] = 14;
		ground[1][2] = 20;
		ground[2][0] = 18;
		ground[2][1] = 12;
		ground[2][2] = 13;
		Ski s = new Ski();
		int findPath2 = s.findPath2(2, 0);
		System.out.println(findPath2);
		s.process();
		for (int i = 0; i < maxnum.length; i++) { 
			for (int j = 0; j < maxnum[i].length; j++) {
				System.out.print(maxnum[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("===========");
		for (int i = 0; i < ground.length; i++) { 
			for (int j = 0; j < ground[i].length; j++) {
				System.out.print(ground[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
