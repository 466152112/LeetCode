// belowing two is for you to buy and sell stocks multitimes
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

// add one by one
public int maxProfit(int[] prices) {
  int len = prices.length, result = 0;
  // no need to check len = 0 or 1 or 2
  for (int i = 1; i < len; i++) 
    result = result + (prices[i] > prices[i-1]?prices[i] - prices[i-1]:0);
  return result;
}
