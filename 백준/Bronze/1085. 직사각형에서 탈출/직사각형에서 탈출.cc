#include <iostream>
using namespace std;

int minimum(int a, int b){
    if(a<b){
        return a;
    } else{
        return b;
    }
}

int main(){
    int x, y, w, h;
    int min;
    
    cin >> x >> y >> w >> h;
    
    min = minimum(minimum(x,y),minimum(w-x,h-y));
    
    cout << min;
    return 0;
}