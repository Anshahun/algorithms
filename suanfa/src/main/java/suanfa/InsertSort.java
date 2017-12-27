package suanfa;

import java.util.Arrays;

public class InsertSort {
	
	public static void main(String[] args) {
		int arr[] = {2,10,0,7,9,10,11,3};
		InsertSort is = new InsertSort();
		is.insertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private boolean less(int a,int b){
 		if(a<b){
			return true;
		}else{
			return false;
		}
	}
	
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void insertSort(int[] arr){
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			count ++;
			for (int j = i; j > 0&&less(arr[j],arr[j-1]); j--) {
				swap(arr, j, j-1);
			}
		}
		System.out.println(count);
	}
}
