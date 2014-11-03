    public int searchInsert(int[] A, int target) {
        if (A == null || A.length < 1)
            return 0;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right)/2;
            if (A[mid] == target) {
                return mid;
            }
            else if (A[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        // return left, it's because when not found the target, the inserting point is always detemined by left
        // That is to say: inserting will move the other move back on position
        return left;
    }
