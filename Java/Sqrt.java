// Binary search, but int overflow!
// two ways, 1, change to long type, 2, use divide!
public int sqrt(int x) {
    if (x == 0 || x == 1)
        return x;
    int left = 1, right = x/2;
    while (left <= right) {
        int mid = (left + right) / 2;
        if (mid == x/mid)
            return mid;
        else if (mid > x/mid)
            right = mid - 1;
        else
            left = mid + 1;
    }
    return right;
}
