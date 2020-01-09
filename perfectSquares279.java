class Solution {
    public int numSquares(int n) {
        if(n < 3) return n;
        int i = 1;
        List<Integer> pool = new ArrayList();
        while(i * i <= n){
            pool.add(i*i);
            i++;
        }
        Queue<Integer> q = new LinkedList(), newQ;
        q.offer(n);
        int res = 0;
        while(!q.isEmpty()){
            newQ = new LinkedList();
            res++;
            for(int j: q){
                for(int m: pool){
                    if(j == m){
                        return res;
                    }
                    if(m > j) break;
                    newQ.offer(j-m);
                }
            }
            q = newQ;
        }
        return res;
    }
}
//bfs to loop pool of candidates
