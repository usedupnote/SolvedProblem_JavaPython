import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        
        int[] posL = new int[]{3, 0};
        int[] posR = new int[]{3, 2};
        int[] posN = new int[]{0, 0};
        
        for(int number : numbers) {            
            if(number == 0) posN = new int[] {3, 1};
            else            posN = new int[] {(number-1)/3, (number-1)%3};
            
            if(number != 0 && posN[1] == 0) {
                sb.append("L");
                posL = posN.clone();
                continue;
            }
            
            if(posN[1] == 2) {
                sb.append("R");
                posR = posN.clone();
                continue;
            }
            
            int desL = Math.abs(posN[0] - posL[0]) - posL[1] + 1;
            int desR = Math.abs(posN[0] - posR[0]) + posR[1] - 1;
            
            if(desL > desR) {
                posR = posN.clone();
                sb.append("R");
                continue;
            } else if (desL < desR) {
                posL = posN.clone();
                sb.append("L");
                continue;
            }
            
            if (hand.equals("right")) {
                posR = posN.clone();
                sb.append("R");
                continue;
            } else {
                posL = posN.clone();
                sb.append("L");
                continue;
            }
        }
        
        return answer = sb.toString();
    }
}