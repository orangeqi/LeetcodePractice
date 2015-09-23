
public class BestTimeToBuyAndSellStock {

	/** 121 M
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxProfit(
				new int[]{3,3,5,0,0,3,1,4}));
	}

	// Solution 1 336 ms
	public static int maxProfit(int[] prices){
		if (prices.length == 0)
			return 0;
		int min = 0, max = 0, profit = 0;
		
		for (int i = 1; i < prices.length; i++){
			if (i == prices.length-1){
				if (prices[i] >= prices[i-1])
					max = i;
				else
					if (prices[i] <= prices[min])
						min = i;
			}
			else{
				if (prices[i] >= prices[i-1]
						&& prices[i] >= prices[i+1]){
					max = i;
				}
				else if (prices[i] <= prices[i-1]
						&& prices[i] <= prices[i+1]){
					if (prices[i] < prices[min])
						min = i;
				}
			}
			if (max > min)
				profit = Math.max(prices[max]-prices[min], profit);		
		}
		return profit;
	}
}
