import sys
input = sys.stdin.readline

F,S,G,U,D = map(int,input().split())

stair = [[S,0]]
v = [True for _ in range(F+1)] # 방문체크

result = -1
while len(stair) != 0 :
    st = stair.pop(0)
    if st[0] == G :
        result = st[1]
        break

    US = st[0] + U
    DS = st[0] - D
    if US <= F and v[US]:
        stair.append([US, st[1] + 1])
        v[US] = False
    if DS > 0 and v[DS]:
        stair.append([DS, st[1] + 1])
        v[DS] = False

print("use the stairs" if result == -1 else result)