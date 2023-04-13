#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.length();                    //결과로 출력될 값에 기본길이 투입
        
    for(int i = 1 ; i <= s.length()/2 ; i++){       //여기서 길이가 1개부터 전체의 절반길이까지 나눠서 비교하는 반복
        
        int pos = 0;                            //이건 지금 어디를 압축할 것인지 아는 포인터
        int len = s.length();                   //현재 압축하고 있는 압축문자열의 길이(짧은지 비고를 위해서 만듦)
        
        for (;;){                                   //여기서 비교 시작
            
            string unit = s.substr(pos, i);     //pos 위치에서 i길이만큼 잘라서 unit에 저장
            pos += i;                           //pos을 다음 위치로 이동
            
            if(pos >= s.length()) break;        //pos이 범위 밖이면 break
            
            int cnt = 0;                        //몇 번이나 압축했는지 이곳에 저장
            
            for(;;){                                //앞에서 자른 unit으로 카운팅 반복
                if(unit.compare(s.substr(pos,i)) == 0){
                    pos += i;                   //pos을 다음 위치로 이동
                    cnt++;                      //반복횟수를 cnt에 저장
                } else break;                   //반복되지 않으면 for 문을 break
            }
            
            if (cnt > 0){                           //한 번이라도 반복된 값이 있을 때 실행
                len -= i*cnt;                   //len에 압축되서 지워진 길이 제거
                
                if (cnt < 9){                   //반복된 횟수에 따라 반복된 횟수 기록한 수만큼 길이 추가
                    len += 1;
                } else if (cnt < 99){
                    len += 2;
                } else if (cnt < 999){
                    len += 3;
                } else {
                    len += 4;
                }
            }
        }
        answer = min(len, answer);                  //상기 과정을 반복해서 나온 최종 길이와 현재 저장된 최저길이를 비교
    }
    return answer;
}