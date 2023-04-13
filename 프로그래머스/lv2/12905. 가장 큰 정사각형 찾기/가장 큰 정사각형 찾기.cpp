#include <iostream>
#include<vector>
using namespace std;

int solution(vector<vector<int>> board)
{
    int answer = 0;
    int low = board.size();
    int col = board[0].size();
    
    if(low < 2 || col <2) return 1;
    
    for(int i = 1 ; i < low ; i++){
        for(int j = 1; j< col ; j++){
            if(board[i][j] != 0){
                board[i][j] = min(board[i-1][j-1], min(board[i][j-1],  board[i-1][j]))+1;
                answer = max(answer, board[i][j]);
            }
        }
    }
    
    return answer *= answer;
}