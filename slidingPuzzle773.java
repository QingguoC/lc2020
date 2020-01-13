class Solution {
    public int slidingPuzzle(int[][] board) {
        State currState = getState(board), target = new State(5,"123450");
        int step = 0;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        if(isTargetState(currState, target)) return step;
        Queue<State> q = new LinkedList();
        HashSet<String> visit = new HashSet();
        q.offer(currState);
        visit.add(currState.state);
        while(!q.isEmpty()){
            int size = q.size();
            step++;
            for(int i = 0; i < size; i++){
                currState = q.poll();
                for(State next: getNextStates(currState, dirs, board[0].length, board.length)){
                    if(isTargetState(next, target)){
                        return step;
                    }
                    if(!visit.contains(next.state)){
                        visit.add(next.state);
                        q.offer(next);
                    }
                }
            }
            
        }
        return -1;
        
    }
    private State getState(int[][] board){
        StringBuilder sb = new StringBuilder();
        int loc = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
                if(board[i][j] == 0){
                    loc = i*board[0].length + j;
                }
            }
        }
        return new State(loc,sb.toString());
    }
    private List<State> getNextStates(State s, int[][] dirs, int w, int h){
        List<State> res = new LinkedList();
        String currS = s.state;
        int currR = s.loc/w;
        int currC = s.loc%w;
        for(int i = 0; i < dirs.length; i++){
            int nextR = currR + dirs[i][0];
            int nextC = currC + dirs[i][1];
            int next = nextR * w + nextC;
            if(nextR >= 0 && nextR < h && nextC >= 0 && nextC < w){
                String nextS = currS.substring(0,s.loc)+currS.charAt(next)+currS.substring(s.loc+1);
                nextS = nextS.substring(0,next)+0+nextS.substring(next+1);
                res.add(new State(next, nextS));
            }
        }
        return res;
    }
    private boolean isTargetState(State s, State target){
        return s.loc == target.loc && s.state.equals(target.state);
    }
}

class State{
    int loc;
    String state;
    public State(int l, String s){
        this.loc = l;
        this.state = s;
    }
}

// use string as state for bfs
