// compare char value for alpha and numerical
public boolean isPalindrome(String s) {
    if (s.isEmpty())
        return true;
    char[] c = s.toLowerCase().toCharArray();
    int i=0, j=c.length - 1;
    while (i<j) {
        while (c[i] > 'z' || c[i] < '0' || c[i] < 'a' && c[i] > '9') {
            i++;
            if (i == j)
                return true;
        }
        while (c[j] > 'z' || c[j] < '0' || c[j] < 'a' && c[j] > '9') {
            j--;
            if (i == j)
                return true;
        }
        if (c[i] == c[j]){
            i++;
            j--;
        }else
            return false;
    }
    return true;
}
