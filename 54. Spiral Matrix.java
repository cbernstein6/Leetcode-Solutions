class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // start bounds at startX = 0,startY = 0, endX = mat[0].length-1,endY = mat.length-1
        // while startX <= endX and startY <= endY

        // loop from startX to endX from matrix[startY]
        // loop from starty+1 and endy-1 from matrix[i][endX]
        // loop from endX to startX of matrix[endY]
        // loop from endY-1 to startY+1 of matrix[i][startX]

        // incremennt the starts and decrement the ends

        int startX=0,startY=0,endX=matrix[0].length-1,endY=matrix.length-1;
        List<Integer> list = new ArrayList<>();

        while(startX <= endX && startY <= endY){
            for(int i=startX;i<=endX;i++){
                list.add(matrix[startY][i]);
            }

            for(int i=startY+1;i<=endY-1;i++){
                list.add(matrix[i][endX]);
            }

            if(startY != endY){
                for(int i=endX;i>=startX;i--){
                    list.add(matrix[endY][i]);
                }
            }

            if(startX != endX){
                for(int i=endY-1;i>=startY+1;i--){
                    list.add(matrix[i][startX]);
                }
            }

            startX++;
            startY++;

            endX--;
            endY--;
        }
        return list;
    }
}