def solution(my_string, is_prefix):
    answer = 0
    if my_string[:len(is_prefix)] == is_prefix :
        answer = 1
    return answer