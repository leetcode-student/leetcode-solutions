package solutions;

public class Problem121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int max = 0;
        int low = prices[0];

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - low);
            low = Math.min(low, prices[i]);
        }

        return max;
    }
}
