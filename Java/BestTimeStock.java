// recursive call
public int maxProfit(int[] prices) {
  if (prices == null || prices.length == 0 || prices.length == 1)
      return 0;
  if (prices.length == 2)
      return (prices[0] < prices[1]?prices[1] - prices[0]:0);
  else
      return (prices[prices.length -2] < prices[prices.length - 1]? prices[prices.length - 1] -prices[prices.length -2]:0)
      + maxProfit(Arrays.copyOfRange(prices,0,prices.length -1));
}
