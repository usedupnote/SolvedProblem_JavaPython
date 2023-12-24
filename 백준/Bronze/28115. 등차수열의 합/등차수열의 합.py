T = int(input())
num = list(map(int, input().split()))

cur = -1
state = "YES"
if T > 2 :
    cur = num[1]-num[0]
    for i in range(1, T) :
        if cur != num[i]-num[i-1] :
            state = "NO"
            break
elif (T == 2) :
    cur = num[1]-num[0]

print(state)

if state == "YES" :
    for i in range(T) :
        print(num[i], end=" ")
    print()
    for i in range(T) :
        print(0, end=" ")