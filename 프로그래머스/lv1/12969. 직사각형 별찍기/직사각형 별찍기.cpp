#include <iostream>

using namespace std;

int main(void) {
    int a;
    int b;
    cin >> a >> b;
    while(b>0){
        for(int i = a; i>0 ; i--){
            cout << "*";
        }
        cout << endl;
        b--;
    }
    return 0;
}