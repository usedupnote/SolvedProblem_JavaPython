import sys
input = sys.stdin.readline

num = list(map(int, input().split()))

while True:
    if num == [1, 2, 3, 4, 5] :
        break

    for i in range(4):
        if num[i] > num[i + 1] :
            num.append(num[i])
            num[i] = num[i + 1]
            num[i+1] = num.pop()
            print(*num)