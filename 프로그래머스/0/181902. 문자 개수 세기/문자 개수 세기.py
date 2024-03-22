def solution(my_string):
    answer = [0 for _ in range(58)]
    for i in my_string:
        answer[ord(i) - ord("A")] += 1
    return answer[:26] + answer[32:]