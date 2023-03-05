import sys
input = sys.stdin.readline

N, M = map(int, input().split())

q = [N]

v = [0] * 100002

while q[0] != M :
    poll = q.pop(0)
    for i in [poll + 1, poll - 1, poll * 2] :
        if 0<=i and i <= 100001 and v[i] == 0 :
                v[i] = v[poll] + 1
                q.append(i)

print(v[M])