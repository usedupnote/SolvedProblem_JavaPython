import sys
input = sys.stdin.readline

for case in range(2) :
    result = 0
    num = []
    for i in range(10) :
        num.append(int(input()))
    num.sort(reverse = True)
    for i in range(3) :
        result += num[i]
    print(result, end=" ")
