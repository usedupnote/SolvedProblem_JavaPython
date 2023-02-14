import sys
input = sys.stdin.readline
    
T = int(input())

result = 0
paper = [[0] * 100 for _ in range(100)]

for i in range(T):
    blackPaper = list(map(int, input().split()))

    for j in range(blackPaper[0], blackPaper[0] + 10) :
        for k in range(blackPaper[1], blackPaper[1] + 10) :
            paper[j][k] = 1

for i in range(100) :
    result += sum(paper[i])
print(result)