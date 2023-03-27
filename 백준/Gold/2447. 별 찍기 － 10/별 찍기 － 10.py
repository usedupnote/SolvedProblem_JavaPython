import sys
input = sys.stdin.readline

N = int(input())

starmap = [[] for _ in range(N)]

def star(x, cnt) :
    if(cnt == 1) :
        starmap[x].append("*")
        return

    for i in range(3) :
        for j in range(3) :
            if i==1 and j == 1 :
                for k in range(cnt//3) :
                    starmap[x + (i * cnt//3) + k].append(" " * (cnt//3))
            else :
                star(x + (i * cnt//3), cnt//3)

star(0,N)

for i in range(N) :
    print(str(starmap[i]).replace("['","").replace("']","").replace("', '",""))