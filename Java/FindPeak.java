// only one peak in the array
public int findPeakElement(int[] num) {
    if (num.length < 2)
        return 0;
    if (num[0] > num[1])
        return 0;
    if (num[num.length - 1] > num[num.length - 2])
        return num.length - 1;
    int left = 1;
    int right = num.length - 2;
    while (left < right) {
        int mid = (left + right) / 2;
        if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1])
            return mid;
        if (num[mid] > num[mid - 1])
            left = mid + 1;
        else
            right = mid - 1;
    }
    return right;
}
