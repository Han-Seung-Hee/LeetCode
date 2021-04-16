package climbStairs;
// You are climbing a staircase. it takes n steps to reach the top.
// Each time tou can either climb 1 or 2 steps. in gow many distinct ways
// can you climb to the top?

// 매 스탭 마다 갈 수 있는 경우의 수
// n = 0 -> 1 : 0
// n = 1 -> 1 : 1
// n = 2 -> 2 : 1+1 , 2
// n = 3 -> 3 : 1+1+1 , 2+1 , 2+1
// n = 4 -> 5 : 1+1+1+1 , 2+2, 1+1+2 , 1+2+1, 2+1+1
// 피보나치 수의 형태로 증가한다.
// But 재귀로 풀면 시간 초과된다.
// 이전에 수행한 값을 미리 저장해 준다,

public class lt0070 {

    // 피보나치라고 해서 이렇게 달려들면 안됨. n이 45까지라 중복계산이 많아
    // 시간초과 가능성이 크다.
    public int climbStairs_onlyRecu(int n) {
        if(n==0) return 1 ;
        if(n==1) return 1 ;
        if(n==2) return 2 ;
        return climbStairs_onlyRecu(n-1) + climbStairs_onlyRecu(n-2);
    }

    public int climbStairs(int n){
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2 ; i < n+1 ; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[n];
    }

    // 풀고나서 본 다른방법. 별도 메모리를 소모하지 않는다.
    public int climbStairs_ano(int n){
        int a= 0, b=1;
        // 결과 값 저장 (initial value)
        int res = a+b;

        for(int i =0 ; i< n ; i++){
            // n 까지 순회를 돌면서 res 저장
            // a 에 b, b 에 res 값  저장
            res = a+b;
            a = b;
            b = res;
        }

        return res;

    }
}
