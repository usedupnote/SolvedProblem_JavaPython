import sys
input = sys.stdin.readline

N = int(input())

num = []
cnt = [0 for _ in range(4)]
for i in range(6) :
    num.append(list(map(int, input().split())))
    num[i][0] -= 1
    cnt[num[i][0]] += 1

result = [0 for _ in range(4)]
while len(num) != 0 :
    p = num.pop(0)
    if cnt[p[0]] == 1 :
        result[p[0]] = p[1]
        cnt[p[0]] = 0
        if len(num) != 0 and cnt[num[0][0]] == 2 :
            p0 = num.pop(0)
            p1 = num.pop(0)
            p2 = num.pop(0)
            p3 = num.pop(0)
            result[p1[0]] = p1[1]
            result[p2[0]] = p2[1]
            cnt[p0[0]] = 0
            cnt[p1[0]] = 0
        continue
    elif cnt[p[0]] == 2 :
        num.append(p)
maxV = max(result[0], result[1]) * max(result[2], result[3])
minV = min(result[0], result[1]) * min(result[2], result[3])
print(N * abs(maxV - minV))