class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for (int i=1 ; i<=(yellow/2)+1 ; i++) {
            if (yellow % i != 0) continue;
            if (brown == (i + (yellow/i) + 2)*2){
                answer = new int[]{(yellow/i)+2, i+2};
                break;
            }
        }
        return answer;
    }
}