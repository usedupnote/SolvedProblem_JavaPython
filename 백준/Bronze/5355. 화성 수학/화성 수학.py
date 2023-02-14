import sys

T = int(sys.stdin.readline())

for i in range(T) :
    num = list(sys.stdin.readline().split())
    result = float(num[0])

    for j in num[1:] :
        if j == "@" : result *= 3
        elif j == "%" : result += 5
        elif j == "#" : result -= 7

    print(format(result, "0.2f"))