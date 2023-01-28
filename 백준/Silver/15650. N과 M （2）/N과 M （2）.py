import sys
input = sys.stdin.readline

N, M = map(int, input().split())

s = []

def NandM(point) :
    point += 1

    for i in range(point, N + 1) :
        s.append(i)

        if (len(s) == M) :
            print(*s, sep=" ")
        else :
            NandM(i)
            
        s.pop()

NandM(0)