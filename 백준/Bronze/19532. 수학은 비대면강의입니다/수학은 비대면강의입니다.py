import sys
input = sys.stdin.readline

a,b,c,d,e,f = map(int, input().split())

def calculation() :
    for i in range(1000):
        for j in range(-1, 2, 2):
            for k in range(1000):
                for l in range(-1, 2, 2):
                    if (a * i * j) + (b * k * l) == c:
                        if (d * i * j) + (e * k * l) == f:
                            print(i * j, k * l)
                            return

calculation()