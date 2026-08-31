class Solution {
    static int[] diff = {0,1,0,-1,0};
    private int bfs(int[][] grid, int row, int col, int R, int C){
        grid[row][col] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col});
        int area = 1;
        while(!queue.isEmpty()){
            int[] val = queue.poll();
            int currentrow = val[0] , currentcol = val[1];
            for(int di = 0 ; di < 4 ; di++){
                int adjR = currentrow + diff[di], adjC = currentcol + diff[di+1];
                if(adjR>=0 && adjR<R && adjC>=0 && adjC<C && grid[adjR][adjC] == 1){
                    grid[adjR][adjC] = 0;
                    queue.add(new int[]{adjR,adjC});
                    area++;
                }
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int currarea = 0, maxarea = 0;
        for(int row = 0 ; row < R ; row++){
            for(int col = 0 ; col < C ; col++){
                if(grid[row][col] == 1){
                    currarea = bfs(grid,row,col,R,C);
                    maxarea = Math.max(maxarea,currarea);
                }
            }
        }
        return maxarea;
    }
}