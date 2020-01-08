class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) return true;
        int[] indegree = new int[numCourses];
        HashMap<Integer, List<Integer>> adj = new HashMap();
        int pre = 0, nex = 0;
        for(int i = 0; i < prerequisites.length; i++){
            pre = prerequisites[i][1];
            nex = prerequisites[i][0];
            if(!adj.containsKey(pre)){
                adj.put(pre,new ArrayList());
            }
            adj.get(pre).add(nex);
            indegree[nex]++;
        }
        Queue<Integer> q = new LinkedList();
        int finished = 0;
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            finished++;
            if(adj.containsKey(curr)){
            for(int j : adj.get(curr)){
                indegree[j]--;
                if(indegree[j] == 0){
                    q.add(j);
                }
            }
            }
            
        }
        return finished == numCourses;
    }
}
//bfs queue to add indegree 0 and count finished
