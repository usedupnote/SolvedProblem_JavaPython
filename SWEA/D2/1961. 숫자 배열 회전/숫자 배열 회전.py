T = int(input())

for i in range(1, T + 1):
    N = int(input())

    matrix = []

    matrixRotate090 = []
    matrixRotate180 = []
    matrixRotate270 = []

    for j in range(N):
        matrix.append(list(input().split()))

    for j in range(N):
        matrixRotate090.append(matrix[k][j] for k in range(N-1, -1, -1))
        matrixRotate180.append(matrix[N - j - 1][k] for k in range(N-1, -1, -1))
        matrixRotate270.append(matrix[k][N - j - 1] for k in range(N))

    print("#{}".format(i))

    for j in range(N):
        print(*matrixRotate090[j], sep="", end=" ")
        print(*matrixRotate180[j], sep="", end=" ")
        print(*matrixRotate270[j], sep="")