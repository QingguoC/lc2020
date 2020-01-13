class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, target = n * n;
        Queue<Integer> q = new LinkedList(), newQ;
        q.offer(1);
        HashSet<Integer> visited = new HashSet();
        int step = -1;
        while (!q.isEmpty()) {
            newQ = new LinkedList();
            step++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int num = q.poll();
                if (visited.contains(num)) continue;
                visited.add(num);
                if (num == n * n) return step;
                for (int j = 1; j <= 6 && num +j <= target; j++) {
                    int next = num + j;
                    int value = getBoardValue(board, next, n);
                    if (value > 0) next = value;
                    if (!visited.contains(next)) newQ.offer(next);
                }
            }
            q = newQ;
        }
        return -1;
    }
    
    private int getBoardValue(int[][] board, int x, int n){
        int r = n-(x-1)/n-1;
        int c =  (x-1)/n % 2 == 0 ? (x-1)%n : n-((x-1)%n)-1;
        return board[r][c];
    }
    
}
//bfs for num not location
