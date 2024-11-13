import java.io.*;
import java.util.*;

class Solution {
	private static int MinToSec(String timeString) {
		String[] len_sep = timeString.split(":");
		int second = 60 * Integer.parseInt(len_sep[0]) + Integer.parseInt(len_sep[1]);
		
		return second;
	}
	
	private static String SecToMin(int timeSec) {
		int min = timeSec/60;
		int sec = timeSec%60;
		String timeString = (min>10?"":"0")+Integer.toString(min) + ":" + (sec>10?"":"0") + Integer.toString(sec);
		return timeString;
	}
		
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int video_len_sec = MinToSec(video_len);
        int pos_sec = MinToSec(pos);
        int op_start_sec = MinToSec(op_start);
        int op_end_sec = MinToSec(op_end);

    	if (op_start_sec <= pos_sec && pos_sec <= op_end_sec) {
			pos_sec = op_end_sec;
		}
        
        for (String command : commands) {
        	if (command.equals("prev")) {
				pos_sec -= 10;
				pos_sec = Math.max(pos_sec, 0);
			} else if (command.equals("next")) {
				pos_sec += 10;				
				pos_sec = Math.min(pos_sec, video_len_sec);
			} else {
				System.out.println("error (" + command + " is not set value)");
				break;
			}
        	
        	if (op_start_sec <= pos_sec && pos_sec <= op_end_sec) {
				pos_sec = op_end_sec;
			}
		}
        
        return SecToMin(pos_sec);
    }
}