package review;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr1 = {1,3,5,7,9,11,15};
		int[] arr2 = {2,4,6,8};
		int[] merge = ms.merge(arr1, arr2);
		System.out.println(Arrays.toString(merge));
	}
	
	public int[] merge(int[] arr1,int[] arr2){
		int total = arr1.length+arr2.length;
		int[] arr3 = new int[total];
		int x = 0;
		int y = 0;
		for (int i = 0; i < arr3.length; i++) {
			if(x >= arr1.length){
				arr3[i] = arr2[y++];
			}else if(y >= arr2.length){
				arr3[i] = arr1[x++];
			}else if(less(arr2[y], arr1[x])){
				arr3[i] = arr2[y++];
			}else{
				arr3[i] = arr1[x++];
			}
		}
		return arr3;
	}
	
	public boolean less(int a,int b){
		if(a < b){
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
