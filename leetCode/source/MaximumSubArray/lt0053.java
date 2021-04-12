package MaximumSubArray;
//LEETCODE 53. Maximum SubArray
// input : integer arr
// find contiguous subArray (at least one number) which has the largest sum and it's sum

// 접근방식 정리
// 접근1: Brute Force (내가 한것..)
// len 를 배열의 길이라 할 때
// 0..len-1 ~ len-1 까지 각 케이스 ( 시작번지 ~ 끝까지 )의 값들을 계속 더해가면서
// max 값을 추려낸다.
// 131ms 가 걸린다. 이중 For 라서 그런지.

// 접근2 : Kadane's Algorithm
// 개요 : 출처는 GeeksforGeeks.
// O(N)으로 되는 방법이 있다고 하여 구글링 하다가 찾음.
/* 찾은것
Initialize:
    max_so_far = INT_MIN
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
  (c) if(max_ending_here < 0)
            max_ending_here = 0
return max_so_far
*/
// 결국 루프 돌면서 a[i] 값을 더하고,
// 더한 값이 이전까지의 최고 값 보다 작으면 값을 갱신하고,
// 더해가던 값이 음수면 더한 값을 0으로 초기화 해주면 된다고 함.
// max_ending_here 값은 계속 몸빵을 하면서 max값을 가지고 있는게 핵심인거 같음.
// max_ending_here 가 음수가 되면 아예 초기화를 시키는건 부분집합이기 때문인건지..?
// 좀 더  생각해 봐야할거 같음.

// 접근3 : Dynamic Programming
// 개요 : 동적 계획법을 활용하기 좋은 문제라고 하는데 개념을 몰라서
//        해당부분은 현재 공부중..

// 접근4 : 분할 정복 ? .. .
// 개요  : hint 에는 해당 방식에 대해 서술되어 있는데 개념 확인중 ..


public class lt0053 {
    //Brute Force 138ms
    public int maxSubArray(int[] nums){
       int maxVal = Integer.MIN_VALUE;

       for(int i = 0 ; i< nums.length ; i++){
           int currentVal = 0; // 시작 위치가 바뀔 때에는 한상 현재값을 바꿔주자.
           for(int j = i ; j<nums.length ; j++){ // 시작 위치 ~ 끝까지
               currentVal += nums[j];            // 의 값을 더한다.
               maxVal = Math.max(maxVal, currentVal); // 더하면서, 계속 max 값을 비교한다.

           }
       }
        return maxVal;
    }

    //Kadane's Algorithm
    // 9ms..
    public int maxSubArray_Kadane(int[] nums){
        int maxVal = Integer.MIN_VALUE;
        int sumVal = 0;
        boolean flag = true;

        // 하다보니까 이게 전체가 음수인 경우에는
        // 0으로 리턴되다 보니 전체가 음수인 경우에 대한 전처리가 필요했음.
        // 단순히 flag 값을 하나 주고, 배열 중 하나라도 0 이상인 경우 flag값을
        // 조절 한 후에 break 처리함.
        for(int i = 0 ; i < nums.length; i++)
        {
            if(nums[i] >= 0) {
                flag = false; // 하나라도 양수면 false;
                maxVal = Integer.MIN_VALUE;
                break;
            }
            // 값 갱신한 이유. 만약, [-2,-3,-4,-1] 인 경우 가장 큰 음수를 뱉어줘야 하기 때문임.
            // 어차피 음수들은 더해봤자 값이 작아지니..
            if(maxVal < nums[i]) maxVal = nums[i];
        }

        if(flag) return maxVal;

        for(int i = 0 ; i<nums.length; i++){
            sumVal += nums[i];

            if(sumVal < 0) sumVal = 0;
            if(maxVal < sumVal) maxVal = sumVal;

        }

        return maxVal;
    }
}
