// based on all permuations, TLE
// use count to speed up, but still TLE at 170000
public String getPermutation(int n, int k) {
    //count = k;
    return Integer.toString(permute(n).get(k - 1));
}
//private int count = 0;
private ArrayList<Integer> permute(int n) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    helper(n, result, 0);
    return result;
}

private void helper(int n, ArrayList<Integer> result, int one) {
    //if (count < 0)
        //return;    
    if (one >= (int)Math.pow(10, n - 1)) {
        result.add(one);
        //count--;
        return;
    }
    for (int i = 1; i <= n; i++) {
        if (Integer.toString(one).indexOf(i + '0') != -1)
            continue;
        one = one*10 + i;
        helper(n, result, one);
        one = one/10;
    }
}
