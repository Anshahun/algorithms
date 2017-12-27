package commonStr;

import java.util.Arrays;

public class Demo {
	
	static Integer maxnum[][] = new Integer[10][10];
	
	/*
	 *  if (sz1[i-1]==sz2[j-1]){  
                    maxLen[i][j]=maxLen[i-1][j-1]+1;  
                }//两个位置上字符一样  
                  
                else{  
                    maxLen[i][j]=max(maxLen[i-1][j],maxLen[i][j-1]);  
                } 
	 * 
	 */
	
	public void process(String str1,String str2){
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		for (int i = 1; i <= c1.length; i++) {
			for (int j = 1; j <= c2.length; j++) {
				if (c1[i-1]==c2[j-1]){  //两个位置上字符一样     
                    maxnum[i][j]=maxnum[i-1][j-1]+1;  
                }else{  
                	maxnum[i][j]=max(maxnum[i-1][j],maxnum[i][j-1]);  
                } 
			}
		}
	}
	
	private int max2(int i, int j) {
		int max = 0;
		for (int k = 0; k < j; k++) {
			if(maxnum[i][k]>max)
				max = maxnum[i][k];
		}
		return max;
	}

	private int max(int i,int j) {
		return i>j?i:j;
	}

	public static void main(String[] args) {
		for (int i = 0; i < maxnum.length; i++) {
			maxnum[0][i] = 0;
		}
		for (int i = 0; i < maxnum.length; i++) {
			maxnum[i][0] = 0;
		}
		Demo demo = new Demo();
 		demo.process("abcde", "aebcd");
		for (int i = 0; i < maxnum.length; i++) {
			System.out.println(Arrays.toString(maxnum[i]));
		}
	}
	
}
