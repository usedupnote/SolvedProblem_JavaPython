N, M = map(int, input().split())

num = list(map(int, input().split()))

num.sort()

maximum = 0

for i in range(N) :
    for j in range(i+1, N) :
        for k in range(j+1, N) :
            compare = num[i] + num[j] + num[k]
            if M < compare:
                break
            else :
                maximum = max(maximum, compare)
        if maximum == M :
            break
    if maximum == M :
        break
print(maximum)
