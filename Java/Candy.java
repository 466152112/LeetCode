// Input:	[1,3,4,3,2,1] Output:12 Expected:13
// two pass, adjust the miss place 1s
public int candy(int[] ratings) {
    if (ratings == null || ratings.length == 0)
        return 0;
    int sum = 0;
    int[] candy = new int[ratings.length];
    Arrays.fill(candy, 1);  // default value for all kids
    // scan from the 2st to the last
    for (int i = 1; i < ratings.length; i++) {
        if (ratings[i] > ratings[i - 1])
            candy[i] = candy[i - 1] + 1;
    }
    // scan from 2st last to first
    for (int i = ratings.length - 2; i >= 0; i--) {
        if(ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1])
            candy[i] = candy[i + 1] + 1;
    }
    for (int i:candy)
        sum += i;
    return sum;
}
