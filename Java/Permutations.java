public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num.length < 1)
            return null;
        else if (num.length == 1){
            // ArrayList<Integer>(int c), c is the capacity
            ArrayList<Integer> one = new ArrayList<Integer>();
            one.add(num[0]);
            result.add(one);
        }
        else {
            ArrayList<ArrayList<Integer>> previous = permute(Arrays.copyOfRange(num,0,num.length -1));
            for (ArrayList<Integer> now:previous) {
                for (int i = 0; i < num.length; i++) {
                    now.add(i,num[num.length -1]);
                    // add, is just add the reference to the list, if we remove later, it will effect the result
                    result.add(new ArrayList<Integer>(now));
                    now.remove(i);
                }
            }
        }
        return result;
    }
