import sys
input = sys.stdin.readline

num = []

def NandM(n, m) :
    if m == 0 :
        print(*num)
        return
    for i in range(N) :
        num.append(i + 1)
        NandM(i, m - 1)
        num.pop()

N, M = map(int, input().split())

NandM(N, M)