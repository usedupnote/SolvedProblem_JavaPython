import sys
input = sys.stdin.readline

result = 0
number = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"]

text = input().strip()

for i in text:
    cnt = 2
    for j in number:
        cnt += 1
        if i in j:
            result += cnt
            break

print(result)