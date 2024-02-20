def solution(s):
    answer = ''
    length = len(s)
    
    if s[0] == " " :
        answer += " "
    else :
        answer += s[0].upper()

    for i in range(1, length):
        if s[i-1] == " ":
            answer += s[i].upper()
        else :
            answer += s[i].lower()
            
    return answer