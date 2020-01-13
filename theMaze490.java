class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int h = maze.length, w = maze[0].length, curr = 0, currR = 0, currC = 0, next = 0, nextR = 0, nextC = 0, dirC = 0, dirR = 0;
        int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Integer> q = new LinkedList();
        q.offer(start[0]*w+start[1]);
        maze[start[0]][start[1]] = 2;
        while(!q.isEmpty()){
            curr = q.poll();
            currR = curr/w;
            currC = curr%w;
            
            
            for(int i = 0; i < 4; i++){
                dirC = dirs[i][1];
                dirR = dirs[i][0];
                nextR = currR + dirR;
                nextC = currC + dirC;
                while(nextR>=0 && nextR<h && nextC>=0 && nextC<w && maze[nextR][nextC] != 1){
                    nextR = nextR + dirR;
                    nextC = nextC + dirC;
                }
                nextR = nextR - dirR;
                nextC = nextC - dirC;
                if(maze[nextR][nextC] == 0){
                    maze[nextR][nextC] = 2;
                    if(nextR == destination[0] && nextC == destination[1]){
                        return true;
                    }
                    q.offer(nextR*w+nextC);
                }
            }
        }
        return false;
    }
}
//bfs
