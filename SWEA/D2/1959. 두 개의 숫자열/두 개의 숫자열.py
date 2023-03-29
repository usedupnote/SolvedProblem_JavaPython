
T = int(input())

for i in range(1, T + 1) :
    N, M = map(int, input().split())

    A = list(map(int, input().split()))
    B = list(map(int, input().split()))

    result = 0

    if N > M :
        for j in range(N - M + 1):

            check = 0
            for k in range(M):
                check += A[j + k] * B[k]
            result = max(check, result)
    else:
        for j in range(M - N + 1):
            check = 0
            for k in range(N):
                check += B[j + k] * A[k]
            result = max(check, result)

    print("#{} {}".format(i, result))