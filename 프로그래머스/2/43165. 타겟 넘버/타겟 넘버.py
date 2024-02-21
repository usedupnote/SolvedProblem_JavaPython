def dfs(answer, result, numbers, target, numberLen, pos):
    if pos == numberLen:
        if result == target :
            return answer + 1
        else :
            return answer

    answer = dfs(answer, result + numbers[pos], numbers, target, numberLen, pos+1)
    answer = dfs(answer, result - numbers[pos], numbers, target, numberLen, pos+1)
    
    return answer

def solution(numbers, target):
    answer = 0
    numberLen = len(numbers)
    answer = dfs(0, 0, numbers, target, numberLen, 0)
    
    return answer