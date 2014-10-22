// convert vertically
public String convert(String s, int nRows) {
    int len = s.length();
    if (s == null || s == "" || nRows <= 1 || nRows >= len)
        return s;
    char[] result = new char[len];
    int[] offset = new int[nRows];
    int size = nRows+nRows-2;
    int mod = len/size;
    int rem = (size + len)%size;
    for (int i = 0; i < nRows; i++) {
        offset[i] = (i>0?offset[i-1]:0) + ((i>0 && i<(nRows-1))?2*mod:mod) + ((rem--)>0?1:0);
    }
    for (int i = 1; rem > 0; rem--,i++) {
    	for (int j = 0; j<=i; j++) {
    	offset[nRows-j-1]++;
    	}
    }
    int count = -1;
    for (int i = 0, j = 0; i < len; i++, j++) {
        j = j % size;
        if (j == 0) {
            count++;
            result[count] = s.charAt(i);                
        }
        else if (j < nRows -1) {
            result[offset[j-1] + 2*count] = s.charAt(i);
        }
        else if (j == nRows -1) {
            result[offset[j-1] + count] = s.charAt(i);
        }
        else {
            result[offset[2*nRows -j - 3] + 2*count + 1] = s.charAt(i);
        }
    }
    return String.valueOf(result);
}

// convert horizontally
public String convert(String s, int nRows) {
    
}
