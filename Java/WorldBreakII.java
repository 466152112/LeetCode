public ArrayList<String> wordBreak(String s, Set<String> dict) {
    if (s == null || s.length() == 0)
        return null;
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    return helper(s, dict, map);
}

// find the first word appears in the dict, concatenate it with the DP result following
private ArrayList<String> helper(String s, Set<String> dict, HashMap<String, ArrayList<String>> map) {
    // already computed the result for this string 
    if (map.containsKey(s))
        return map.get(s);
    ArrayList<String> result = new ArrayList<String>();
    for (int i = 1; i <= s.length(); i++) {
        if (dict.contains(s.substring(0, i))) {
            // the string the only word in the dictionary
            if (i == s.length()) {
                result.add(s);
            }
            else {
                // concatenate with the other part
                ArrayList<String> otherResult = helper(s.substring(i, s.length()), dict, map);
                for (String ss:otherResult) {
                    result.add(s.substring(0,i) + " " + ss);
                }
            }
        }
    }
    // update the HashMap
    map.put(s, result);
    return result;
}
