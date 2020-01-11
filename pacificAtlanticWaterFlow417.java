class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int h = matrix.length, w = matrix[0].length;
        int curr = 0, currR = 0, currC = 0, next = 0, nextR = 0, nextC = 0;
        Queue<Integer> qPac = new LinkedList(), qAtl = new LinkedList();
        int[][] offsets = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        HashSet<Integer> visitPac = new HashSet(), visitAtl = new HashSet();
        for(int i = 0; i < w; i++){
            qPac.offer(i);
            visitPac.add(i);
            qAtl.offer((h-1)*w+i);
            visitAtl.add((h-1)*w+i);
        }
        for(int i = 1; i < h; i++){
            qPac.offer(i*w);
            visitPac.add(i*w);
            qAtl.offer(i*w-1);
            visitAtl.add(i*w-1);
        }
        while(!qPac.isEmpty()){
            curr = qPac.poll();
            currR = curr/w;
            currC = curr%w;
            for(int i = 0; i < 4; i++){
                nextR = currR + offsets[i][0];
                nextC = currC + offsets[i][1];
                next = nextR * w + nextC;
                if(nextR >= 0 && nextR < h && nextC >= 0 && nextC < w && matrix[currR][currC] <= matrix[nextR][nextC] && !visitPac.contains(next)){
                    visitPac.add(next);
                    qPac.offer(next);
                }
            }
        }
        while(!qAtl.isEmpty()){
            curr = qAtl.poll();
            currR = curr/w;
            currC = curr%w;
            for(int i = 0; i < 4; i++){
                nextR = currR + offsets[i][0];
                nextC = currC + offsets[i][1];
                next = nextR * w + nextC;
                if(nextR >= 0 && nextR < h && nextC >= 0 && nextC < w && matrix[currR][currC] <= matrix[nextR][nextC] && !visitAtl.contains(next)){
                    visitAtl.add(next);
                    qAtl.offer(next);
                }
            }
        }
        for(int i: visitPac){
            if(visitAtl.contains(i)){
                res.add(Arrays.asList(i/w, i%w));
            }
        }
        return res;
    }
}

//flow from ocean to land with bfs to high
