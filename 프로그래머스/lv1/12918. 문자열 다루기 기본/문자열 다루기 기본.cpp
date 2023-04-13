#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool solution(string s) {
    bool answer = true;
    string s1;
    int len = s.length();
    
    if(len == 4 || len == 6){
        for(int i = 0 ; i < len; i++){
            s1 = s.substr(i,1);
            if(s[i]<'0' || s[i]>'9'){
                return answer = false;
            }
        }
    } else {
        return answer = false;
    }
    
    return answer;
}