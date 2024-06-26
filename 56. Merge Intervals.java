class Solution {
    public int[][] merge(int[][] intervals) {
        // save interval as current
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        // at this interval, 
        // if interval[i][0] > curr[1], add curr and make this interval curr
        // otherwise, our interval fits with curr, make curr[0] the min of both, and curr[1] the max of both
        
        // add curr to intervals


        List<int[]> list = new ArrayList<>();
        int[] curr = intervals[0];

        for(int i=1;i<intervals.length;i++){
            int[] arr = intervals[i];
            if(arr[0] > curr[1] || arr[1] < curr[0]){
                list.add(curr);
                curr = arr;
            }else{
                // curr[0] = Math.min(curr[0],arr[0]);
                curr[1] = Math.max(curr[1], arr[1]);
            }
        }

        list.add(curr);

        return list.toArray(new int[list.size()][]);
    }
}