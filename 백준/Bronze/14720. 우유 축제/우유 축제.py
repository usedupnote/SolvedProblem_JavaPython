import sys

N = int(sys.stdin.readline())
store = list(map(int, sys.stdin.readline().split()))

milk = [0, 1, 2]

result = 0
count = 0

for i in store :
    if i == count :
        result += 1
        count = (count + 1) % 3
print(result)