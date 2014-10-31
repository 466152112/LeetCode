// 1, Brute force: O(n^3)
// 2, Using extra space, hashmap, O(n^2)
// 3, not using extra space, use cursor compare

// #3
public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	Arrays.sort(num);
	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	int len = num.length;
	if (len < 3)
		return result;
		
	int left, right, sum;	    
    for (int i = 0; i < len - 2; i++) {
        // skip duplicates more than 2
        if (i != 0 && num[i] == num[i - 1])
            continue;
        left = i + 1;
        right = len -1;
        while (left < right) {
            sum = num[left] + num[right] + num[i];
            if (sum == 0) {
                ArrayList<Integer> one = new ArrayList<Integer>(3);
                one.add(num[i]);
                one.add(num[left]);
                one.add(num[right]);
                result.add(one);
                left++;
                right--;
                while (left < right && num[left] == num[left - 1])
                    left++;
                while (left < right && num[right] == num[right + 1])
                    right--;
            }
            else if (sum < 0) {
                left++;
            }
            else {
                right--;
            }
        }
    }
	return result;
}
