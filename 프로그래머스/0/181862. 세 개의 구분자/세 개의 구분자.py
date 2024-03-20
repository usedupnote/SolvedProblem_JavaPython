def solution(myStr):
    answer = []
    cur = 0
    for i, ch in enumerate(myStr):
        if ch == "a" or ch == "b" or ch == "c":
            if cur != i:
                answer.append(myStr[cur:i])
            cur = i+1
    
    if cur != len(myStr):
        answer.append(myStr[cur:])
    
    return ["EMPTY"] if not answer else answer