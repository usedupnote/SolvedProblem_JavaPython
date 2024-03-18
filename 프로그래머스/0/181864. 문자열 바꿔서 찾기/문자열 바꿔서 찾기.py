def solution(myString, pat):
    return int(pat.replace("A","C").replace("B","A").replace("C","B") in myString)