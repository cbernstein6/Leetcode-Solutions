class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        

        // list of int[] called list
        // for(int[] arr : intervals),
        // if(newInt[1] < arr[0]) add newint to list, add range from i to end to list, return
        // else if newInt[0] > intervals[i][1], add interval to list and continue,
        // else, we can make first val the min of both, and the second the max of both

        if(intervals.length == 0) return new int[][]{newInterval};

        List<int[]> list = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int[] arr = intervals[i];
            if(newInterval[1] < arr[0]){
                list.add(newInterval);
                for(int j=i;j<intervals.length;j++){
                    list.add(intervals[j]);
                }
                return result(list);
            }
            if(newInterval[0] > arr[1]) list.add(arr);
            else{
                newInterval[0] = Math.min(newInterval[0],arr[0]);
                newInterval[1] = Math.max(newInterval[1],arr[1]);
            }
        }
        list.add(newInterval);
        return result(list);

        
    }
    public int[][] result(List<int[]> list){
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}