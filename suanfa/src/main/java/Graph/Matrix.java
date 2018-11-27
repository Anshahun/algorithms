package Graph;

public class Matrix {

    public static void main(String[] args) {
        int [][] matrix = {{0,1,1,0},{0,0,0,0},{0,0,0,1},{1,0,0,0}};
        for(int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
