import sys
input = sys.stdin.readline

ch = list(input().strip())

ch.reverse()

print(*ch,sep="")