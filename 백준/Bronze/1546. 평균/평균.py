N = int(input())

score = input().split()

for i in range(N) :
    score[i] = int(score[i])

maximum = max(score)

print(sum(score) / (maximum * N) * 100)