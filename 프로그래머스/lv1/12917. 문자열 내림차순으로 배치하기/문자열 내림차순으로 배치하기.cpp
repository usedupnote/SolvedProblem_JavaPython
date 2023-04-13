#include <string>
#include <vector>
#include <iostream>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    vector<string> checker;
    
    for(int i = 0 ; i < s.length() ; i++){
        checker.push_back(s.substr(i,1));
    }
    
    sort(checker.begin(), checker.end(), greater<string>());
    
    for(int i = 0 ; i < s.length() ; i++){
        answer += checker[i];
    }
    
    return answer;
}