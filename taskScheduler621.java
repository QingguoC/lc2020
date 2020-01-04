class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for(char c: tasks){
            counts[c-'A']++;
        }
        Arrays.sort(counts);
        int numOfSameMaxSize = 0;
        int i = 25;
        while(i >= 0 && counts[i] == counts[25]){
            numOfSameMaxSize++;
            i--;
        }
        return Math.max(tasks.length, (n+1)*(counts[25]-1) + numOfSameMaxSize);
    }
}
//size is up to most freq. If too many, size is task size
