class Solution {
    public int totalFruit(int[] tree) {
        if(tree == null ) return 0;
        if(tree.length < 3) return tree.length;
        int l = 0, r = 1, ll = l, rl = r;
        while(r < tree.length && tree[r] == tree[l]) {
            r++;
            ll++;
        }
        if(r == tree.length) return tree.length;
        int maxAmt = r+1-l;
        rl = r;
        for(int i = r+1; i < tree.length; i++){
            
            if(tree[i] == tree[l] ){
                ll = i;
                continue;
            } 
            if(tree[i] == tree[r] ){
                rl = i;
                continue;
            } 
            maxAmt = Math.max(maxAmt, i-l);
            if(ll < rl){
               l = ll+1;
                ll = rl;
            } else{
                l = rl+1;
            }
            r = i;
            rl = i;
        }
        maxAmt = Math.max(maxAmt, tree.length-l);
        return maxAmt;
    }
}
