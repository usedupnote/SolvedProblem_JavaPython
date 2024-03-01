def solution(my_string, num1, num2):
    return ''.join([my_string[:num1], my_string[num2], my_string[num1+1:num2], my_string[num1], my_string[num2+1:]])