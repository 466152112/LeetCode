// one pass, without using String.split()
public String reverseWords(String s) {
    StringBuilder result = new StringBuilder();
    if (s == null || s.length() == 0)
        return result.toString();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
        // skip space
        if (chars[i] == ' ')
            continue;
        // build one word
        StringBuilder one = new StringBuilder();            
        while (i < chars.length && chars[i] != ' ') {
            one.append(chars[i]);
            i++;
        }
        // add space after this word
        one.append(' ');
        // insert to the head of the result
        result.insert(0, one.toString());
    }
    // if result is not empty, remove the last space
    if (result.length() > 0)
        result.deleteCharAt(result.length() - 1);
    return result.toString();
}
