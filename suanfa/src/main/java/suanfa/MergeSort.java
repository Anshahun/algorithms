package suanfa;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		int[] arr = ms.randomArray(9);
		System.out.println(Arrays.toString(arr));
		ms.mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public void mergeSort(int[] arr,int lo,int hi){
		if(lo>=hi)
			return;
		int mid = (lo+hi)/2;
		mergeSort(arr,lo,mid);
		mergeSort(arr,mid+1,hi);
		merge(arr, lo, mid,hi);
	}

	public void merge(int[] arr,int lo,int mid,int hi){
		int[] aux = Arrays.copyOf(arr, hi+1);
		int x = lo;
		int y = mid+1;
		for (int i = lo; i <= hi; i++) {
			if(x > mid){
				arr[i] = aux[y++];
			}else if(y > hi){
				arr[i] = aux[x++];
			}else if(less(aux[y],aux[x])){
				arr[i] = aux[y++];
			}else{
				arr[i] = aux[x++];
			}
		}
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
