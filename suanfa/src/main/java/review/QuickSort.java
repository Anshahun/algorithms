package review;

import java.util.Random;

public class QuickSort {
	
	public static void main(String[] args) {
		
		
	}
	
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private boolean less(int a,int b){
 		if(a<b){
			return true;
		}else{
			return false;
		}
	}
	
	public int[] randomArray(int size){
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(200);
		}
		return arr;
	}
}
