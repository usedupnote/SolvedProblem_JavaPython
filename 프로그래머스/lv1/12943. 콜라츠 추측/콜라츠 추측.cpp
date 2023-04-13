#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    long long cnt = num;
    for(;;){
        if(answer < 500 && cnt != 1){
            if(cnt%2 == 0) cnt = cnt/2;
            else cnt = (cnt*3) +1;
            answer += 1;
        } else break;
    }
    if(answer >= 500) answer = -1;
    return answer;
}