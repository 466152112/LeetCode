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

// count the index, just compute that permuation value
public String getPermutation(int n, int k) {
    StringBuilder sb = new StringBuilder();
    boolean[] used = new boolean[n];
    int fact = 1;   // (n - 1)!, 1...,2...,3...,...,n..., each interval is size (n - 1)!
    k = k - 1;  // so that boundary case k%fact == 0 if in the k/fact interval
    for (int i = 1; i < n; i++)
        fact *= i;
    for (int i = 0; i < n; i++) {
        int index = k / fact;
        k = k % fact;
        // update fact by dividing the greatest one
        if (i < n - 1)
            fact = fact/(n - i - 1);
        // scan the candidates to choose the unused one after the index
        for (int j = 1; j <= n; j++) {
            if (used[j] == false) {
                if (index == 0) {
                    sb.append((char)(j + '0'));
                    used[j] = true;
                    break;
                }
                else
                    index--;
            }
        }
    }
    return sb.toString();
}
