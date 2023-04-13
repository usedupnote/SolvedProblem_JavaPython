#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1;
    
    if(n == 1){
        return answer;
    }
    
    int start_num = 0;
    int next_num = 1;
    int sample_num = 0;
    
    for(int i = 2; i <= n ; i++){
        sample_num = next_num;
        next_num += start_num;
        start_num = sample_num;
        start_num = start_num % 1234567;
        next_num = next_num % 1234567;
    }
    answer = next_num % 1234567;
    
    return answer;
}