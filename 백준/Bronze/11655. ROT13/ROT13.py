import sys

input = sys.stdin.readline

S = list(input())

for i in S :
    if (i >= "A" and i <= "M") or (i >= "a" and i <= "m") :
        print(chr(ord(i) + 13), end="")
    elif (i >= "N" and i <= "Z") or (i >= "n" and i <= "z") :
        print(chr(ord(i) - 13), end="")
    else :
        print(i, end="")