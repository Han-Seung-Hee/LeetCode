package buyandsellStock2;
// 최대 profit 구하기
// i 번째 원소가 i 일의 주식 가격 -> int[] price
// 최대 이득을 얻을 수 있도록 해야함.
// 주식을 구 매 후 되파는 행위 가능.
// 동시에 여러 거래를 할 수 없으며, 새로 사기 전에는 기존 주식을 팔아야 한다.
// 결국 , 쌀 때 사서 비쌀 때 팔아야 한다.

// 접근 1 : 각각의 경우를 다 저장한다. (BRUTE FORCE)
//         팔 경우 , 살 경우에 대한 경우를 다 저장하다가는 답이 없을정도로 수가 늘어나게 됨.
// 접근 2 : 규칙성 찾기.
//          N 일의 값이 N-1 의 값보다 크면 그 차이를 저장한다.
//
public class lt0122 {
    //O(N)
    public int maxProfit(int[] prices){
        int profit = 0;
        for(int i = 0 ; i<prices.length-1 ; i++){
            if(prices[i+1] > prices[i]){
                profit += prices[i+1] - prices[i];
            }
        }
        return profit;
    }

    // 무식하게 풀기
    // 몸과 마음이 피폐해지니 시도도 하지 말것 O(N^N) - 이전까지의 이익값을 재귀로 구하기 때문
    // 시간 초과!
   public int maxProfit_brute(int[] prices){
        return calculate(prices, 0);
    }

    public int calculate(int[] prices, int s){
        if(s>= prices.length){
            return 0;
        }
        int max = 0 ;
        for(int st = s; st<prices.length ; st++){ // 입력받은 s -> 배열 끝 까지
            int maxProfit = 0 ;
            for(int i = st+1; i< prices.length; i++){ //st + 1 -> 배열 끝까지
                if(prices[st] < prices[i]){           //  시작 값 보다 i 값이 더 크다면
                    //이익 = 현재까지 거래한 값의 합 + 시작값과 비교한 i 값의 차 (해당 시점 이익)
                    int profit = calculate(prices, i+1) + prices[i] - prices[st];
                    if(profit > maxProfit) // maxprofit
                        maxProfit = profit;
                }
            }
            if(maxProfit > max)
                max = maxProfit;
        }
        return max;
    }
}
