import sys
input = sys.stdin.readline

T = int(input())

LCM, GCD = [], []

for i in range(T) :
    num = list(map(int, input().split()))

    num.sort()

    if num[0] == num[1] :
        LCM.append(num[0])
        GCD.append(num[0]) 
    else :
        for j in range(num[1], 0, -1) :
            if (num[0] % j) + (num[1] % j) == 0 :
                GCD.append(j)
                LCM.append((num[0] * num[1]) // j)

                break
    
for i in range(T) :
    print(LCM[i], GCD[i])