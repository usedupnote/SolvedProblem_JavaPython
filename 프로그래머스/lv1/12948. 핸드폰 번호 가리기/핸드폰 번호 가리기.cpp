#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = "";
    int len = phone_number.length();
    
    for(int i = 0; i < (len-4) ; i++){
        answer += "*";
    }
    
    answer += phone_number.substr(len-4, len);
    
    return answer;
}