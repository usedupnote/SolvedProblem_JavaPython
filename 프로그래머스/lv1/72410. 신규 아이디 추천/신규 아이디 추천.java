import java.util.*;

class Solution {
    public String solution(String new_id) {
        StringBuilder sb = new StringBuilder();
        String answer = "";
        // 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환
        new_id = new_id.toLowerCase();
        
        // 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거
        char[] ch = new_id.toCharArray();
        char[] resultCh = new char[1001];
        
        int point = 0;
        int chSize = new_id.length();
        
        for(int i = 0; i < chSize ; i++){
            if('a' <= ch[i] && ch[i] <= 'z'){
                resultCh[point++] = ch[i];
                continue;
            }
            else if('0' <= ch[i] && ch[i] <= '9'){
                resultCh[point++] = ch[i];
                continue;
            }
            else if(ch[i] == '-' || ch[i] == '_'){
                resultCh[point++] = ch[i];
                continue;
            } else if (ch[i] == '.'){
                if(point == 0) continue; // 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거
                if(resultCh[point-1] == '.') continue;  // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
                
                resultCh[point++] = ch[i];
                continue;
            }
        }
        
        
        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다
        if(point == 0){
            point = 3;
            resultCh = new char[] {'a','a','a'};
        } else {
            if (resultCh[point-1] == '.') point--;
        }
        
        // 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(point >= 16) {
            point = 15;
            if (resultCh[point-1] == '.') point--;
        }
        
        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙임
        if(point <= 2){
            while(point < 3){
                resultCh[point] = resultCh[(point++)-1];
            }
        }
        
        for (int i = 0 ; i < point ; i++){
            sb.append(resultCh[i]);
        }
        
        answer = sb.toString();
        
        return answer;
    }
}