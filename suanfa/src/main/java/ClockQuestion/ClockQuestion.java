package ClockQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClockQuestion {

	static int clockArray[] = { 3, 3, 0, 2, 2, 2, 2, 1, 2 };
	static Map<Integer,int[]> changeClock = new HashMap();
	static int minLength = 1000000;
	static int[] minArray;

	public static void main(String[] args) {
		changeClock.put(1, new int[] { 0, 1, 3, 4 });
		changeClock.put(2, new int[] { 0, 1, 2 });
		changeClock.put(3, new int[] { 1, 2, 4, 5 });
		changeClock.put(4, new int[] { 0, 3, 6 });
		changeClock.put(5, new int[] { 1,3,4,5,7 });
		changeClock.put(6, new int[] { 2,5,8 });
		changeClock.put(7, new int[] { 3,4,6,7 });
		changeClock.put(8, new int[] { 6,7,8 });
		changeClock.put(9, new int[] { 4,5,7,8 });
		ClockQuestion cq = new ClockQuestion();
		cq.enumration(new int[9]);
		for (int i = 0; i < minArray.length; i++) {
			if(minArray[i]!=0){
				for(int j = 0;j<minArray[i]; j++){
					System.out.print(i+1);
				}
			}
		}
	}

	public void process() {

	}

	public static void enumration(int[] array){
		
		int i = 0;
		boolean flag = false;
		while ( i < array.length) {
			if(flag)
				i = 0;
			//System.out.println(Arrays.toString(array));
			if(Arrays.toString(array).equals("[0, 0, 0, 1, 1, 0, 0, 1, 1]"))
				System.out.println(1);
			if(validate(array)){
				int length = 0;
				for (int j = 0; j < array.length; j++) {
					length += array[j];
				}
				if(length<minLength){
					minLength = length;
					minArray = Arrays.copyOf(array, array.length);
				}
			}
			while(array[i]+1>3){//确定进制
				flag = true;
				array[i] = 0;
				i++;
				if(i==array.length)
					return;
			}
			array[i]++;
		}
		
	}
	
	private static boolean validate(int[] array) {
		int[] temp = Arrays.copyOf(clockArray, clockArray.length);
		for (int i = 0; i < array.length; i++) {//执行了几次       
			for(int k = 0;k < array[i];k++){
				int[] arr = changeClock.get(i+1);//影响了哪些钟
   				for (int j = 0; j < arr.length; j++) {
					temp[arr[j]] = (temp[arr[j]]+array[i])%4;
				}
			}
		}
		for (int i = 0; i < temp.length; i++) {
			if(temp[i]!=0){
				return false;
			}
		}
		return true;
	}

	public static void printf(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}	
		System.out.println();
	}
}
