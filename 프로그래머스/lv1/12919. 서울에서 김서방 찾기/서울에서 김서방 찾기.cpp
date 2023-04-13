#include <string>
#include <vector>

using namespace std;

string solution(vector<string> seoul) {
    string answer = "김서방은 ";
    string Kim = "에 있다";
    int len = seoul.size();
    
    for(int i = 0; i < len ; i++){
        if(seoul[i] == "Kim"){
            answer += to_string(i);
            answer += Kim;
            break;
        }
    }
    return answer;
}