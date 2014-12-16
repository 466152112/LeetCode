public int compareVersion(String version1, String version2) {
    String[] list1 = version1.split("\\.");
    String[] list2 = version2.split("\\.");
    int i = 0;
    while ( i < list1.length && i < list2.length) {
        int a = Integer.valueOf(list1[i]);
        int b = Integer.valueOf(list2[i]);
        if (a < b)
            return -1;
        else if (a > b)
            return 1;
        else
            i++;
    }
    // All list1[i] == list2[i], then i reach the end of list1 or list2
    if (list1.length == list2.length)
        return 0;
    // list2 is longer, check whether the remaining is zeros
    while (i < list2.length) {
        int b = Integer.valueOf(list2[i++]);
        if (b != 0)
            return -1;
    }
    while (i < list1.length) {
        int a = Integer.valueOf(list1[i++]);
        if (a != 0)
            return 1;
    }
    return 0;        
}
