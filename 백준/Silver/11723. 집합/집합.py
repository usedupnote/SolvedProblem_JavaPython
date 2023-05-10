import sys
input = sys.stdin.readline

N = int(input())

S = [0 for i in range(21)]

for i in range(N) :
    x = input().strip()
    if x == "all" :
        S = [i for i in range(21)]
    elif x == "empty" :
        S = [0 for i in range(21)]
    else :
        x = x.split()
        n = int(x[1])
        if x[0] == "add" :
            S[n] = n
        elif x[0] == "remove" :
            S[n] = 0
        elif x[0] == "check" :
            if S[n] == 0 :
                print(0)
            else :
                print(1)
        elif x[0] == "toggle" :
            if S[n] == 0 :
                S[n] = n
            else :
                S[n] = 0