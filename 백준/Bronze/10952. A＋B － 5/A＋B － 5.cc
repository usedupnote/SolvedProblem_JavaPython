#include <iostream>
using namespace std;

int main(){
    int a, b;
    while(1){
        cin >> a >> b;
        if(a+b <= 0) break;
        else{
            cout << a+b << endl;
        }
    }
    return 0;
}