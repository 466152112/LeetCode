// use float convert, find 7.9 ~ 8.1
// modifiy binary search to always return the one whose value is just larger than the target
public int[] searchRange(int[] A, int target) {
    int[] result = {-1, -1};
    float big = (float)target + 0.1f;
    float small = (float)target - 0.1f;
    int start = -1, end = -1;
    start = bs(A, small);
    end = bs(A,big);
    if (start >= end)
        return result;
    result[0] = start;
    result[1] = end - 1;
    return result;
}

// binary search, always not hit the target, but return the one just large than the target
private int bs(int[] A, float target) {
    int left = 0, right = A.length - 1;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (A[mid] > target)
            right = mid - 1;
        else
            left = mid + 1;
    }
    return Math.max(left, right);
}
