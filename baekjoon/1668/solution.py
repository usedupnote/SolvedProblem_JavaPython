// [문제 링크]: https://www.acmicpc.net/problem/1668

N = int(input())
num = []
​
R, L = 0, 0
resultR, resultL = 0, 0
​
for i in range(N) :
    num.append(int(input()))
    if R < num[i] :
        R = num[i]
        resultR += 1
​
for i in range(N) :
    if L < num[N - 1 - i] :
        L = num[N - 1 - i]
        resultL += 1
​
print(resultR, resultL, sep="\n")