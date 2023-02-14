import sys
input = sys.stdin.readline

result = []

word = list(input().strip())

length = len(word)

for i in range(length):
    result.append(word[i:])
    result[i] = "".join(result[i])

result.sort()

print(*result, sep="\n")