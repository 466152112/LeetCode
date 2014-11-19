// two passes, counting sort
public void sortColors(int[] A) {
    if (A == null || A.length == 0)
        return;
    int cursor = 0;
    for (int i = 0; i < A.length; i++) {
        if (A[i] == 0)
            swap(A, i, cursor++);
    }
    for (int i = cursor; i < A.length; i++) {
        if (A[i] == 1)
            swap(A, i, cursor++);
    }        
}
private void swap(int[] A, int i, int j) {
    if (i == j)
        return;
    int temp = A[j];
    A[j] = A[i];
    A[i] = temp;
}
    
// one pass, using two points
public void sortColors(int[] A) {
    if (A == null || A.length == 0)
        return;
    int index = 0;
    int front = 0;
    int end = A.length - 1;
    while (index <= end) {
        switch(A[index]) {
            case 0:
                swap(A, index++, front++);
                break;
            case 1:
                index++;
                break;
            case 2:
                swap(A, index, end--);
                break;
        }
    }
}
private void swap(int[] A, int i, int j) {
    if (i == j)
        return;
    int temp = A[j];
    A[j] = A[i];
    A[i] = temp;
}
