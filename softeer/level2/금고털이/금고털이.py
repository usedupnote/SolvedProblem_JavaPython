import sys
input = sys.stdin.readline

W, N = map(int, input().split())

result = 0

jewel = []

for i in range(N) :
    jewel.append(list(map(int, input().split())))

jewel.sort(key = lambda x:x[1], reverse=True)

for i in jewel :
    if W - i[0] < 0 :
        result += W * i[1]
        break        
    else :
        W -= i[0]
        result += i[0] * i[1]

print(result)