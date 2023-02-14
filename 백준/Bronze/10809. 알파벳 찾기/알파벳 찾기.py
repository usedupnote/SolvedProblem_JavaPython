S = list(input())

count = []

for i in range(26) :
    count.append(-1)

for i in range(len(S)) :
    checker = ord(S[i]) - ord("a")
    if count[checker] == -1 :
        count[checker] = i

for i in range(26) :
    print(count[i], end = " ")
