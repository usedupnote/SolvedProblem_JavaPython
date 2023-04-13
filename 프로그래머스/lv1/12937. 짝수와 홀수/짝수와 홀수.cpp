#include <string>
#include <vector>

using namespace std;

string solution(int num) {
    string answer = "";
    if(num%2 == 0) return answer = "Even";
    else return answer = "Odd";
}