package moveCount;

public class YihuoDemo {
	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,2,4};
		YihuoDemo yd = new YihuoDemo();
		int i = yd.getUnique(arr);
		System.out.println(i);
	} 
	
	public int getUnique(int[] arr){
		int[] sum = new int[32];
		for (int item : arr) {
			for(int i = 0;i<32;i++){
				sum[i] +=(item>>i&1); 
			}
		}
		int ans = 0;
		for(int i = 0;i<32;i++){
			ans+=(sum[i]<<i)%3;
		}
		return ans;
	}

}
