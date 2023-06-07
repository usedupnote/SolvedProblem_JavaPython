import sys
input = sys.stdin.readline

T = int(input())

for TC in range(T) :
    N, D = map(int, input().split())

    result = 0

    for i in range(N) :
        v,f,c = map(int,input().split())
        if D <= v * f / c :
            result += 1
            
    print(result)
