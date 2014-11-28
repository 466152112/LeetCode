// one pass
// use hashmap, string ID~
public ArrayList<String> anagrams(String[] strs) {
    ArrayList<String> result = new ArrayList<String>();
    if (strs == null || strs.length < 2)
        return result;
    HashMap<String, Boolean> map = new HashMap<String, Boolean>();  // key is ID, value is anagram or not
    for (String s:strs) {
        String id = getID(s);
        if (map.containsKey(id)){
            result.add(s);
            map.put(id, true);  // is anagram, set to true
        }
        else
            map.put(id, false); // first time meet this string
    }
    // adding the first string of anagram to result
    for (String s:strs) {
        String id = getID(s);
        if (map.get(id)) {
            result.add(s);
            map.put(id, false);
        }
    }
    return result;
}
// get the unique ID using int array representation
private String getID(String s) {
    int[] num = new int[26];
    for (char c:s.toCharArray())
        num[c - 'a']++;
    StringBuilder result = new StringBuilder();
    for(int i:num)
        result.append(Integer.toString(i) + '.');
    return result.toString();
}
