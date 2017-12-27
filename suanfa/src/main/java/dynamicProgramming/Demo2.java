package dynamicProgramming;

public class Demo2 {
	static int n = 3;
	static Integer[][] triangle = new Integer[n][n];
	static Integer[] maxnum = new Integer[n];
	
	public void process(){
		for(int i = n-1;i>=0;i--){
			for(int j = 0;j<=i;j++){
				if(i == n-1){
					maxnum[j] = triangle[i][j];
				}else{
					int x = maxnum[j];
					int y = maxnum[j+1];
					int max = x>y?x:y;
					int t = triangle[i][j]+max;
					maxnum[j] = t;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		triangle[0][0] = 7;
		triangle[1][0] = 3;
		triangle[1][1] = 8;
		triangle[2][0] = 8;
		triangle[2][1] = 5;
		triangle[2][2] = 0;
		Demo2 demo2 = new Demo2();
		demo2.process();
		System.out.println(maxnum[0]);
	}

}
