import sys

num1 = int(sys.stdin.readline())
operator = list(sys.stdin.readline())
num2 = int(sys.stdin.readline())

result = 0

if operator[0] == "+" :
    result = num1 + num2
else :
    result = num1 * num2

print(result)