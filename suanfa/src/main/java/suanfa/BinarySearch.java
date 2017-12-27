package suanfa;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,8,10,12};
		int key = diguiBinarySearch(arr, 8, 0, arr.length-1,0);
		System.out.println(key);
	}
	
	private static int binarySearch(int[] arr,int key){
		int lo = 0;
		int hi = arr.length - 1;
		while(lo <= hi){
			int mid = (lo + hi)/2;
			if(key<arr[mid])
				hi = mid - 1;
			else if(key>arr[mid])
				lo = mid + 1;
			else
				return arr[mid];
		}
		return -1;	
	}
	
	private static int diguiBinarySearch(int[] arr,int key,int lo,int hi, int count){
		if(lo <= hi){
			for (int i = 0; i < count; i++) {
				System.out.print("\t");				
			}
			System.out.println(lo);
			for (int i = 0; i < count; i++) {
				System.out.print("\t");				
			}
			System.out.println(hi);
			int mid = (lo + hi)/2;
			if(key < arr[mid]){
				hi = mid -1;
				int temp = diguiBinarySearch(arr, key, lo, hi,++count);
				return temp;
			}else if(key > arr[mid]){
				lo = mid + 1;
				int temp = diguiBinarySearch(arr, key, lo, hi,++count);
				return temp;
			}else{
				return arr[mid];
			}
		}
		return -1;
	}
}
