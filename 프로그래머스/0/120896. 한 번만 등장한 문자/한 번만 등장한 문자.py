def solution(s):
    answer = ''
    listA = [0 for _ in range(26)]

    for i in s:
        listA[ord(i) - ord('a')] += 1
        
    for i, num in enumerate(listA):
        if num == 1:
            answer += chr(i + ord('a'))
            
    return answer