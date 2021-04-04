package removeDuplicate1;//1047. Remove All Adjacent Duplicates In String
// 계속 돌려서 인접한 두 문자열이 중복되었다면 이를 지운다.

import java.util.Scanner;
import java.util.Stack;

public class lt1047 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String ans = removeDuplicates(S);
        System.out.println(ans);
    }

    public static String removeDuplicates(String S) {
        // int cnt = S.length();
        boolean[] removed = new boolean[S.length()]; // S 길이만큼 배열을 생성


        for (int i = 1 ; i<S.length() ; i++) {//STARTFOR : 0으로 잡으면 OutofBoundException , 어차피 이전값이랑 비교함.
            int bfVal = i-1;

            while(!removed[bfVal] && !removed[i] && S.charAt(bfVal) == S.charAt(i)){
                removed[bfVal] = true;
                removed[i] = true;

                // 지워졌으면 bfVal을 한번지 뒤로 빼준다.
                while(bfVal > 0 && removed[bfVal]) {
                    bfVal--;
                }

                // 지워졌으면 i 값은 그 다음번지로 빼버린다.
                while(i<S.length()-1 && removed[i]) {
                    i++;
                }
            }
        }//END FOR

        // 문자열 조립
        StringBuilder sb = new StringBuilder();

        for(int j = 0 ; j <S.length() ; j++){
            if(!removed[j]){ // 제거되지 않은 경우
                sb.append(S.charAt(j));
            }
        }

        return sb.toString();
    }

    // 스택을 이용해보기
    // 문자열을 순회하면서 stack 내의 peek값과 해당 문자열 번지의 값 비교
    // 만약 일치한다면 stack의 값을 pop 한다.
    // 일치하지 않는다면 그 값을 집어넣는다.

    public static String removeDuplicates_stack(String S) {
        Stack<Character> stack = new Stack<>();

        for(char c : S.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(c);
        }

        return sb.toString();
    }
}
