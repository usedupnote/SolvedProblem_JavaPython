import sys
input = sys.stdin.readline

N = input()

if len(N) >= 2 :
    if N[1] == 'x' :
        print(int(N[2:], 16))
    elif N[0] == '0' :
        print(int(N, 8))
    else :
        print(int(N))
else :
    print(int(N))