import sys
input = sys.stdin.readline

Jinho = input().strip()
T = int(input())

MBTI = []

for i in range(T) :
    MBTI.append(input().strip())

print(MBTI.count(Jinho))