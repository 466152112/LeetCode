// use two variables to store the min value and max profit
public int maxProfit(int[] prices) {
    if (prices.length <= 1)
        return 0;
    int min = Integer.MAX_VALUE, result = 0;
    for (int i:prices) {
        min = min < i ? min : i;
        result = result > (i - min) ? result : (i - min);
    }
    return result;
}
