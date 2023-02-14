import sys

T = int(sys.stdin.readline())

for i in range(T) :
    num1, num2 = sys.stdin.readline().split()

    num1 = int(num1)
    num2 = int(num2)

    print(num1 + num2)