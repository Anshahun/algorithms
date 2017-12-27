package suanfa;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
	
	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		//int[] arr = qs.randomArray(30);
		int[] arr = {5,4,3,2,1};
		System.out.println(Arrays.toString(arr));
		qs.quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public void quickSort(int[] arr,int lo,int hi){
		if(hi <= lo)
			return;
		int j = partition(arr, lo, hi);
		quickSort(arr, lo, j-1);
		quickSort(arr, j+1, hi);
	}
	//快速排序如果以左边为基准点，从两边开始探测的话，无论从那边开始，最后一定要与右边的的探测点交换
	//为什么一定要与右边的探测点交换呢？
	//因为左边的探测点探测出的都是比基准点大的数，用他与基准点做交换的话无法保证基准点左侧都是比他小的数，破坏了排序的规则
	private int partition(int[] arr,int lo,int hi){
		int i = lo;
		int j = hi+1;
		int v = arr[lo];
		while(true){
			while(less(v,arr[--j])){
			}
			while(less(arr[++i],v)){
				if(i==hi)
					break;
			}
			if(i>=j)
				break;
			swap(arr, i, j);
		}
		swap(arr,lo,j);
		return j;
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
