// there are duplicates in the array
// if you use sequential scan, there are no complexity difference
// but, if you use Binary Search, the front and end may be the same value, this will effect the swich condition,
// I just skip the front and end duplicates
public int findMin(int[] num) {
    if (num == null || num.length == 0)
        return Integer.MAX_VALUE;
    int left = 0;
    int right = num.length - 1;
    if (num[left] < num[right])
        return num[left];
    while (left < right && num[left] == num[left + 1])
        left++;
    while (left < right && num[right] == num[right - 1])
        right--;            
    while (left < right - 1) {
        int mid = (left + right)/2;
        if (num[left] <= num[mid]) {
            left = mid;
        }
        else {
            right = mid;
        }
    }
    return num[right];
}


// squential scan
public int findMin(int[] num) {
    if (num == null || num.length == 0)
        return Integer.MAX_VALUE;
    for (int i:num) {
        if (i < num[0])
            return i;
    }
    return num[0];
}
