#include <iostream>
using namespace std;

int main(){
    double firstInput, secondInput;
    
    cin>>firstInput;
    cin>>secondInput;
    
    cout.precision(15);
    cout<<(firstInput/secondInput)<<endl;
    
    return 0;
}