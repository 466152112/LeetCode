// 625431, find 2, find 3, swap 2,3, reverse, 5421
public void nextPermutation(int[] num) {
    if (num == null || num.length < 2)
        return;
    // find the first smaller number from the end
    int i = num.length - 2;
    while (i >= 0) {
        if (num[i] < num[i + 1])
            break;
        i--;
    }
    // if exist
    if (i >= 0) {
        // find the most recent larger number
        int j = num.length - 1;
        while (j > i) {
            if (num[j] > num[i])
                break;
            j--;
        }
        swap(num, i, j);
    }
    reverse(num, i + 1, num.length - 1);
}
private void swap(int[] num, int start, int end) {
    int temp = num[start];
    num[start] = num[end];
    num[end] = temp;
}
private void reverse(int[] num, int start, int end) {
    while (start < end)
        swap(num, start++, end--);
}
