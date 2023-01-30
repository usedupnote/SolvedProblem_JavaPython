import sys
input = sys.stdin.readline

N = int(input())

meeting = []

for i in range(N):
    meeting.append(list(map(int, input().split())))

meeting.sort(key=lambda x: x[0])
meeting.sort(key=lambda x: x[1])

result = 0

check = 0

for i in meeting:
    if check <= i[0] :
        check = i[1]
        result += 1

print(result)