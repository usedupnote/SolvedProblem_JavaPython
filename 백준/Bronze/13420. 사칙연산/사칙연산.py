import sys
input = sys.stdin.readline

N = int(input())

for i in range(N) :
    data = list(input().split())

    result = 0

    if data[1] == '+' :
        result = int(data[0]) + int(data[2])

    elif data[1] == '-' :
        result = int(data[0]) - int(data[2])

    elif data[1] == '*' :
        result = int(data[0]) * int(data[2])

    elif data[1] == '/' :
        result = int(data[0]) // int(data[2])

    print("correct" if result == int(data[4]) else "wrong answer")