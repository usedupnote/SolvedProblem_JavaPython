class Solution {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();
        
        StringBuilder sb = new StringBuilder();
        int lenS = str1.length();
        
        for(int i = 0 ; i < lenS ; i++){
            sb.append(c1[i]).append(c2[i]);
        }
        return answer = sb.toString();
    }
}