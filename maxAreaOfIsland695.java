class Solution {
    int maxArea = 0;
    HashSet<Integer> visited;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 ) return 0;
        visited = new HashSet();
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                maxArea = Math.max(maxArea, dfs(grid, r, c));
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int r, int c){
        if(r<0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0 || visited.contains(r*grid[0].length+c)) return 0;
        visited.add(r*grid[0].length+c);
        return 1 + dfs(grid, r-1, c) + dfs(grid, r+1, c) + dfs(grid, r, c-1) + dfs(grid, r, c+1);
    }
}

//dfs
