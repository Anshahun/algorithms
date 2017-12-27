package suanfa;

public class DiguiThinking {
	public static void main(String[] args) {
		String exe = exe(6);
		System.out.println(exe);
	}

	private static String exe(int n) {
		// TODO Auto-generated method stub
		System.out.println(n);
     		if(n<=0)
			return "";
		return exe(n-3)+n+exe(n-2)+n;
	}
}
