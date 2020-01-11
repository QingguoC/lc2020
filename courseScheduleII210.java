class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <= 0) return new int[0];
        int[] res = new int[numCourses];
        HashMap<Integer, List<Integer>> adjs = new HashMap();
        int[] indegree = new int[numCourses];
        int finished = 0, preC = 0, nexC = 0;
        if(prerequisites != null && prerequisites.length > 0){
            for(int i = 0; i < prerequisites.length; i++){
                preC = prerequisites[i][1];
                nexC = prerequisites[i][0];
                indegree[nexC]++;
                if(!adjs.containsKey(preC)){
                    adjs.put(preC, new ArrayList());
                }
                adjs.get(preC).add(nexC);
            }
        }
        
        Queue<Integer> q = new LinkedList();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        if(q.isEmpty()){
            return new int[0];
        }
        while(!q.isEmpty()){
            preC = q.poll();
            res[finished] = preC;
            finished++;
            if(adjs.containsKey(preC)){
            for(int j: adjs.get(preC)){
                indegree[j]--;
                if(indegree[j] == 0){
                    q.offer(j);
                }
            }
            }
        }
        if(finished == numCourses) return res;
        return new int[0];
    }
}
//bfs pay attention the format of result
