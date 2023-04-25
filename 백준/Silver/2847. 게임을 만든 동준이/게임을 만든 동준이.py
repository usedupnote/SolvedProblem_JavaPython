import sys
input = sys.stdin.readline

N = int(input())

Scores = [0 for _ in range(N)]
result = 0
for i in range(N) :
    Scores[i] = int(input())

if N != 1 :
    for i in range(1, N) :
        if Scores[N-i-1] >= Scores[N-i] :
            result += Scores[N - i - 1] - Scores[N - i] + 1
            Scores[N - i - 1] = Scores[N - i] - 1

print(result)