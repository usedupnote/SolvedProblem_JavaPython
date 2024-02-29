def solution(cards1, cards2, goal):
    answer = "Yes"
    cnt1 = 0
    cnt2 = 0
    
    lenC1 = len(cards1)
    lenC2 = len(cards2)
    
    for i in goal:
        if cnt1 < lenC1 and cards1[cnt1] == i:
            cnt1 += 1
        elif cnt2 < lenC2 and cards2[cnt2] == i:
            cnt2 += 1
        else :
            answer = "No"
            break
    return answer