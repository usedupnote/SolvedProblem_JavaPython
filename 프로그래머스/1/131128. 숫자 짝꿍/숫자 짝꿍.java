class Solution {
    public String solution(String X, String Y) {
        int[] cntX = new int[10];
        int[] cntY = new int[10];
        StringBuilder sb = new StringBuilder();
        
        String answer = "";
        
        for(char c : X.toCharArray()) cntX[c - '0']++;
        for(char c : Y.toCharArray()) cntY[c - '0']++;
        
        int cnt;
        for(int i = 9 ; i >= 0 ; i--) {            
            cnt = cntY[i];
            if(cntX[i] < cntY[i]) cnt = cntX[i];
            
            if(i == 0 && sb.length() == 0) {
                if(cnt > 0) return answer = "0";
                else return answer = "-1";
            }
            
            for(int j = 0 ; j < cnt ; j++) {
                sb.append(i + "");
            }
        }
        
        return answer = sb.toString();
    }
}