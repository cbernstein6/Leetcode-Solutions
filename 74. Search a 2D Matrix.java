class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search
        // if targ is in range for this, check binary in this
        // if targ > matrix[i][0] left = mid+1
        // else right = mid-1

        // define left and right
        // while left < right
        // define mid
        // if target > matrix[mid][0], and < matrix[mid][matrix[mid].length-1], binary search through mat[mid]
        
        // if targ > matrix[i][0] left = mid+1
        // else right = mid-1

        if(matrix.length == 1) 
            return bin(matrix[0],target);

        int left=0, right = matrix.length-1;

        while(left <= right){
            int mid = (left+right)/2;
            int[] arr = matrix[mid];

            if(target >= arr[0] && target <= arr[arr.length-1]){
                return bin(arr,target);
            }

            if(target > arr[0]) left = mid+1;
            else right = mid-1;
        }
        return false;
    }

    public boolean bin(int[] arr, int targ){
        int left=0,right = arr.length-1;

        while(left <= right){
            int mid = (left+right)/2;
            // System.out.println(arr[mid]+"  "+arr.length);

            if(arr[mid] == targ) return true;

            if(arr[mid] < targ) left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}