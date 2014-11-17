public int removeElement(int[] A, int elem) {
    int len = A.length;
    for (int i = 0; i < len; i++) {
        // exchange with the tail until meet the front
        while (A[i] == elem && len > i) {
            len--;
            A[i] = A[len];
        }
    }
    return len;
}


// another throught, reset every target value
int removeElement(int A[], int n, int elem) {
    int begin=0;
    for(int i=0;i<n;i++) if(A[i]!=elem) A[begin++]=A[i];
    return begin;
}
