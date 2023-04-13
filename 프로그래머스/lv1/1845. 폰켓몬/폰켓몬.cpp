#include <vector>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    int len = nums.size();
    vector<bool> check(200000);
    
    for(int i = 0; i < len ; i++){
        if(answer >= len/2) break;
        if(check[nums[i]] == false){
            check[nums[i]] = true;
            answer++;
        }
    }
    
    return answer;
}