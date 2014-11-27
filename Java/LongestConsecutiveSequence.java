// sorting cost O(NlgN) time and O(1) space
// HashMap cost O(N) time and O(N) space
public int longestConsecutive(int[] num) {
    if (num == null || num.length == 0)
        return 0;
    HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    // initial the map value to false
    for (int i:num)
        map.put(i, false);
    int current_max = 1;
    int total_max = 1;

    for (int i:num) {
        if (map.get(i))
            continue;
        map.put(i, true);
        current_max = 1;
        // count large part
        int temp = i;
        while (map.containsKey(temp + 1)) {
            current_max++;
            map.put(temp + 1, true);
            temp++;
        }
        // count small part
        temp = i;
        while (map.containsKey(temp - 1)) {
            current_max++;
            map.put(temp - 1, true);
            temp--;
        }
        total_max = Math.max(total_max, current_max);
    }
    return total_max;
}
