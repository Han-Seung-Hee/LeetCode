package numberofProvince;

// n 개의 도시가 있다.
// 어떤놈들은 연결되어 있어
// a 와 b 가 직접적으로 연결되어 있고
// b 와 c 가 직접적으로 연결되어 있다면
// a 는 간접적으로 c 와 연결되어 있다고 할 수 있다.

// Province 란 직/간접적으로 연결된 도시들의 집합으로 볼 수 있다

// n*n 행렬이 주어진다.
// isConnected[i][j]
// i 번째 도시와 j 번째 도시가 직접적으로 연결되어 있다면 1, 아니면 0 이다.

// Province 의 총 합을 더하라.

// 접근 : related topic 이 DFS와 Union-Find임
// 둘 중 하나를 사용해서 푸는것인가?
public class lt0547 {
    public int findCircleNum(int[][] isConnected) {
        // 부모 노드 배열 = > isConnected의 length만큼의 길이의 배열을 생성한다. -> N =3 이면 3까지 들어가겠지.
        int[] parent = new int[isConnected.length];
        // 부모 노드 배열에 0-> parent.length-1 값을 집어넣는다.
        for(int i = 0 ; i< parent.length; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i<isConnected.length; i++){

            for(int j =0 ; j < isConnected[0].length; j++){ //[0, 0..N-1] ...[N-1,0..N-1] 까지 진행
                if(isConnected[i][j] == 1) { // isConnected[i][j] 가 1 => i와 j도시가 직접적으로 연결되어 있으면
                    unionFind(parent,i,j);   // 직 / 간접적으로 연결된 도시의 수를 구한다.
                }
            }
        }

        //#2
        // 이 때 parent 배열을 한 순번 돌면서
        // parent[i] == i 인 값을 찾는다면,
        // parent[0] , parent[2] 의 2개의 경우만 나온다.
        // 답이 된다.. 뭐야 뭔데 무서워요..
        int cnt =  0;
        for(int i = 0 ; i<parent.length ; i++){
            if(parent[i] == i){ // 부모 노드 배열의 값이 i와 일치한다면
                cnt++;          // cnt 증가
            }
        }
        return cnt;             // 결과값 cnt리턴
    }

    public void unionFind(int[] indexes, int i , int j){
        //#1
        // N = 3 , isConnected[][]를 [[1,1,0],[1,1,0],[0,0,1]]로 가정할 때
        // 현재 부모 배열은 [0,1,2]
        // find메서드에서 parent[i] == i 인 경우에는 index 리턴
        // 아닌 경우엔 parent[i or j] 를 i or j에 집어넣고
        // 그 값을 비교해서 I 값이 더 적은경우에 j번 번지의 값을 I에 집어넣는다.

        //즉 CASE find(indexes, i= 0) // find(indexes, j = 1) 인 경우
        // parI : parent[0] = 0 -> 0
        // parJ : parent[1] = 1 -> 1
        // 연결은 되어있으나 parI 가 parJ 보다 작으므로
        // parent[j]는 0으로 변경됨.
        // int[] parent={0 , 0 , 2} 가 되므로 그 이후 순번인
        // (1,0) , (1,1) 은 parent[1] != 1 이 되므로 parent[1] 인 0 을 계속 가지고 오게 된다.
        // GOTO #2
        int parI = find(indexes , i);
        int parJ = find(indexes, j);
        if (parI < parJ) {
            indexes[parJ] = parI;
        }else{
            indexes[parI] = parJ;
        }
    }

    public int find(int[] indexes , int index){
        if(indexes[index] != index){
            index = indexes[index];
        }

        return index;
    }
}