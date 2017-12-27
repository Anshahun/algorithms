package ClockQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClockQuestion_cp {

	static int clockArray[] = { 3, 3, 0, 2, 2, 2, 2, 1, 2 };
	static Map<Integer,int[]> changeClock = new HashMap();
	static int minLength = 30;
	static int[] minArray = new int[9];

	@SuppressWarnings("static-access")
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
		ClockQuestion_cp cq = new ClockQuestion_cp();
		System.out.println(1%4);
		cq.enumration(new int[3]);
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
		while(true){
			int i = 0;
			System.out.println(Arrays.toString(array));
			validate(array);
			array[i]++;
			while(array[i]>3){
				array[i] = 0;
				i++;
				if(i>=array.length)
					return;
				array[i]++;
			}
		}		
	}
	
	/*1       ABDE  
	 2        ABC  
	 3        BCEF  
	 4        ADG  
	 5        BDEFH  
	 6        CFI  
	 7        DEGH  
	 8        GHI  
	 9        EFHI   */    
	private static boolean validate(int[] array) {
		int[] temp = Arrays.copyOf(array, array.length);
		int i1 = temp[0];
		int i2 = temp[1];
		int i3 = temp[2];
		int i4 = (4-(clockArray[0]+i1+i2)%4)%4;//a
		int i5 = (4-(clockArray[1]+i1+i2+i3)%4)%4;//b
		int i6 = (4-(clockArray[2]+i2+i3)%4)%4;//c
		int i7 = (4-(clockArray[3]+i1+i4+i5)%4)%4;//d
		int i9 = (4-(clockArray[4]+i1+i3+i5+i7)%4)%4;//e
		int f = (clockArray[5]+i3+i5+i9)%4;
		int g = (clockArray[6]+i4+i7)%4;
		int h = (clockArray[7]+i5+i7+i9)%4;
		int i = (clockArray[8]+i6+i9)%4;
		if(f==0&&g==h&&h==i){
			int i8 = 0;
			if(g==0)
				i8 = 0;
			else
				i8 = 4-g;
			int length  = i1+i2+i3+i4+i5+i6+i7+i8+i9;
			if(length<minLength){
				minLength = length;
				minArray[0] = i1;
				minArray[1] = i2;
				minArray[2] = i3;
				minArray[3] = i4;
				minArray[4] = i5;
				minArray[5] = i6;
				minArray[6] = i7;
				minArray[7] = i8;
				minArray[8] = i9;
			}
			return true;
		}
		else
			return false;
	}

	public static void printf(int[] array){
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}	
		System.out.println();
	}
}

