def solution(my_string, is_suffix):
    l = len(is_suffix)
    
    answer = 0
    if my_string[-l:] == is_suffix :
        answer = 1
    
    return answer