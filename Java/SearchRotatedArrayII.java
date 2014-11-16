// Rotated Array Binary search, with duplicates
// one pass
public boolean search(int[] A, int target) {
    if (A == null || A.length == 0)
        return false;
    int left = 0;
    int right = A.length - 1;
    while (left <= right) {
        // skip the duplicates in the tail
        while (A[left] == A[right] && left < right)
            right--;
        int mid = (left + right)/2;
        if (target == A[left] || target == A[mid])
            return true;
        // target in the smaller part
        else if (target < A[left]) {
            if (target < A[mid] && A[mid] <= A[right])
                right = mid - 1;
            else 
                left = mid + 1;
        }
        // target in the larger part
        else {
            if (target > A[mid] && A[mid] >= A[left])
                left = mid + 1;
            else 
                right = mid - 1;
        }
    }
    return false;
}
