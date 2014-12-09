// 2 sum: brute force, O(n^2)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        return result;
    }
}

// using hashing map reduce to O(N)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++)
        // consider duplicates? no, because duplicates is mutual, we only keep one key in the hash map
        // etc. duplicates alwasy only keep the larger index, which will be matched bofore the for loop get there
            map.put(numbers[i],i);
        for (int i = 0; i < numbers.length; i++) {
                if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i) {
                    int j = map.get(target - numbers[i]);
                    // no need to compare the i and j, i is alway less or equal with j
                    result[0] = (i < j ? i:j) + 1;
                    result[1] = (i > j ? i:j) + 1;
                    return result;
                }
        }
        return result;
    }
}


// Round 2
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2)
            return result;
        // key is the value of number, value is the index of it
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++)
            map.put(numbers[i], i);
        // find the two sum
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i) {
                result[0] = Math.min(i, map.get(target - numbers[i])) + 1;
                result[1] = Math.max(i, map.get(target - numbers[i])) + 1;
                break;
            }
        }
        return result;
    }
