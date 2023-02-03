import sys

N = int(sys.stdin.readline())

num = []

for i in range(N):
   num.append(int(sys.stdin.readline()))
num.sort()

for i in range(N) :
    print(num[i])