package minStack;

import java.util.Stack;

// 스택을 구현하고, 스택에서 가장 낮은 값을 넣어줘야한다.
// 문제는 상수 시간 안에 풀어야 한다..
// ArrayList로 구현해보니 minStack 값 구현시 for를 1순회를 추가로 돌아야 해서
// 상수시간으로는 나오지 않는다.
// -> 최저값을 저장하고 있지 않기 때문에..
// -> '최저값을 저장' 하기 위한 조치를 취할 때 고려할 점으로
//    pop 메서드를 처리 할 때 만약 minStack 값이 빠져나가는 경우에
//    단순히 min 값만 가지고 있다가는 처리가 불가능 함.
//    => 최저값을 넣어줄 Stack을 하나 더 추가하고, peek 값과 계속 비교하면서
//       최저값일 때에는 stack에 지속적으로 push 함.
//       minStack 메서드를 호출할 경우에는 peek값만 리턴해주면 됨.
public class lt0155 {

}

class MinStack{
    private Stack<Integer> values;
    private Stack<Integer> mins;

    public MinStack(){
        this.values = new Stack<>();
        this.mins = new Stack<>();
    }

    public void push(int val){
        values.push(val);
        if(mins.isEmpty()){
            mins.push(val);
        }else{
            if(val <= mins.peek()){
                mins.push(val);
            }
        }
    }

    public void pop(){
        int popVal = values.pop();
        if(mins.peek() == popVal){
            mins.pop();
        }
    }

    public int top(){
        return values.peek();
    }

    public int getMin(){
        return mins.peek();
    }
}
