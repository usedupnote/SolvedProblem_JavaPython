def solution(s):
    answer = [0, 0]
    
    while len(s) != 1 :
        count_one = s.count("1")
        count_zero = len(s) - count_one
        answer = [answer[0] + 1, answer[1] + count_zero]

        s = str(bin(count_one))[2:]
    
    return answer