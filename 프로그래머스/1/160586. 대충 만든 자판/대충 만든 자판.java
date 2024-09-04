import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        int[] keyCount = new int[26];
        Arrays.fill(keyCount, Integer.MAX_VALUE);
        
        for(String key : keymap){
            char[] keySeps = key.toCharArray();
            
            for(int i = 0 ; i < keySeps.length ; i++) {
                if(keyCount[keySeps[i] - 'A'] > i) {
                    keyCount[keySeps[i] - 'A'] = i;
                }
            }
        }
        
        for(int i = 0 ; i < targets.length ; i++) {
            int cnt = 0;
            
            char[] target = targets[i].toCharArray();
            
            for(char targetChar : target) {
                int keyCnt = keyCount[targetChar - 'A'];
                
                if(keyCnt == Integer.MAX_VALUE) {
                    cnt = -1;
                    break;
                }
                cnt += keyCnt + 1;
            }
            answer[i] = cnt;
        }
        
        return answer;
    }
}