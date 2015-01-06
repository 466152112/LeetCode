    // DP, right-bottem up, T[i][j] = (min(T[i+1][j], T[i][j+1]) - D[i][j]) or (1)
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] minHealth = new int[m + 1][n + 1]; // store the min health value required to pass this point
        for (int[] a:minHealth)
        	Arrays.fill(a, Integer.MAX_VALUE); // bottem and right bound as the wall
        minHealth[m - 1][n] = 1; // initial value for the destination
        minHealth[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int nextMinHealth = Math.min(minHealth[i + 1][j], minHealth[i][j + 1]);
                // bring addition value, or just come here alive, i can do it alone
                minHealth[i][j] = nextMinHealth > dungeon[i][j] ? nextMinHealth - dungeon[i][j] : 1;
            }
        }
        return minHealth[0][0];
    }
