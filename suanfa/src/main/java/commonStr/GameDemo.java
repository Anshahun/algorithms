package commonStr;


public class GameDemo {
	
	int[][] sence = new int[10][10];
	Integer[][] maxnum = new Integer[10][10];
	int x;
	int y;
	int max;
	
	public void process(){
		for (int i = 0; i < sence.length; i++) {
			for (int j = 0; j < sence[i].length; j++) {
				if(1==sence[i][j]){
					if(i==0){
						maxnum[i][j] = 0;
					}else{
						int path = findPath(i, j);
 						maxnum[i][j] = path;
						if(i==x&&y==j){
							System.out.println(path);
							return;
						}
					}
				}
			}
		}	
	}
	
	public static void main(String[] args) {
		GameDemo gd = new GameDemo();
		gd.init();
		gd.process();
		System.out.println();
	}
	
	public int findPath(int i,int j){//向左or向右？
		int leftStep = 0;
		int rightStep = 0;
		int fall = 0;
		leftStep = findLeft(i, j);
		rightStep = findRight(i, j);
		if(leftStep!=-1&&rightStep!=-1){
			return leftStep>rightStep?rightStep:leftStep;
		}else if(leftStep==-1&&rightStep==-1){
			return -1;
		}else if(leftStep==-1){
			return rightStep;
		}else{
			return leftStep;
		}
	}
	
	public int findLeft(int row, int col){
		if(col==0)
			return -1;
		int leftStep = 0;
		int fall = 0;
		System.out.println(row+"======="+col);
		while(sence[row][--col]==1){
			leftStep++;
			if(col==0){
				leftStep = -1;
				return leftStep;
			}
		}
		leftStep++;
		while(row>0&&sence[--row][col]!=1){
			leftStep ++;
			fall++;
		}
		fall++;
		leftStep++;
		if(fall>max){
			leftStep = -1;
			return leftStep;
		}
		return leftStep+maxnum[row][col];
	}
	
	public int findRight(int row, int col){
		if(col==sence.length-1){
			return -1;
		}
		int rightStep = 0;
		int fall = 0;
		boolean flag = true;
		while(sence[row][++col]==1){
			rightStep++;
			if(col==sence.length-1){
				flag = false;
				rightStep = -1;
				return rightStep;
			}
		}
		rightStep++;
		while(row>0&&sence[--row][col]!=1){
			rightStep ++;
			fall++;
		}
		fall++;
		rightStep++;
		if(fall>max){
			rightStep = -1;
			return rightStep;
		}
		return rightStep+maxnum[row][col];
	}
	
	public void init(){
		max = 3;
		x = 4;
		y = 0;
		sence[4][0] = 1;
		Block b1 = new Block(0, 2, 3);
		Block b2 = new Block(1, 3, 1);
		setBlock(b1);
		setBlock(b2);
		for (int i = 0; i < sence.length; i++) {
			sence[0][i] = 1;
		}
	}

	private void setBlock(Block b1) {
		for (int i = b1.strat; i <= b1.end; i++) {
			sence[b1.height][i] = 1;
		}
	}
	

}
class Block{
	int strat;
	int end;
	int height;
	
	public Block(int strat, int end, int height) {
		super();
		this.strat = strat;
		this.end = end;
		this.height = height;
	}
		
}
