import sys
input = sys.stdin.readline

N = int(input())

minV = [0, 0, 0]
maxV = [0, 0, 0]
for _ in range(N):
    current = list(map(int, sys.stdin.readline().split()))
    minV = [current[0]+min(minV[:2]), current[1]+min(minV), current[2]+min(minV[1:])]
    maxV = [current[0]+max(maxV[:2]), current[1]+max(maxV), current[2]+max(maxV[1:])]
print(max(maxV), min(minV))