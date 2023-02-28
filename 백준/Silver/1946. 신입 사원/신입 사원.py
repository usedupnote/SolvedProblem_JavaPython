import sys
input = sys.stdin.readline

T = int(input())

for test_case in range(T) :
    N = int(input())

    num = [0 for _ in range(N)]
    for i in range(N) :
        person = list(map(int, input().split()))
        num[person[0] - 1] = person[1] - 1

    check = num[0]
    result = 1
    for i in range(1, N) :
        if(num[i] < check) :
            check = num[i]
            result += 1

    print(result)