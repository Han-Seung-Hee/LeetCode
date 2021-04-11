package PositionsOfLargeGroups;
//LEETCODE 830. PositionsOfLargeGroups.
// 연속되는 동일한 문자의 길이가 3이상이면.. LargeGroups임.
// 해당하는 그룹의 시작값과 끝값을 주면 된다.
// 값 법위가 inclusive 이므로 배ㅕㅇㄹ 위치 생각하면 인생이 쉬워짐.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt0830 {
    public List<List<Integer>> largeGroupPositions(String s){
        ArrayList<List<Integer>> res = new ArrayList<>();
        int i =0 , N= s.length();
        for(int j = 0 ; j < N ; j++){
            // 마지막 까지 왔던가 , j 다음 번지 문자열이 다른경우 - 그룹이 끝난 경우
            if(j == N-1 || s.charAt(j) != s.charAt(j+1)){
                // j(마지막 번지값에서 시작값을 뺀 차이가 3이라면 (개수니까 1을 더하고..)
                if(j-i+1 >= 3){
                    // 리턴할 List에 처음과 그 끝값을 주고
                    res.add(Arrays.asList(i,j));
                }
                // 시작위치를 j+1 , 즉 다음 그룹의 시작값으로 설정.
                i = j+1;
            }
        }
        return res;
    }
}
