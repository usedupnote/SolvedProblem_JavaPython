class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        char[] ch = dartResult.toCharArray();
        char[] checker = {'S', 'D', 'T'};
        int[] score = new int[4];   // 다트 게임은 총 3번의 기회
        
        int pos = 1;
        for(char c : ch){
            if(0<= c-'0' && c-'0'<10) {
                score[pos] = (score[pos]*10) + (c-'0'); // 얻을 수 있는 점수는 0점에서 10점 (10점일 경우 2자리이므로 앞에 들어왔던 숫자를 *10 해줌으로써 표현
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
                if(checker[i] == c){    //[Single(S) = 1제곱, Double(D) = 2제곱, Triple(T) = 3제곱]으로 계산
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
