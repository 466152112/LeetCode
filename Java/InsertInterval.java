// TO DO LIST tommorw, optimize for this problem, finish the other 7, start summary for the wanderful LeetCode journey
//It is not difficult to figure out an algorithm to solve the problem. But to give a bug-free code and sufficiently test all edge cases make it not a easy game.
// most concise traverse
public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<Interval>();
    int insertPos = 0;
    for (Interval one:intervals) {
        if (one.end < newInterval.start) {
            result.add(one);
            insertPos++;
        }
        else if (one.start > newInterval.end) {
            result.add(one);
        }
        else {
            newInterval.start = Math.min(newInterval.start, one.start);
            newInterval.end = Math.max(newInterval.end, one.end);
        }
            
    }
    result.add(insertPos, newInterval);
    return result;
}

// Naive thought: find the location first, check front and back for merging
public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<Interval>();
    int position = 0;
    // get to the insertion position, where newI is just less than that value
    while (position < intervals.size() && newInterval.start > intervals.get(position).start)
        position++;
    // add the safe fronts
    for (int i = 0; i < position - 1; i++)
        result.add(intervals.get(i));
    // merge the just right front if needed
    int start = newInterval.start;
    int end = newInterval.end;
    if (position > 0) {
        if (intervals.get(position - 1).end >= start)
            start = intervals.get(position - 1).start;
        else
            result.add(intervals.get(position - 1));
    }
    // find the end
    while (position < intervals.size() && end >= intervals.get(position).start)
        position++;
    if (position > 0)
        end = Math.max(intervals.get(position - 1).end, end);
    result.add(new Interval(start, end));
    while (position < intervals.size())
        result.add(intervals.get(position++));        
    return result;
}

// one pass, keep updating the newe interval
public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    ArrayList<Interval> result = new ArrayList<Interval>();
    int position = 0;
    // add safe front
    while (position < intervals.size() && intervals.get(position).end < newInterval.start)
        result.add(intervals.get(position++));
    // update the smaller start
    if (position < intervals.size())
        newInterval.start = Math.min(intervals.get(position).start, newInterval.start);
    // integrate all the intervals inside
    while (position < intervals.size() && intervals.get(position).start <= newInterval.end)
        position++;
    // update the larger end
    if (position > 0)
        newInterval.end = Math.max(intervals.get(position - 1).end, newInterval.end);
    // add new interval
    result.add(newInterval);
    // add the rest
    while (position < intervals.size())
        result.add(intervals.get(position++));
    return result;
}
