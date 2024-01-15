def solution(number):
    answer = 0
    
    count = 0
    for i in range(len(number)) :
        count += int(number[i])
        
    answer = count%9
    return answer