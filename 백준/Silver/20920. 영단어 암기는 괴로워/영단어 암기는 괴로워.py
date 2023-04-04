import sys
input = sys.stdin.readline
n, length = map(int, input().split())
d = {}
for i in range(n):
    voca = input()
    if len(voca) <= length: continue
    if voca in d.keys():
        d[voca] += 1
    else:
        d[voca] = 1
result = sorted(d.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))

for i in result:
    print(i[0], end="")