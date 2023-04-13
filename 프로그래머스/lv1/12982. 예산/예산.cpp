#include <iostream>
#include <stdio.h>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> d, int budget) {
    int answer = 0;
    int pos = 0;
    
    sort(d.begin(), d.end());
    
    for(;;){
        if(pos >= d.size()) break;
        if(answer > (budget-d[pos])){
            break;
        } else {
            answer += d[pos];
            pos++;
        }
    }
    
    return pos;
}