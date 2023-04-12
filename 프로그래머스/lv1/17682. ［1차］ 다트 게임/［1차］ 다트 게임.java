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

    // 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
    // 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
    // 옵션으로 스타상(*) , 아차상(#)이 존재하며 로 만든다. 된다.
    // 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
    // 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
    // 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
    // Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
    // 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
    // 0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

    }
}