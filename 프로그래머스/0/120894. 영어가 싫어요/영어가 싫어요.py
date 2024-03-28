def solution(numbers):
    numberList = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    for i, num in enumerate(numberList):
        numbers = numbers.replace(num, str(i))
    answer = int(numbers)
    return answer