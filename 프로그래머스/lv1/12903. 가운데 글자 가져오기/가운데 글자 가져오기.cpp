#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";
    
    int i = s.length()/2;
    
    if((s.length()%2) == 0){
        return answer = s.substr(i-1, 2);
    } else{
        return answer = s[i];
    }
}