class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0, h = grid.length, w = grid[0].length;
        int currC=0, currR=0;
        for(int r = 0; r < h; r++){
            for(int c = 0; c < w; c++){
                if(grid[r][c] == '1'){
                    res++;
                    Queue<Integer> q = new LinkedList();
                    q.offer(r*w+c);
                    grid[r][c] = '0';
                    while(q.size() != 0){
                        //Queue<int[]> newQ = new LinkedList();
                        int curr = q.poll();
                            currR = curr/w;
                            currC = curr%w;
                        //grid[currR][currC] = '0';
                        if(currC-1 >= 0  && grid[currR][currC-1] == '1') {q.offer(curr-1); 
                        grid[currR][currC-1] = '0';                                                 }
                        if(currC+1 < w && grid[currR][currC+1] == '1'){q.offer(curr+1);
                 grid[currR][currC+1] = '0' ;                                                    }
                        if(currR-1 >= 0  && grid[currR-1][currC] == '1') {q.offer((currR-1)*w+ currC);
                grid[currR-1][currC] = '0';                                                         }
                        if(currR+1 < h && grid[currR+1][currC] == '1') {q.offer((currR+1)*w+ currC);
                 grid[currR+1][currC] = '0';                                                      }
                        
                         
                        
                        
                    }
                }
            }
        }
        return res;
    }
    
}

//bfs needs change value first
