import sys
input = sys.stdin.readline

N, M = map(int, input().split())

arr = []

for i in range(N) :
    arr.append(list(map(int, input().split())))

T = int(input())


for test_case in range(T) :
    i, j, x, y = map(int, input().split())

    i -= 1
    j -= 1

    result = 0

    for a in range(i, x) :
        result += sum(arr[a][j:y])

    print(result)