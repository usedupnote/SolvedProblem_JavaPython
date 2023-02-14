import sys
input = sys.stdin.readline

result = []
count = 0

for i in range(5) :
    result.append(list(input().strip()))
    count = max(len(result[i]), count)

for i in range(count) :
    for i in range(5):
        try:
            print(result[i].pop(0), end="")
        except:
            continue