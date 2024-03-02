def solution(n):
    answer = []
    point = 2
    while point <= n :
        if n % point == 0:
            answer.append(point)
            while n % point == 0:
                n //= point
        else :
            point += 1
    return answer