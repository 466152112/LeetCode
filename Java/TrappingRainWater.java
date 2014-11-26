// find the highest bar, accumulate from both side to it
public int trap(int[] A) {
    if (A == null || A.length < 3)
        return 0;
    int result = 0; // max trapping water
    int highIndex = 0; // highest bar index
    
    // find highest bar
    for (int i = 0; i < A.length; i++)
        highIndex = A[highIndex] > A[i]?highIndex:i;
    
    // from left to highest bar
    int leftMax = 0;
    for (int i = 0; i < highIndex; i++) {
        if (leftMax > A[i])
            result += leftMax - A[i];
        else
            leftMax = A[i];
    }
    
    // from right to highest bar
    int rightMax = 0;
    for (int i = A.length - 1; i > highIndex; i--) {
        if (rightMax > A[i])
            result += rightMax - A[i];
        else
            rightMax = A[i];
    }
    return result;
}
