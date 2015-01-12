// It's actually a sorting problem, or Override a comparator problem

public String largestNumber(int[] num) {
    if (num == null || num.length == 0)
        return "";
    String[] str = new String[num.length];
    for (int i = 0; i < num.length; i++)
        str[i] = Integer.toString(num[i]);
    Arrays.sort(str, new Comparator<String>(){
        @Override
        public int compare(String s1, String s2) {
            // s2 + s1, because we want to sort in DESC order
            return Long.valueOf(s2+s1).compareTo(Long.valueOf(s1+s2));
            // Long.compare(long l1, long l2)
            // Long_OBJ1.compareTo(Long_OBJ2);
        }
    });
    if (str[0].equals("0"))
        return "0";
    StringBuilder sb = new StringBuilder(str);
    for (String s:str)
        sb.append(s);
    return sb.toString();
}
