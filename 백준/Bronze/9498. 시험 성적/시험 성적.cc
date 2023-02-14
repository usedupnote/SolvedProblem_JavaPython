#include <iostream>
using namespace std;

int main(){
    int point;
    cin >> point;
    
    if (point >= 90){
        cout << "A" << endl;
    } else if(point >= 80) {
        cout << "B" << endl;
    } else if(point >= 70) {
        cout << "C" << endl;
    } else if(point >= 60){
        cout << "D" << endl;
    } else{
        cout << "F" << endl;
    }
        
    return 0;
}