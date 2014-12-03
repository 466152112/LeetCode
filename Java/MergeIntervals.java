// use Collections sort for help, temp Interval to store the current min start and max end
public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    ArrayList<Interval> result = new ArrayList<Interval>();
    if (intervals == null || intervals.size() <= 1)
        return intervals;
    Collections.sort(intervals, new IntervalComparator());
    Interval temp = new Interval(intervals.get(0).start, intervals.get(0).end); // the temp interval for merging
    for (Interval current:intervals) {
        // intervaled, update merge
        if (current.start <= temp.end) {
            temp.start = Math.min(current.start, temp.start);
            temp.end = Math.max(current.end, temp.end);
        }
        else {
            // add merge interval
            result.add(new Interval(temp.start, temp.end));
            temp.start = current.start;
            temp.end = current.end;
        }
    }
    result.add(new Interval(temp.start, temp.end)); // very important, OMG, I should be one pass except this one
    return result;
}
// comparator for sorting
private class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}
