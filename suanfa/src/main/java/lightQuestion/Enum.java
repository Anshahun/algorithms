package lightQuestion;

import java.util.Arrays;

public class Enum {
	static int [] array = new int[4];
	
	public static void main(String[] args) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array.length);
		}
		//process(array);
		process2(array);
	}
	
	public static void printf(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}	
		System.out.println();
	}
	
	public static void process(int[] array){
		//array[0]++;
		int i = 0;
		boolean flag = false;
		while ( i < array.length) {
			if(flag)
				i = 0;
			printf(array);
			while(array[i]+1>1){
				flag = true;
				array[i] = 0;
				i++;
				if(i==array.length)
					return;
			}
			array[i]++;
		}
	}
	
	public static void process2(int[] array){
		int c = 0;
		int count = 0;
		while(true) {
			c = 0;
			count++;
			printf(array);
	        array[c]++;
	        while(array[c]>2) {  //累加进位
	            array[c]=0;
	            c++;
	            if(c<array.length){
	            	array[c]++; 	
	            }else{
	            	System.out.println(count);
	            	return;
	            }
	        }
	    }
	}
	
	public void demo(){
		int clockArray[] = { 3, 3, 0, 2, 2, 2, 2, 1, 2 };
		int[] temp = Arrays.copyOf(clockArray, clockArray.length);
		clockArray[0] = 100;
		System.out.println(temp[0]);
	}

}
