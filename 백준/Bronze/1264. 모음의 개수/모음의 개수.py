import sys
input = sys.stdin.readline

comp = ['a', 'e', 'i', 'o', 'u']

N = input()

while N[0] != '#' and len(N) != 1 :
    N = N.lower()

    cnt = 0

    for i in N :
        if i in comp :
            cnt+= 1
            continue

    print(cnt)
    N = input()