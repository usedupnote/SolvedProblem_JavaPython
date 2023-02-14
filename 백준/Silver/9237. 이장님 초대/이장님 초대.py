import sys

N = int(sys.stdin.readline().strip())

tree = list(map(int, sys.stdin.readline().strip().split()))
tree.sort(reverse=True)

result = 0

for i in tree :
    N -= 1
    result = max(result, i - N)

print(result + len(tree) + 1)