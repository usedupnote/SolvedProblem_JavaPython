s = []
def com(a, b):
    if b == M :
        print(*s)
        return
    for i in range(a, N + 1) :
        s[b] = i
        com(i, b+1)
        s[b] = 0

N, M = map(int, input().split())
s = [0 for _ in range(M)]

com(1, 0)