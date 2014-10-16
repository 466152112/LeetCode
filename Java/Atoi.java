public class Atoi {
	// First determin '-' or '+'
	// charactor with in '0' and '9'
	// overflow: larger within 10, become negative
	//				larger 10 times, compare before time 10
	// use long type, so that it's much easier to compare with MAX_VALUE
	public int atoi(String str) {
            str = str.trim();
            if (str.length() == 0)
                return 0;
            long result = 0;
	        int neg = 1;
	        if (str.charAt(0) == '-') {
	            neg = -1;
	            if (str.length() == 1)
	                return 0;
	            else
	                str = str.substring(1);
	        }
	        else if (str.charAt(0) == '+') {
	            neg = 1;
	            if (str.length() == 1)
	                return 0;
	            else
	                str = str.substring(1);
	        }
	        int len = str.length();
	        for (int i=0; i<len; i++) {
	            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	                 result = result*10 + str.charAt(i) - '0';
	                 if (result > Integer.MAX_VALUE) {
	                     if (neg == 1)
	                        return Integer.MAX_VALUE;
	                     else
	                        return Integer.MIN_VALUE;
	                 }
	            }
	            else {
	                return (int)result*neg;
	            }
	        }
	        return (int)result*neg;
    }
    
	public int atoi_without_long(String str) {
            str = str.trim();
            if (str.length() == 0)
                return 0;
            int result = 0;
	        int neg = 1;
	        if (str.charAt(0) == '-') {
	            neg = -1;
	            if (str.length() == 1)
	                return 0;
	            else
	                str = str.substring(1);
	        }
	        else if (str.charAt(0) == '+') {
	            neg = 1;
	            if (str.length() == 1)
	                return 0;
	            else
	                str = str.substring(1);
	        }
	        int len = str.length();
	        for (int i=0; i<len; i++) {
	            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
	                if (result > Integer.MAX_VALUE/10) {
	                     if (neg == 1)
	                        return Integer.MAX_VALUE;
	                     else
	                        return Integer.MIN_VALUE;
	                 }
	                 result = result*10 + str.charAt(i) - '0';
	                 if (result < 0) {
	                     if (neg == 1)
	                        return Integer.MAX_VALUE;
	                     else
	                        return Integer.MIN_VALUE;
	                 }
	            }
	            else {
	                return result*neg;
	            }
	        }
	        return result*neg;
    }
}
