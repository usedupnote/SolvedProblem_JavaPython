def solution(num_list):
    answer = num_list
    length = len(num_list)-1
    compare = num_list[length] - num_list[length-1]
    
    if compare > 0 :
        answer.append(compare)
    else :
        answer.append(num_list[length] * 2)
    return answer