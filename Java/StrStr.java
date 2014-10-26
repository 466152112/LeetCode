// compare char by char, if different, begin from the start of needle, no KMP
public String strStr(String haystack, String needle) {
  int i = 0, count = 0;
  while (i + count < haystack.length() && count < needle.length()) {
      if (haystack.charAt(i + count) == needle.charAt(count)) {
          count++;
      }
      else {
          count = 0;
          i++;
      }
  }
  if (count == needle.length())
      return haystack.substring(i);
  else
      return null;
}
