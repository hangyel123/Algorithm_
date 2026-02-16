import java.util.*;
import java.io.*;

class Solution {
    
    
    boolean checkWord(String begin, String target){    
            int diff = 0;
        
            for(int index = 0; index < begin.length(); index++){
                if(begin.charAt(index)!= target.charAt(index) ){
                    diff++;
                }
                if(diff >= 2) return false;
            }
            if(diff == 1){
                return true;  
            }
            else return false;
    }
    
    
    public int solution(String begin, String target, String[] words) {
       
        boolean exists = false;
        for(String word : words){
            if(word.equals(target)){
                exists = true;
                break;
            }
        }
        if(!exists) return 0;
        
        
       boolean[] visited = new boolean[words.length];
       ArrayDeque<Object[]> q = new ArrayDeque<>();
      q.offer(new Object[]{begin, 0});
        
        while(!q.isEmpty()){
            Object[] cur = q.poll();
            String current = (String) cur[0];
            int depth = (int) cur[1];
            
            if(current.equals(target)){
                return depth;
            }
            for(int i=0;i<words.length;i++){
                if(!visited[i] && checkWord(current, words[i])){
                    visited[i]= true;
                    q.offer(new Object[]{words[i], depth+1});
                }
            }
        }
         return 0;
    }

}


