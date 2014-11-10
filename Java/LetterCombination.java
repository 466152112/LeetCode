// DP recursive one pass
// use default constructor to build the HashMap
// append current character with former String lists
public class Solution {
    HashMap<Character, String> dict;
    public Solution() {
        dict = new HashMap<Character, String>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
    }
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            result.add("");
            return result;
        }
        ArrayList<String> temp = letterCombinations(digits.substring(1, digits.length()));
        char[] currentDigit = dict.get(digits.charAt(0)).toCharArray();
        for (char c:currentDigit) {
            for (String s:temp) {
                result.add(c + s);
            }
        }
        return result;
    }
}
