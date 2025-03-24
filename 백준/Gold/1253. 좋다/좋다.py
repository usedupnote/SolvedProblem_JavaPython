import sys
input = sys.stdin.readline

result = []
N = int(input())
num = list(map(int, input().split()))
num.sort()

dicNum = {}
for n in num:
    if n in dicNum :
        dicNum[n] += 1
    else :
        dicNum[n] = 1

for i in range(N) :
    for j in range(N) :
        if i == j :
            continue

        if num[i] - num[j] in dicNum :
            if num[i] == num[j]:
                if dicNum[num[i] - num[j]] > 2:
                    result.append(num[i])
                    break
            elif num[i] - num[j] == num[j] or num[i] - num[j] == num[i]:
                if dicNum[num[i] - num[j]] > 1:
                    result.append(num[i])
                    break
            else :
                result.append(num[i])
                break

print(len(result))