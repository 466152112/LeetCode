// hint: hashmap or hashset, two point

// 1, hashmap, leftBound, when meet duplicate, remove from leftBound to oldIndex
public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0)
        return 0;
    int result = 0;
    int leftBound = 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer> ();
    for (int i = 0; i < s.length(); i++) {
        if (!map.containsKey(s.charAt(i))) {
            map.put(s.charAt(i),i);
        }
        else {
            result = Math.max(result, map.size());
            int oldIndex = map.get(s.charAt(i));
            for (int j = leftBound; j <= oldIndex; j++) {
                map.remove(s.charAt(j));
            }
            leftBound = oldIndex + 1;
            map.put(s.charAt(i),i);
        }
    }
    return Math.max(result, map.size());
}
