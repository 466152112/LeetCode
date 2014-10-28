public int maxProfit(int[] prices) {
      if (prices == null || prices.length <= 1)
          return 0;
      int len = prices.length;
      int[] left = new int[len], right = new int[len];
      left[0] = 0;
      right[len -1] = 0;
      int min = prices[0], max = prices[len -1];
      
      // DP from left, keep current max profit
      for (int i = 1; i < len; i++) {
          min = Math.min(min,prices[i]);    
          left[i] = Math.max(prices[i] - min,left[i-1]);
      }
      
      // DP from right, keep current max profit
      for (int i = len -2; i >= 0; i--) {
          max = Math.max(max,prices[i]);
          right[i] = Math.max(max - prices[i],right[i+1]);
      }
      
      // add left and right to the max total profit
      int result = 0;
      for (int i = 0; i < len; i++) {
          result = Math.max(left[i] + right[i],result);
      }
      return result;
  }
