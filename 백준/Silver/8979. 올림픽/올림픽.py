import sys
input = sys.stdin.readline

N, K = map(int,input().split())

win = []
con = []
comp = []

for i in range(N) :
    con.append(list(map(int, input().split())))
    if con[i][0] == K :
        comp = con[i]

con.sort(key= lambda x : (-x[1], -x[2], -x[3]))

for i in range(1,4) :
    cLen = len(con)
    for c in range(cLen):
        p = con.pop(0)
    if p[i] > comp[i]:
        win.append(p)
    elif p[i] == comp[i]:
        con.append(p)

print(len(win)+1)