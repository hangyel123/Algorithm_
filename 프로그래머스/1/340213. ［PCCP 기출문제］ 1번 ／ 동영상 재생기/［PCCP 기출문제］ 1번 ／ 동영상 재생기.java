class Solution {
    
    int toSec(String time){
        String[] parts = time.split(":");
        int min = Integer.parseInt(parts[0]);
        int sec = Integer.parseInt(parts[1]);
        
        return min * 60 + sec;
    }
    
    String toMin(int time){
        int min = time / 60;
        int sec = time % 60;
        
        return String.format("%02d:%02d",min, sec);
    }
    
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = toSec(video_len);
        int current = toSec(pos);
        int opStart = toSec(op_start);
        int opEnd = toSec(op_end);
        
        
        if(current >= opStart && current <= opEnd) current = opEnd;
        
        for(String command : commands){
            if(command.equals("prev")){
                current -= 10;
                if(current <= 0) current = 0;
                if(current >= opStart && current <= opEnd) current = opEnd;
            }
            if(command.equals("next")){
                current+= 10;
                if(current > videoLen) current = videoLen;
                
                if(current >= opStart && current <= opEnd) current = opEnd;
            }
            
            
        }
        return toMin(current);
    }
}