class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        for(int i = 0; i < n; i++){
            if(colors[i] != 0 ){
                continue;
            }
            Queue<Integer> q = new LinkedList();
            q.offer(i);
            colors[i] = 1;
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int j: graph[curr]){
                    if(colors[j] == 0){
                        colors[j] = -colors[curr];
                        q.offer(j);
                    }else if(colors[j] == colors[curr]){
                        return false;
                    }
                }
            }
            
            
        }
        return true;
        
        
    }
}
//loop node and coloring using bfs

