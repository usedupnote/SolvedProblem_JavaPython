import sys

T = int(sys.stdin.readline())

count = []

for i in range(T) :
    count.append(sys.stdin.readline().strip().lower())

print("\n".join(count))