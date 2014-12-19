// hint: hashmap or hashset, two point
// 2, hashmap, do not remove the former keys, use their value to compare
public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() < 1)
        return 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    char[] c = s.toCharArray();
    int max = 0; // the max length
    int start = 0; // start point of the substring
    for (int i = 0; i < c.length; i++) {
        if (map.containsKey(c[i]) && map.get(c[i]) >= start) {
            max = Math.max(max, i - start);
            start = map.get(c[i]) + 1;
        }
        map.put(c[i], i);
    }
    return Math.max(max, c.length - start);
}
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

// 2, hashset, use charAt == charAt(i) instead the oldIndex
public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0)
        return 0;
    int result = 0;
    int leftBound = 0;
    HashSet<Character> set = new HashSet<Character> ();
    for (int i = 0; i < s.length(); i++) {
        if (!set.contains(s.charAt(i))) {
            set.add(s.charAt(i));
        }
        else {
            result = Math.max(result, set.size());
            while (s.charAt(leftBound) != s.charAt(i))
                set.remove(s.charAt(leftBound++));
            leftBound++;
        }
    }
    return Math.max(result, set.size());
}
