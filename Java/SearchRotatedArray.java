// long lines... one pass......
// binary search, check whether target is larger or smaller than the left mose one, handle different case cordinatlly
public int search(int[] A, int target) {
    if (A == null || A.length == 0)
        return -1;
    int left = 0;
    int right = A.length - 1;
    int mid;
    while (left <= right) {
        mid = (left + right)/2;
        if (A[left] > target) {
            if (A[mid] > target) {
                if (A[mid] >= A[left])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            else if (A[mid] < target) {
                left = mid + 1;                  
            }
            else
                return mid;
        }
        else if (A[left] < target) {
            if (A[mid] > target) {
                right = mid - 1;
            }
            else if (A[mid] < target) {
                if (A[mid] >= A[left])
                    left = mid + 1;
                else
                    right = mid - 1;                    
            }
            else
                return mid;                
        }
        else
            return left;
    }
    return -1;
}
