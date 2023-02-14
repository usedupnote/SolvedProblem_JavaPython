import sys
input = sys.stdin.readline

N = int(input())

checker = 0

print(" " * (N-1), "*", sep="")

for i in range(2, N + 1) :
    print((" " * (N - i)), "*", " " * (i * 2 - 3), "*", sep="")