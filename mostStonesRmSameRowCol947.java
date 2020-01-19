class Solution {
    public int removeStones(int[][] stones) {
        if(stones == null || stones.length == 0 || stones[0].length == 0) return 0;
        HashSet<int[]> set = new HashSet();
        int numOfIslands = 0;
        for(int[] stone: stones){
            if(!set.contains(stone)){
                numOfIslands++;
                set.add(stone);
                dfs(stones, set, stone);
            }
        }
        return stones.length - numOfIslands;
    }
    private void dfs(int[][] stones, HashSet<int[]> set, int[] stone){
        for(int[] s2: stones){
            if(!set.contains(s2)){
                if(s2[0] == stone[0] || s2[1] == stone[1]){
                    set.add(s2);
                    dfs(stones, set, s2);
                }
            }
        }
    }
}

