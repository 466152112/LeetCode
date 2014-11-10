// simple idea with the 3 sum
// fix first two, use left + right to move cursor for the rest
// O(N^3)
public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> one = new ArrayList<Integer>();
    Arrays.sort(num);
    if (num == null || num.length < 4)
        return result;
    for (int i = 0; i < num.length - 3; i++) {
        if (i != 0 && num[i] == num[i - 1])
            continue;
        one.add(num[i]);
        for (int j = i + 1; j < num.length - 2; j++) {
            if (j != i + 1 && num[j] == num[j - 1])
                continue;                
            one.add(num[j]);
            int left = j + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[j] + num[left] + num[right];
                if (sum < target) {
                    while (left < right && num[left] == num[left + 1])
                        left++;
                    left++;
                }
                else if (sum > target) {
                    while (left < right && num[right] == num[right - 1])
                        right--;
                    right--;                        
                }
                else {
                    one.add(num[left]);
                    one.add(num[right]);
                    result.add(new ArrayList<Integer>(one));
                    // remove the tail before the mid, otherwise will lose the tail index
                    // or you can forget about remove, instead create the new list just before you add to the result
                    one.remove(3);
                    one.remove(2);
                    while (left < right && num[left] == num[left + 1])
                        left++;
                    left++;
                    while (left < right && num[right] == num[right - 1])
                        right--;
                    right--;                        
                }
            }
            one.remove(1);
        }
        one.remove(0);
    }
    return result;
}

// more efficent way
public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);

		for (int i = 0; i < num.length - 3; i++) {
			if (i != 0 && num[i] == num[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < num.length - 2; j++) {
				if (j != i + 1 && num[j] == num[j - 1])
					continue;

				int left = j + 1;
				int right = num.length - 1;
				while (left < right) {
					int sum = num[i] + num[j] + num[left] + num[right];
					if (sum < target) {
						left++;
					} else if (sum > target) {
						right--;
					} else {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(num[i]);
						tmp.add(num[j]);
						tmp.add(num[left]);
						tmp.add(num[right]);
						rst.add(tmp);
						left++;
						right--;
						while (left < right && num[left] == num[left - 1]) {
							left++;
						}
						while (left < right && num[right] == num[right + 1]) {
							right--;
						}
					}
				}
			}
		}

		return rst;
	}
}
