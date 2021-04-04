package ContainsDuplicate;//LEETCODE 217.Contains Duplicate
/*
* Given an integer array nums, return true if any value appears at least twice in the array,
*  and return false if every element is distinct.
*
* */

import java.util.HashSet;
import java.util.Scanner;

public class lt0217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] arr = new int[T];

        for (int i=0;i<T; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(containsDuplicate(arr));
        System.out.println(containsDuplicate_set(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        int size = nums.length;
        int mainVal = 0;
        int compVal = 0;
        int startAddr = 0;

        for(int i = 0 ; i<size ; i++)
        {
            startAddr = i;

            for(int j = 0; j<size ; j++){
                if(startAddr == j){
                    continue;
                }
                if(nums[startAddr] == nums[j]){
                    return true;
                }
            }
        }

        return false;
    }

    //Set 을 이용한 방법.
    public static boolean containsDuplicate_set(int[] nums){
        HashSet<Integer> Set = new HashSet<>();
        int cnt= nums.length;
        for (int num : nums) {
            if (Set.contains(num))
                return true;
            else
                Set.add(num);

        }
        return false;
    }


}
