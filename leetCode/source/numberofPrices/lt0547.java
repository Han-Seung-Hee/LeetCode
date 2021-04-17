package numberofPrices;

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

// 접근 : related topic 이 DFS와 Union-Find 를 사용함.
// 연결 상태를 체크하기 위해 DFS , 집합을 찾기위해 Union-Find 방식을 사용하는 듯 함.
public class lt0547 {
}
