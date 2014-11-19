// 1, If car starts at A and can not reach B. Any station between A and B can not reach B.
// 2, If the total number of gas is bigger than the total number of cost. There must be a solution.
public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas == null || cost == null || gas.length != cost.length || gas.length == 0)
        return -1;
    int total = 0;  // total gas remaiin in the tank
    int former = 0; // former owned gas to finish the former trip
    int result = 0; // result index
    for (int i = 0; i < gas.length; i++) {
        total += gas[i] - cost[i];  // updata gas remaining
        if (total < 0) {
            result = i + 1; // no remaining, update index and balance, and former ownings
            former -= total;
            total = 0;
        }
    }
    // whether you can pay former balance or not
    if (total < former)
        return -1;
    return result ;
}

// use total and sum, similar idea
public int canCompleteCircuit(int[] gas, int[] cost) {
    if (gas == null || cost == null || gas.length != cost.length || gas.length == 0)
        return -1;
    int total = 0;  // total gas so far
    int sum = 0; // gas balance in the tank
    int result = 0; // result index
    for (int i = 0; i < gas.length; i++) {
        sum += gas[i] - cost[i];  // updata gas remaining
        total += gas[i] - cost[i];  // updata total gas so far            
        if (sum < 0) {
            result = i + 1; // no remaining, update index and balance
            sum = 0;
        }
    }
    if (total < 0)
        return -1;
    return result ;
}
