def solution(numbers):
    numbers.sort()
    answer = numbers[0] * numbers[1]
    length = len(numbers) - 1
    if answer < numbers[length] * numbers[length-1] :
        answer = numbers[length] * numbers[length-1]
    return answer