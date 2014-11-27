// O(NlgN), reachable from the first position? step + 1
public int jump(int[] A) {
    if (A == null || A.length == 0)
        return Integer.MAX_VALUE;
    int[] steps = new int[A.length];
    Arrays.fill(steps, Integer.MAX_VALUE);
    steps[0] = 0;	// position 0 reachable
    for (int i = 1; i < A.length; i++) {
        for (int j = 0; j < i; j++) {
        	// reachable from j
            if (A[j] + j >= i) {
                steps[i] = steps[j] + 1;
                break;
            }
        }
        // position i not reachable
        if (steps[i] == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
    }
    return steps[A.length - 1];
}
