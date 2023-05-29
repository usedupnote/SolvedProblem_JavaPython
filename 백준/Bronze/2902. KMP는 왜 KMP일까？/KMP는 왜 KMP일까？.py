import sys
input = sys.stdin.readline
S = input()

for i in S :
    if i.upper() != i or i == "-" :
         continue
    print(i, end="")