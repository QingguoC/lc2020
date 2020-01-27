class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> n1 = new HashSet();
        List<Integer> common = new ArrayList();
        for(int i: nums1){
            n1.add(i);
        }
        for(int i: nums2){
            if(n1.contains(i)){
                common.add(i);
                n1.remove(i);
            }
        }
        int[] res = new int[common.size()];
        for(int i=0; i < res.length; i++){
            res[i] = common.get(i);
        }
        return res;
    }
}



