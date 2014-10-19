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
