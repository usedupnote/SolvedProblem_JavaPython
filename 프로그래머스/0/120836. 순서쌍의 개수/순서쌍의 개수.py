def solution(n):
    answer = 0
    for i in range(1, n+1) :
        if n % i == 0 :
            answer += 1
            if n // i < i :
                answer = (answer - 1) * 2
                break
            elif n // i == i :
                answer = (answer * 2) - 1
                break
    return answer