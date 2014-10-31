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

// #2
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if (len < 3)
			return result;
		HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++)
			table.put(num[i],i);
		for (int i = 0; i < len -1; i++){
			for (int j = i + 1; j < len; j++) {
				if (table.containsKey(-num[i] - num[j]) && table.get(-num[i] - num[j]) != i && table.get(-num[i] - num[j]) != j) {
					ArrayList<Integer> one = new ArrayList<Integer>(3);
					if (-num[i] - num[j] < num[i])
						one.add(-num[i] - num[j]);
					one.add(num[i]);
					if (-num[i] - num[j] >= num[i] && -num[i] - num[j] <= num[j])
						one.add(-num[i] - num[j]);
					one.add(num[j]);
					if (-num[i] - num[j] > num[j])
						one.add(-num[i] - num[j]);
					if (!result.contains(one))
						result.add(one);
				}
			}
		}
		return result;
	}
	
// #3
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int len = num.length;
		if (len < 3)
			return result;
		for (int i = 0; i <= len -3; i++){
			for (int j = i + 1; j <= len -2; j++) {
				for (int k = j + 1; k <= len -1; k++) {
					if (num[i] + num[j] + num[k] == 0) {
						ArrayList<Integer> one = new ArrayList<Integer>(3);
						one.add(num[i]);
						one.add(num[j]);
						one.add(num[k]);
						if (!result.contains(one))
							result.add(one);
					}
				}
			}
		}
		return result;
	}
