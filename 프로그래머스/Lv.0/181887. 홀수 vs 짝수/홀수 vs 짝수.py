def solution(num_list):
    answer = 0
    
    odd = 0
    even = 0
    
    for i in range(len(num_list)) :
        if i % 2 == 0:
            even += num_list[i]
        else:
            odd += num_list[i]
            
    if even > odd :
        answer = even
    else :
        answer = odd
    return answer