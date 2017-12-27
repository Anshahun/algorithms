package suanfa;

import java.util.Arrays;
import java.util.Random;

public class QuickSort1 {
	
	public static void main(String[] args) {
		QuickSort1 qs = new QuickSort1();
		int[] array = qs.randomArray(10);
		System.out.println(Arrays.toString(array));
	}
	
	public void quickSort(int[] array){
		int hi = array.length;
		int lo = 0;
		
	}
	
	public int[] randomArray(int size){
		int[] arr = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			arr[i] = random.nextInt(200);
		}
		return arr;
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
}
