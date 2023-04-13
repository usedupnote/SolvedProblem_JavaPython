#include <string>
#include <vector>

using namespace std;

vector<vector<int>> solution(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    int len1 = arr1.size();
    int len2 = arr1[0].size();
    
    vector<vector<int>> answer = arr1;
    
    for(int i = 0 ; i < len1 ; i++){
        for(int j = 0; j < len2 ; j++){
            answer[i][j] += arr2[i][j];
        }
    }
    return answer;
}