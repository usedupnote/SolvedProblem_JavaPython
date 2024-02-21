def solution(number, k):
    answer = ''
    nLen = len(number) - k
    pos = 0
        
    for i in range(nLen) :
        cur = number[pos:k+i+1]
        for j in range(9, -1, -1) :
            if cur.find(str(j)) != -1 :
                answer += str(j)
                pos += cur.find(str(j)) + 1
                break
    return answer