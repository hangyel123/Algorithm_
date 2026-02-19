class Solution {
    
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int maxWidth = 0;
        int maxHeight = 0;
        
        for(int i =0; i < sizes.length;i++){
            int bigger = 0;
            int smaller = 0;
            
            bigger = Math.max(sizes[i][0], sizes[i][1]);
            smaller = Math.min(sizes[i][0], sizes[i][1]);
        
            maxWidth = Math.max(maxWidth, bigger);
            maxHeight = Math.max(maxHeight, smaller);
        }
        
        answer = maxWidth * maxHeight;
        return answer;
    }
}