def solution(arr, k):
    answer = [-1 for _ in range(k)]
    
    pos = 0
    
    setNum = set()
    
    for num in arr:
        if pos >= k:
            break
        if num not in answer:
            setNum.add(num)
            answer[pos] = num
            pos += 1
    
    return answer