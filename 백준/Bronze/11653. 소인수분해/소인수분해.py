import sys

N = int(sys.stdin.readline())

check = 2

while N > 1 :
    if N % check == 0 :
        print(check)
        N //= check
    else :
        check += 1