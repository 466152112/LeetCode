// Complecity O(N), scan the array
public int findMin(int[] num) {
    if (num == null || num.length < 1)
        return Integer.MAX_VALUE;
    for (int i = 1; i < num.length; i++) {
    // if the next one if smaller than previous one, then found
        // or, you can compare it with the num[0] too
        if (num[i] < num[i - 1])
            return num[i];
    }
    // otherwise, return the fisrt one
    return num[0];
}

// similar idea with Binary search
public int findMin(int[] num) {
    if (num == null || num.length == 0)
        return Integer.MAX_VALUE;
    int left = 0, right = num.length - 1;
    while (left < right) {
        // left smaller than right, hit the begining of small array
        if (num[left] < num[right])
            return num[left];
        int mid = (left + right)/2;
        // left < mid, still in the large part
        if (num[left] < num[mid]) {
            left = mid;
        }
        // left == mid, means, left = right - 1
        // or use (left < right - 1) as while loop condition
        else if (left == mid) {
            break;
        }
        else {
            right = mid;
        }
    }
    return num[right];
}
