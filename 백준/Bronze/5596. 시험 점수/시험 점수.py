import sys
input = sys.stdin.readline

score1 = map(int, input().split())
score2 = map(int, input().split())

print(max(sum(score1), sum(score2)))