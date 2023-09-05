def solution(s):
    answer = ''
    cnt = 0
    for i in s :
        if i == " " :
            answer = answer + " "
            cnt = 0
        else :
            if cnt % 2 == 0 :
                answer += i.upper()
            else :
                answer += i.lower()
            cnt += 1
            
    return answer