#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    int total = (brown +4) / 2;
    
    for(int i = 3 ; i <= total/2 ; i++){
        if(i * (total-i) - brown == yellow){
            answer.insert(answer.begin(), total-i);
            answer.insert(answer.begin()+1, i);
        }
    }
    
    return answer;
}