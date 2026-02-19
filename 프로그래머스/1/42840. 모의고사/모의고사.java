import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1,2,3,4,5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3,3,1,1,2,2,4,4,5,5};
        
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
    
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == p1[i % p1.length]){
                count1++;
            }
            if(answers[i] == p2[i % p2.length]){
                count2++;
            }
            if(answers[i] == p3[i % p3.length]){
                count3++;
            } 
        }
        
        int max = Math.max(count1, count2);
        max = Math.max(max, count3);
        
        ArrayList<Integer>list = new ArrayList<>();
        if(max == count1) list.add(1);
        if(max == count2) list.add(2);
        if(max == count3) list.add(3);
        
        int[] result = new int[list.size()];
        
        for(int i = 0; i<list.size();i++){
            result[i] = list.get(i);
        }
        
        return result;
        
    }
}