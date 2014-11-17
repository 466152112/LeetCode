// remove duplicates frequency larger than twice, in the Array
public int removeDuplicates(int[] A) {
    if (A.length < 3)
        return A.length;
    int slow = 0;
    int fast = 2;
    while (fast < A.length) {
        if (A[slow] == A[fast])
            fast++;
        else
            A[++slow + 1] = A[fast++];
    }
    return slow + 2;
}
