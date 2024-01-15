def solution(myString, pat):
    myString = myString.lower();
    pat = pat.lower();
    answer = 1
    if myString.find(pat) < 0 :
        answer = 0
    return answer