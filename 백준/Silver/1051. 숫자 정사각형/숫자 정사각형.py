import sys
input = sys.stdin.readline

N, M = map(int, input().split())

result = 1

ground = [[] for _ in range(N)]

for i in range(N) :
    ground[i] = list(input().strip())

for i in range(N) :
    for j in range(M) :

        counter = 1

        while i + counter < N and j + counter < M :
            if (ground[i + counter][j] == ground[i][j] and ground[i][j + counter] == ground[i][j] and ground[i + counter][j + counter] == ground[i][j]) :
                result = max(result, (counter + 1))

            counter += 1

print(result ** 2)