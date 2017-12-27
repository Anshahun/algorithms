package lightQuestion;

import java.util.Arrays;

public class LightQuestion {
	public static int[][] puzzle = {{0,1,1,0,1,0},{1,0,0,1,1,1},{0,0,1,0,0,1},{1,0,0,1,0,1},{0,1,1,1,0,0}};
	public static int[][] press = new int[6][8];

	public static void main(String[] args) {
		for (int j = 0; j < 7; j++) {
			press[0][j] = 0;
		}
		for (int i = 0; i < 6; i++) {
			press[i][0] = press[i][7] = 0;
		}
		printf(puzzle);
		System.out.println("==========");
		printf(press);
		process();
		System.out.println("==========");
		printf(press);
	}

	public static void process() {
		while (!guess()) {
			int i = 0;
			press[1][i]++;
			while (press[1][i] > 1) {
				press[1][i] = 0;
				i++;
				if(i<7)
					press[1][i]++;
				else{
					System.out.println("无解");
					return;
				}
			}
		}
	}

	public static boolean guess() {
		for (int i = 1; i < 5; i++) {
			for (int j = 1; j < 7; j++) {
				int status = (puzzle[i][j]+press[i][j]+press[i][j-1]+press[i][j+1]+press[i-1][j])%2;
				press[i+1][j] = status;
			}
		}
		for (int j = 1; j < 7; j++) {
			int status = (puzzle[5][j]+press[5][j]+press[5][j-1]+press[5][j+1]+press[4][j])%2;
			if(status == 1)
				return false;
		}
		return true;

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
}
