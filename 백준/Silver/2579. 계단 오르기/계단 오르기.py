import sys
input = sys.stdin.readline

N = int(input())

stairScore = []

for i in range(N) :
    stairScore.append(int(input()))

score = [0 for _ in range(N)]

score[0] = stairScore[0]
if N >= 2 :
    score[1] = stairScore[1] + score[0]
if N >= 3 :
    score[2] = stairScore[2] + max(score[0], stairScore[1])
if N >= 4 :
    for i in range(3, N) :
        score[i] = stairScore[i] + max(stairScore[i-1] + score[i-3], score[i-2])
print(score[N-1])