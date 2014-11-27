// one pass, update current longest jump, O(N)
public boolean canJump(int[] A) {
    if (A == null || A.length == 0)
        return false;
    int[] flag = new int[A.length]; // the longest jump at this positon
    flag[0] = A[0];
    // in case of start point is 0
    if (flag[0] == 0 && A.length > 1)
        return false;
    for (int i = 1; i < A.length - 1; i++) {
        flag[i] = Math.max(A[i], flag[i - 1] - 1);  // update the longest jump
        if (flag[i] <= 0)   // cannot pass this position
            return false;
    }
    return true;
}

// save space cost, reuse table value
public boolean canJump(int[] A) {
    if (A == null || A.length == 0)
        return false;
    int previous = A[0];
    // in case of start point is 0
    if (previous == 0 && A.length > 1)
        return false;
    for (int i = 1; i < A.length - 1; i++) {
        previous = Math.max(A[i], previous - 1);  // update the longest jump
        if (previous <= 0)   // cannot pass this position
            return false;
    }
    return true;
}

// O(NlgN)
public boolean canJump(int[] A) {
    boolean[] can = new boolean[A.length];
    can[0] = true;
    
    for (int i = 1; i < A.length; i++) {
        for (int j = 0; j < i; j++) {
            if (can[j] && j + A[j] >= i) {
                can[i] = true;
                break;
            }
        }
    }
    
    return can[A.length - 1];
}
