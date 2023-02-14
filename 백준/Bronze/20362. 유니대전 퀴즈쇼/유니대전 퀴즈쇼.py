import sys
input = sys.stdin.readline

N, S = input().split()

N = int(N)

chattings = []
chack = ""
result = 0

for i in range(N):
    chat = list(input().split())

    if chat[0] == S :
        chack = chat[1]
        break
    else :
        chattings.append(chat)

for i in chattings :
    if i[1] == chack :
        result += 1

print(result)