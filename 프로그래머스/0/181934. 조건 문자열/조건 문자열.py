def solution(ineq, eq, n, m):
    answer = 0
    if n == m :
        if eq == "=" :
            answer = 1
    else :
        if ineq == ">" :
            if n > m :
                answer = 1
        else :
            if n < m :
                answer = 1
            
    return answer