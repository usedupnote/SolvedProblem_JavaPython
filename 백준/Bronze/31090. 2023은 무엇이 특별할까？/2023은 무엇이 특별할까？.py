import sys
input = sys.stdin.readline

N = int(input())

for i in range(N) :
    year = int(input())

    print("Good" if (year + 1) % (year % 100) == 0 else "Bye")