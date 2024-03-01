def solution(my_string):
    answer = []
    for i in my_string:
        if 48 <= ord(i) < 58 :
            answer.append(int(i))
            
    return sorted(answer)