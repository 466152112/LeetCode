// HashMap store slope and count
public int maxPoints(Point[] points) {
    if (points == null || points.length == 0)
        return 0;
    int max = 1;
    for (int i = 0; i < points.length - 1; i++) {
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();  // key: slope, value: number of points in the line
        int duplicates = 0; // duplicates points
        for (int j = i + 1; j < points.length; j++) {
            // duplicates, add one
            if (points[i].x == points[j].x && points[i].y == points[j].y) {
                duplicates++;
                continue;
            }
            double slope = getSlope(points[i], points[j]);
            if (!map.containsKey(slope))
                map.put(slope, 2);  // default value 2
            else
                map.put(slope, map.get(slope) + 1);
        }
        // map may be empty
        max = Math.max(1 + duplicates, max);
        for (int value:map.values())
            max = Math.max(value + duplicates, max);
    }
    return max;
}

private double getSlope(Point a, Point b) {
    // vertical, slope infinity
    if (a.x == b.x)
        return Double.MAX_VALUE;
    // horizontal, slope 0
    if (a.y == b.y)
        return 0.0;
    // 0/-1 and 0/1 is different
    return (double)(a.y - b.y)/(a.x - b.x);
}
