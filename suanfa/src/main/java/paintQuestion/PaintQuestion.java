package paintQuestion;

public class PaintQuestion {
						   //行//列
	static int n = 3;
	static int[][] puzzle = new int[n+1][n+2];
	static int[][] press = new int[n+1][n+2];
	public static void main(String[] args) {
		//printf(puzzle);
		enumration(press);
	}
	
	public static void enumration(int[][] array){
		while(true){
			printf2(array);
			precess(array);
			int i = 0;
			press[1][i]++;
			while(array[1][i]>1){
				press[1][i] = 0;
				i++;
				if(i<n)
					press[1][i]++;
				else
					return;
			}
		}
	}
	
	private static void precess(int[][] array) {
		for (int i = 2; i < puzzle.length-1; i++) {
			int[] p2 = puzzle[i];
			for (int j = 1; j < p2.length-1; j++) {
				puzzle[i][j] = (puzzle[i][j]+press[i][j-1]+press[i][j]+press[i][j+1]+press[i+1][j]+press[i-1][j])%2;
				press[i][j] = 1;
			}
		}
		
	}

	public static void printf(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			int[] arr2 = array[i];
			for (int j = 0; j < arr2.length; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void printf2(int[][] array) {

		int[] arr2 = array[0];
		for (int j = 0; j < arr2.length; j++) {
			System.out.print(array[0][j]);
		}
		System.out.println();
	}

}
