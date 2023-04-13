#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 1;
    int cnt = 0;

    if(n == 1) return answer;

    for(int i = 1 ; i <= (n/2)+1 ; i++){
        cnt = 0;
        for(int j = i ; j <= n ; j++){
            if(cnt < n){
                cnt += j;
            } else if (cnt == n){
                answer++;
                break;
            } else {
                break;
            }
        }
    }
    return answer;
}