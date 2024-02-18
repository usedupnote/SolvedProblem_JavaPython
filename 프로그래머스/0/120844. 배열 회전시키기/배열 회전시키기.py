def solution(numbers, direction):
    answer = []
    if direction == "right" :
        pop = numbers.pop()
        answer.append(pop)
        answer += numbers
    if direction == "left" :
        pop = numbers.pop(0)
        answer += numbers
        answer.append(pop)
    return answer