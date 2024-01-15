def solution(num_list):
    answer = 0
    
    s = sum(num_list)
    s *= s
    m = 1
    
    for i in num_list :
        m *= i
        
    if s > m :
        answer = 1
        
    return answer