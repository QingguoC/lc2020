class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
        int w = matrix[0].length, h = matrix.length;
        int[][] offset = {{0,1},{1,0},{0,-1},{-1,0}};
        int d = 0;
        //int currR = 0, currC = 0;
        int currR = 0, currC = -1;
        int destSize = w * h;
        int i = 0, tmp = 0;
        h--;
        while(i < destSize){
            for(int j = 0; j < w; j++){
                currR += offset[d][0];
                currC += offset[d][1];
                res.add(matrix[currR][currC]);
                i++;
            }
            
            w--;
            tmp = w;
            w = h;
            h = tmp;
            d = (d+1) % 4;
        }
        return res;
    }
}

//offset 2d and direction as index, swap w h, and update d
