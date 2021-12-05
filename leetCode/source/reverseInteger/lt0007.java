package reverseInteger;

import java.util.Arrays;
import java.util.Scanner;

public class lt0007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sl = new Solution();
        System.out.println(sl.reverse(sc.nextInt()));
    }

    static class Solution{
        public int reverse(int x){
            if(x==0){
                return 0;
            }
            StringBuilder sb = new StringBuilder();

            if(x<0)
                sb.append("-");

            char[] reverse = String.valueOf(x).toCharArray();

            for(int i = reverse.length -1 ; i >= 0 ; i--){
                char ch = reverse[i];
                if(ch == '-'){
                    break;
                }
                sb.append(ch);
            }

            long res = Long.parseLong(sb.toString());
            if(res < Integer.MIN_VALUE || res > Integer.MAX_VALUE){
                return 0;
            }

            return (int) res;

        }
    }

}
 