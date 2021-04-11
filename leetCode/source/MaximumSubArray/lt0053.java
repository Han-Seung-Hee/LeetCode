package MaximumSubArray;

public class lt0053 {
  public static void main(String[] args) {

  }
  public void moveZeroes(int[] nums) {
  int index = 0 ;
  //일단 0이 아닌 것들을 앞으로 뺀다.
  for(int i = 0 ; i<nums.length; i++){
    if(nums[i]!=0){
      nums[index] = nums[i];
      index++;
    }
  }

  // 그 이후 1순회가 끝나면 그 이후에 index 뒤에 있는 값들은 전부 0으로 처리.
  while(index < nums.length){
    nums[index] = 0;
    index ++;
  }
}

}
