#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    int len = arr.size();               //순환을 위한 수
    
    answer.push_back(arr[0]);           //첫 기준 숫자
    
    if(len < 2) return answer;          //반복문을 돌 수 없는 길이의 경우 반환
    
    for(int i = 1; i < len ; i++){      //모든 길이를 돌면서 답변의 
        if(answer.back() != arr[i]){    //마지막 숫자랑 다른지 판단
            answer.push_back(arr[i]);   //다르면 넣고 아니면 pass
        }
    }
    return answer;
}