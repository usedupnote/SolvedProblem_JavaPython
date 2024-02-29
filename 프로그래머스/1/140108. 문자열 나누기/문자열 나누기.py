def solution(s):
    answer = 0
    cnt1 = 0
    cnt2 = 0

    for i in s:
        if cnt1 == cnt2 :
            cha = i
            answer += 1
            
        if i == cha:
            cnt1 += 1
        else :
            cnt2 += 1
        
    return answer