#include <iostream>
using namespace std;

int main(){
    int match;
    int firstNum, SecondNum;
    int checkingNum = 1;
    
    cin>> match;
    
    for(int i = 0 ; i < match ; i++){
        cin >> firstNum >> SecondNum;
        
        for(int j = 0 ; j<SecondNum ; j++){
            checkingNum = (firstNum * checkingNum) % 10;
            if(checkingNum==0) break;
        }
        
        if(checkingNum == 0){ checkingNum = 10; }
        cout << checkingNum << endl;
        checkingNum = 1;
    }
    return 0;
}