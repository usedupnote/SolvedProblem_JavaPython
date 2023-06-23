import sys
input = sys.stdin.readline

LS = list(input().strip())
RS = []
N = int(input())

for i in range(N) :
    order = list(input().strip())
    if order[0] == "L" :
        if len(LS) != 0 :
            RS.append(LS.pop())
    elif order[0] == "D" :
        if len(RS) != 0 :
            LS.append(RS.pop())
    elif order[0] == "B" :
        if len(LS) != 0 :
            LS.pop()
    else :
        LS.append(order[2])

for s in LS :
    print(s,end="")
for s in range(len(RS)-1, -1, -1) :
    print(RS[s],end="")