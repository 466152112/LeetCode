// switch different case, add "1" in the resulted string if necessary
public String addBinary(String a, String b) {
    char[] large = (a.length() > b.length()?a:b).toCharArray();
    char[] small = (a.length() <= b.length()?a:b).toCharArray();
    char[] result = new char[large.length];
    int carry = 0, temp = 0;
    int i = small.length -1, j = large.length -1;
    for (; i >= 0; i--,j--) {
        temp = (int)(large[j] - '0') + (int)(small[i] - '0') + carry;
        switch(temp) {
            case 0:
                result[j] = '0';
                break;
            case 1:
                result[j] = '1';
                carry = 0;
                break;
            case 2:
                result[j] = '0';
                carry = 1;
                break;
            case 3:
                result[j] = '1';
                carry = 1;
                break;
        }
    }
    for (; j >=0; j--) {
        temp = (int)(large[j] - '0') + carry;
        switch(temp) {
            case 0:
                result[j] = '0';
                break;
            case 1:
                result[j] = '1';
                carry = 0;
                break;
            case 2:
                result[j] = '0';
                carry = 1;
                break;
            case 3:
                result[j] = '1';
                carry = 1;
                break;
        }            
    }
    String str = String.valueOf(result);        
    if (carry == 1) {
        str = "1" + str;
    }
    return str;
}
