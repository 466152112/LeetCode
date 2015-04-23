// HashSet to check cycle loop
public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<Integer>();
    seen.add(n);
    while (n != 1) {
        n = getSum(n);
        if (seen.contains(n))
            return false;
        seen.add(n);
    }
    return true;
}

private int getSum(int n) {
    int m = 0;
    while (n > 0) {
        m += (n%10)*(n%10);
        n /= 10;
    }
    return m;
}
