// ask the interviewers for specifics about the number format
public boolean isNumber(String s) {
    s = s.trim();
    boolean result = false;
    boolean flagEDot = true;
    char[] c = s.toCharArray();
    int len = c.length, index = 0;
    if (len == 0)
        return false;
    if (len == 1 && (c[0] < '0' || c[0] > '9'))
        return false;
    if (c[0] == '-' || c[0] == '+')
        index++;
    if (c[index] == 'e')
        return false;
    for(; index < len; index++) {
        if (flagEDot && c[index] == '.') {
            flagEDot = false;
            if (index + 1 < len && c[index + 1] == 'e')
                flagEDot = true;
            }
        else if (flagEDot && c[index] == 'e') {
            flagEDot = false;
            if (index + 1 == len)
                return false;
        }
        else if (c[index] < '0' || c[index] > '9')
            return false;
        else
            result = true;
    }
    return result;
}
