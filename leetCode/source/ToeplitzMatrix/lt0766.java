package ToeplitzMatrix;// 766. toeplitz matrix

import java.util.HashMap;
import java.util.Scanner;

public class lt0766 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while(T>0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            solution sol = new solution();
            boolean result = sol.isToeplitzMatrix(arr);
            System.out.println(result);
            T--;
        }
    }

}
class solution{
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int rowVal = 0;
        int colVal = 0;
        int firstVal = 0;
        // 진행방향
        // 1. (0,0) .. (0,max(col)-1)
        // 2. (1,0) .. (max(row)-1,0)
        //  => 대각선 체크해서 다 동일하면 끝

        for(int i = 0 ; i < col; i++){
            rowVal = 0 ;
            colVal = i ; //(0..col)
            firstVal = matrix[rowVal][colVal];
//            System.out.println(rowVal+"...."+colVal);
            while(++rowVal < row && ++colVal < col){
//                System.out.println(rowVal+"...."+colVal);
//                System.out.println(firstVal);
//                System.out.println(matrix[rowVal][colVal]);
                if(firstVal != matrix[rowVal][colVal]) {
                    return false;
                }
            }
        }

        for (int j = 1 ; j < row; j++){
            rowVal = j; // 1..row
            colVal = 0;
            firstVal = matrix[rowVal][colVal];

            while(++rowVal < row && ++colVal < col){
                if(firstVal != matrix[rowVal][colVal]) {
                    return false;
                }
            }
        }

        return true;


    }

    //Check Toeplitz Matrix : Using HashMap
    // 각 대각선의 차이값은 Unique함. Mat(i,j)의 대각선은 Mat(i-k,j-k) 또는 Mat(i+k, j+k)로 정의 가능
    // 이때 Mat(i,j)의 위치상 차이는 i-j로 정의 가능 (i-k)-(j+k) == (i+k)-(i+j) == i-j 이기 때문.
    // 즉, HashMap을 사용, 위치상 차이값을 key, 해당하는 행렬의 값을 value에 저장한다.
    // 모든 행렬을 순회하면서 해당 값이 있으면 넘어가고, 값이 다를 경우 false return 한다.

    public boolean isToeplitzMatrix_hash(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int diff = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i<rows ; i++){
            for(int j=0 ; j<cols ; j++){
                diff = i-j ;
                if(map.containsKey(diff)){
                    if(map.get(diff) != matrix[i][j]){
                        return false;
                    }
                }else{
                    map.put(diff,matrix[i][j]);
                }
            }
        }
        return true;
    }

 }
