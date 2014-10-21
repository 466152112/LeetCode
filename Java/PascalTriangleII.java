// use constant space, initail the array with capacity, reuse the array
public ArrayList<Integer> getRow(int rowIndex) {
    if (rowIndex < 0)
        return null;
    ArrayList<Integer> result = new ArrayList<Integer>(rowIndex + 1);
    result.add(1);
    for (int i = 1; i <= rowIndex; i++) {
        // temp0 store the sum of two numbers, temp1 store the first number
        int temp0 = 0, temp1 = 1;
        for (int j = 1; j < i; j++) {
            temp0 = temp1 + result.get(j);
            temp1 = result.get(j);
            result.set(j,temp0);
        }
        result.add(1);
    }
    return result;
}
