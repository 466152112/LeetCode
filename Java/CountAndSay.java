public String countAndSay(int n) {
    String output = "1";
    for (int i = 1; i < n; i++) {
        output = helper(output);
    }
    return output;
}
private String helper(String input) {
    int len = input.length();
    StringBuilder output = new StringBuilder();
    for (int i = 0, j = 0; i < len;) {
        while (input.charAt(i) == input.charAt(j)) {
            j++;
            if (j == len)
                break;
        }
        output.append(j-i);
        output.append(input.charAt(i));
        i = j;
    }
    return output.toString();
}

// use toCharArray, access char using index, not charAt()
// curse move and count++, not count to the end and minus
public String countAndSayLoop(int n) {
    String oldString = "1";
    while (--n > 0) {
        StringBuilder sb = new StringBuilder();
        char [] oldChars = oldString.toCharArray();

        for (int i = 0; i < oldChars.length; i++) {
            int count = 1;
            while ((i+1) < oldChars.length && oldChars[i] == oldChars[i+1]) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
        }
        oldString = sb.toString();
    }

    return oldString;
}
