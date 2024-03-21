def solution(a, b, c, d):
    answer = 0
    dic = {}
    dic[a] = 1
    
    if dic.get(b): dic[b] += 1
    else : dic[b] = 1
    
    if dic.get(c): dic[c] += 1
    else : dic[c] = 1
    
    if dic.get(d): dic[d] += 1
    else : dic[d] = 1
    
    if len(dic) == 4 :
        answer = min(a,b,c,d)
    elif len(dic) == 3:
        answer = 1
        for i in dic:
            if dic[i] == 1:
                answer *= i
    elif len(dic) == 2:
        if dic[a] == 2:
            p = 0
            q = -(a * 2)
            
            for i in dic:
                p += i
                q += i
            answer = abs(p*q)
        else :
            answer = 10
            for i in dic:
                if dic[i] == 3:
                    answer *= i
            for i in dic:
                if dic[i] == 1:
                    answer += i
            answer **= 2
    elif len(dic) == 1:
        answer = 1111 * a
    return answer