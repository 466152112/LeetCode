    public int findMin(int[] num) {
        if (num == null || num.length < 1)
            return Integer.MAX_VALUE;
        for (int i = 1; i < num.length; i++) {
        // if the next one if smaller than previous one, then found
            if (num[i] < num[i - 1])
                return num[i];
        }
        // otherwise, return the fisrt one
        return num[0];
    }
