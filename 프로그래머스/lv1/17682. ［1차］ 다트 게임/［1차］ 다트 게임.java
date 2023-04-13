class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        char[] ch = dartResult.toCharArray();
        char[] checker = {'S', 'D', 'T'};
        int[] score = new int[4];   // 다트 게임은 총 3번의 기회
        
        int pos = 1;
        for(char c : ch){
            if(0<= c-'0' && c-'0'<10) {
                score[pos] = (score[pos]*10) + (c-'0');
                continue;
            }
            else if(c == '*') {
                //스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배
                score[pos-2] *= 2;
                score[pos-1] *= 2;
                continue;
            }
            else if(c == '#'){
                //아차상(#) 당첨 시 해당 점수는 마이너스
                score[pos-1] *= -1;
                continue;
            }
            for(int i = 0 ; i < 3 ; i++){
                if(checker[i] == c){
                    score[pos] = (int)Math.pow(score[pos],i+1);
                    pos++;
                    break;
                }
            }
        }
        
        for (int i : score){
            answer += i;
        }
        
        // 3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력
        return answer;  
    }
}